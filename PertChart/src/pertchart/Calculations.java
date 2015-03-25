/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

import java.util.ArrayList;

/**
 *
 * @author zac
 */
public class Calculations {
    
    protected ArrayList<Activity> activities;
    
    public Calculations() {
        activities = new ArrayList();
    }
    
    public ArrayList<Activity> generateHardCodedActivities() {
        ArrayList<Activity> activityList = new ArrayList();
        Activity a = new Activity("A", 2.0, "", 1.0);
        Activity b = new Activity("B", 1.0, "A", 2.0);
        Activity c = new Activity("C", 1.0, "A", 1.0);
        Activity d = new Activity("D", 1.0, "B", 4.0);
        Activity e = new Activity("E", 1.0, "D", 3.0);
        activityList.add(a);
        activityList.add(b);
        activityList.add(c);
        activityList.add(d);
        activityList.add(e);
        return activityList;
    }
    
    public void run() {
        
    }
    
    public void determinePredecessors() {
        for (Activity a: this.activities) {
            for (Activity b: this.activities) {
                String p = b.getPredecessorsInput();
                String[] pList = p.split(",");
                for (String s: pList) {
                    if (s != a.getActivityId()) {
                        
                    }
                }
            }
        }
    }
    
    public String getPrintedResults() {
        return "";
    }
}
