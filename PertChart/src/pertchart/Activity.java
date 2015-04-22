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
public class Activity {
    
    
    // user input
    private String activityId;
    private double a;
    private double m;
    private double b;
    private double resources;

    private String predecessorsInput;
    private ArrayList<Activity> predecessors;
    private ArrayList<Activity> successors;
    
    //To be calculated from doing the CPM portio
    private float totalSlack;
    private float freeSlack;
    private float interferingSlack;
    private float independentSlack;
    private double startTime;
    private double completionTime;
    private double expectedTime;
    private double averageStartTime;
    private double averageCompletionTime;
    private double averageVariance;
    
    Activity(String aId, double a, double m, double b, String p, double r) {
        this.activityId = aId;
        this.a = a;
        this.m = m;
        this.b = b;
        this.predecessorsInput = p;
        this.resources = r;
        this.predecessors = new ArrayList();
        this.successors = new ArrayList();
    }
    
    public Double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public Double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public Double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
    
    public Double getStartTime() {
        return this.startTime;
    }

    public void setStartTime(double a) {
        this.startTime = a;
    }
    
    public Double getCompletionTime() {
        return this.completionTime;
    }

    public void setCompletionTime(double a) {
        this.completionTime = a;
    }
    
    public ArrayList<Activity> getPredecessors(){
        return predecessors;
    }
    
    public ArrayList<Activity> getSuccessors(){
        return successors;
    }
    
    public Double getResources() {
        return resources;
    }

    public void setResources(double r) {
        this.resources = r;
    }
    
    public String getPredecessorsInput() {
        return predecessorsInput;
    }

    public void setPredecessorsInput(String p) {
        this.predecessorsInput = p;
    }
    
    public String getActivityId() {
        return this.activityId;
    }
    
    public void setActivityId(String id) {
        this.activityId = id;
    }
    
    public float getTotalSlack() {
        return this.totalSlack;
    }
    
    public void setTotalSlack(float s) {
        this.totalSlack = s;
    }
    
    public float getFreeSlack() {
        return this.freeSlack;
    }
    
    public void setFreeSlack(float s) {
        this.freeSlack = s;
    }
    
    public float getInterferingSlack() {
        return this.interferingSlack;
    }
    
    public void setInterferingSlack(float s) {
        this.interferingSlack = s;
    }
    
    public float getIndependentSlack() {
        return this.independentSlack;
    }
    
    public void setIndependentSlack(float s) {
        this.independentSlack = s;
    }
    
    public double getExpectedTime() {
        return this.expectedTime;
    }
    
    public void setExpectedTime(double d) {
        this.expectedTime = d;
    }
    
    public double getAverageStartTime() {
        return this.averageStartTime;
    }
    
    public void setAverageStartTime(double d) {
        this.averageStartTime = d;
    }
    
    public double getAverageCompletionTime() {
        return this.averageCompletionTime;
    }
    
    public void setAverageCompletionTime(double d) {
        this.averageCompletionTime = d;
    }
    
    public double getAverageVariance() {
        return this.expectedTime;
    }
    
    public void setAverageVariance(double d) {
        this.expectedTime = d;
    }
}
