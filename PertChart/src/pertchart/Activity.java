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
    private double optimisticTime;
    private double mostLikelyTime;
    private double pessimisticTime;
    private double resources;

    private String predecessorsInput;
    private ArrayList<Activity> predecessors;
    private ArrayList<Activity> successors;
    
    //To be calculated from doing the CPM portion
    private double expectedTime;
    private double earliestStartTime;
    private double latestStartTime;
    private double earliestCompletionTime;
    private double expectedCompletionTime;
    private double latestCompletionTime;
    private float totalSlack;
    private float freeSlack;
    private float interferingSlack;
    private float independentSlack;
    private double duration;
    
    Activity(String aId, double a, double m, double b, String p, double r) {
        this.activityId = aId;
        this.optimisticTime = a;
        this.mostLikelyTime = m;
        this.pessimisticTime = b;
        this.predecessorsInput = p;
        this.resources = r;
        this.predecessors = new ArrayList();
        this.successors = new ArrayList();
    }
    
    public Double getOptimisticTime() {
        return optimisticTime;
    }

    public void setOptimisticTime(double optimisticTime) {
        this.optimisticTime = optimisticTime;
    }

    public Double getMostLikelyTime() {
        return mostLikelyTime;
    }

    public void setMostLikelyTime(double mostLikelyTime) {
        this.mostLikelyTime = mostLikelyTime;
    }

    public Double getPessimisticTime() {
        return pessimisticTime;
    }

    public void setPessimisticTime(double pessimisticTime) {
        this.pessimisticTime = pessimisticTime;
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

    public Double getExpectedTime() {
        return this.expectedTime;
    }
    
    public void setExpectedTime(Double t) {
        this.expectedTime = t;
    }
    
    public Double getEarliestStartTime() {
        return this.earliestStartTime;
    }
    
    public void setEarliestStartTime(Double t) {
        this.earliestStartTime = t;
    }
    
    public Double getLatestStartTime() {
        return this.latestStartTime;
    }
    
    public void setLatestStartTime(Double t) {
        this.latestStartTime = t;
    }
    
    public Double getEarliestCompletionTime() {
        return this.earliestCompletionTime;
    }
    
    public void setEarliestCompletionTime(Double t) {
        this.earliestCompletionTime = t;
    }
    
    public Double getExpectedCompletionTime() {
        return this.expectedCompletionTime;
    }
    
    public void setExpectedCompletionTime(Double t) {
        this.expectedCompletionTime = t;
    }
            
    public Double getLatestCompletionTime() {
        return this.latestCompletionTime;
    }
    
    public void setLatestCompletionTime(Double t) {
        this.latestCompletionTime = t;
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
    
    public double getDuration() {
        return this.duration;
    }
    
    public void setDuration(double d) {
        this.duration = d;
    }
}
