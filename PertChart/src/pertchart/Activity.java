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
    
    private String activityId;
    private String description;
    private double optimisticTime;
    private double mostLikelyTimeTime;
    private double pessimisticTime;
    private ArrayList<Activity> predecessors;
    private ArrayList<Activity> successors;
    private double duration;
    private double deadline;
    private double earliestStartTime;
    private double latestStartTime;
    private double earliestCompletionTime;
    private double expectedCompletionTime;
    private double latestCompletionTime;
    private float totalSlack;
    private float freeSlack;
    private float interferingSlack;
    private float independentSlack;
    
    public String getActivityId() {
        return this.activityId;
    }
    
    public void setActivityId(String id) {
        this.activityId = id;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String d) {
        this.description = d;
    }
    
    public Double getOptimisticTime() {
        return this.optimisticTime;
    }
    
    public void setOptimisticTime(Double t) {
        this.optimisticTime = t;
    }
    
    public Double getMostLikelyTimeTime() {
        return this.mostLikelyTimeTime;
    }
    
    public void setMostLikelyTimeTime(Double t) {
        this.mostLikelyTimeTime = t;
    }
    
    public Double getPessimisticTime() {
        return this.pessimisticTime;
    }
    
    public void setPessimisticTime(Double t) {
        this.pessimisticTime = t;
    }
    
    public Double getDuration() {
        return this.duration;
    }
    
    public void setDuration(Double t) {
        this.duration = t;
    }
    
    public Double getDeadline() {
        return this.deadline;
    }
    
    public void setDeadline(Double t) {
        this.deadline = t;
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
}
