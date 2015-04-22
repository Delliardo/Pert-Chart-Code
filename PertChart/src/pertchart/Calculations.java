/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author zac
 */
public class Calculations {
    
    protected ArrayList<Activity> activities;
    private Project project;
    private final ArrayList<Activity> completedActvities =  new ArrayList();
    private final ArrayList<Activity> activitiesQueue = new ArrayList();
    private Random random = new Random();
    private ArrayList<Activity> activityResults;
    private HashMap<String, Double[]> activityMap = new HashMap<>();
    private ArrayList<Activity> simActivities;
    private String timeUnit;
    private double totalResources;
    private double averageProjectCompletionTime = 0.0;
    private double simLength = 5000000.0; // 5 million runs
    
    public Calculations(String di, int tr) {
        this.timeUnit = di;
        this.totalResources = tr;
        this.project = new Project(di, tr);
        this.activities = new ArrayList();
    }
    
    public void run() {
        determinePredecessors();
        determineSuccessors();
        generateHashMap();
        
        // run simulation
        System.out.print("Simulation running...");
        int scaler = 0;
        for (int i = 0; i < this.simLength; i++) {
            if (((double)i + 1.0) % (this.simLength / 10.0) == 0) {
                if (scaler + 1 < 10) {
                    scaler = scaler + 1;
                    System.out.print((10 * scaler)  + "%...");
                }
                else {
                    System.out.print(100 + "%!!!");
                    System.out.println("");
                }
            }
            this.simActivities = this.activities;
            calculateActvityCompletionTime();
            calculateProjectCompletionTime();
        }
        
        // calculate the final results
        Iterator it = this.activityMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry a = (Map.Entry)it.next();
            Double[] d = (Double[])a.getValue();
            d[0] = d[0] / this.simLength;
            d[1] = d[1] / this.simLength;
            d[2] = d[2] / this.simLength;
            a.setValue(d);
        }
        
        this.averageProjectCompletionTime = this.averageProjectCompletionTime / this.simLength;
    }
    
    public void generateHashMap() {
        for (Activity a: this.activities) {
            Double[] d = {0.0, 0.0, 0.0};
            this.activityMap.put(a.getActivityId(), d);
        }
    }
    
    public Activity getActivityById(String s) {
        Activity a = null;
        for (Activity b: this.activities) {
            if (s.equalsIgnoreCase(b.getActivityId()) == false) {
               continue;
            }
            else {
                a = b;
                break;
            }
        }
        return a;
    }
    
    public void determinePredecessors() {
        for (Activity a: this.activities) {
                String p = a.getPredecessorsInput();
                String[] pList = p.split(",");
                for (String s: pList) {
                    if (s.equalsIgnoreCase(a.getActivityId()) == false) {
                        Activity pa = getActivityById(s);
                        if (pa != null) {
                            a.getPredecessors().add(pa);
                        }
                    }
                }
        }
    }
    
    public void determineSuccessors() {
        for (Activity a: this.activities) {
            for (Activity b: this.activities) {
                ArrayList<Activity> pList  = b.getPredecessors();
                for (Activity c: pList) {
                    if (c.getActivityId().equalsIgnoreCase(a.getActivityId())) {
                        a.getSuccessors().add(b);
                        break;
                    }
                }
            }
        }
    }
    
    public void calculateActvityCompletionTime() {
        for (Activity a: this.simActivities) {
            double amb = (a.getB() + (4.0 * a.getM()) + a.getA()) / 6.0;
            double lateTimeRange = amb;
            double earlyTimeRange = amb;
            if (amb < a.getB()) {
                lateTimeRange = (amb + a.getB()) / 2.0;
            }
            if (amb > a.getA()) {
                earlyTimeRange = (amb + a.getA()) / 2.0;
            }
            double range = lateTimeRange - earlyTimeRange;
            double scaled = random.nextDouble() * range;
            double expectedTime = scaled + earlyTimeRange;
            a.setExpectedTime(expectedTime);
            
            // calculate variance
            double v = Math.pow((a.getB() - a.getA()), 2) / 36.0;
            a.setAverageVariance(v);
        }
    }
    
    public void calculateProjectCompletionTime() {
        double projectCompletionTime = 0.0;
        // push all activities that have no predecessors into the queue
        for (Activity a: this.simActivities) {
            ArrayList<Activity> pList  = a.getPredecessors();
            if (pList.size() > 0) {
                continue;
            }
            else {
                a.setStartTime(0.0);
                activitiesQueue.add(a);
            }
        }
        while (activitiesQueue.size() > 0) {
            Activity a = activitiesQueue.get(0);
            if (this.totalResources >= a.getResources()) {
                this.totalResources = this.totalResources - a.getResources();
            }
            else {
                JOptionPane.showMessageDialog(null, "There are not enough resources for this project.");
                System.exit(0);
            }
            double completionTime = a.getStartTime() + a.getExpectedTime();
            a.setCompletionTime(completionTime);
            completedActvities.add(a);

            // update our hash map for the final results
            double numOfPredecessors = a.getPredecessors().size();
            Double[] d = this.activityMap.get(a.getActivityId());
            d[0] = d[0] + a.getAverageVariance();
            if (numOfPredecessors > 1) {
                d[1] = d[1] + (a.getStartTime() / numOfPredecessors);
                d[2] = d[2] + (completionTime / numOfPredecessors);
            }
            else {
                d[1] = d[1] + a.getStartTime();
                d[2] = d[2] + completionTime;
            }
            this.activityMap.put(a.getActivityId(), d);

            // check if this activities completion time is higher than the project's
            if (completionTime > projectCompletionTime) {
                projectCompletionTime = completionTime;
            }

            // push next activities into queue whose successors have finished
            for (Activity successor: a.getSuccessors()) {
                ArrayList<Activity> predecessorList = successor.getPredecessors();
                int pListL = predecessorList.size();
                int completedPredecessors = 0;
                double maxPredecessorCompletionTime = 0.0;
                for (int i = 0; i < pListL; i++) {
                    Activity predecessor = predecessorList.get(i);
                    if (activityHasBeenCompleted(predecessor.getActivityId())) {
                        completedPredecessors = completedPredecessors + 1;
                        if (maxPredecessorCompletionTime < predecessor.getCompletionTime()) {
                            maxPredecessorCompletionTime = predecessor.getCompletionTime();
                        }
                    }
                }

                // if all predecessors have been completed then push the successor into the queue
                if (completedPredecessors == pListL) {
                    successor.setStartTime(maxPredecessorCompletionTime);
                    activitiesQueue.add(successor);
                }
            }
            this.totalResources = this.totalResources + a.getResources();
            // its now safe to remove the activity
            activitiesQueue.remove(0);
        }
        this.averageProjectCompletionTime = this.averageProjectCompletionTime + projectCompletionTime;
        project.setCompletionTime(projectCompletionTime);
    }
    
    public boolean activityHasBeenCompleted(String id) {
        boolean completed = false;
        int len = completedActvities.size();
        for (int i = 0; i < len; i++) {
            Activity completedActivity = completedActvities.get(i);
            if (completedActivity.getActivityId().equalsIgnoreCase(id) == false) {
                continue;
            }
            else {
                completed = true;
                break;
            }
        }
        return completed;
    }
    
    public HashMap<String, Double[]> getActivityResults() {
        return this.activityMap;
    }
    
    public Double getProjectCompletionTime() {
        return this.averageProjectCompletionTime;
    }
    
    public String getTimeUnit() {
        return this.timeUnit;
    }
}
