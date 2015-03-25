/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertchart;

/**
 *
 * @author zac
 */
public class Project {
    //We need to input these
    private double optimisticTime;
    private double mostLikelyTime;
    private double pessimisticTime;
    private String durationInterval;

    private double duration;
    private double probabilityByDeadline;
    private float totalMinSlack;
    
    private double specifiedDeadline;
    private double probabilityOnTime;
    private double expectedDuration;
    private double expectedDurationStandardDeviation;
    
    Project(double a, double m, double b, String di) {
        this.optimisticTime = a;
        this.mostLikelyTime = m;
        this.pessimisticTime = b;
        this.durationInterval = di;
    }
    
    public String getDurationInterval() {
        return durationInterval;
    }

    public void setDurationInterval(String durationInterval) {
        this.durationInterval = durationInterval;
    }
    
    public Double getDuration() {
        return this.duration;
    }
    
    public void setDuration(Double t) {
        this.duration = t;
    }
    
    public Double getProbabilityOnTime() {
        return this.probabilityOnTime;
    }
    
    public void setProbabilityOnTime(Double t) {
        this.probabilityOnTime = t;
    }
    
    public Double getProbabilityByDeadline() {
        return this.probabilityByDeadline;
    }
    
    public void setProbabilityByDeadline(Double t) {
        this.probabilityByDeadline = t;
    }
    
    public Float getTotalMinSlack() {
        return this.totalMinSlack;
    }
    
    public void setTotalMinSlack(Float s) {
        this.totalMinSlack = s;
    }
    
    public Double getSpecifiedDeadline() {
        return this.specifiedDeadline;
    }
    
    public void setSpecifiedDeadline(Double t) {
        this.specifiedDeadline = t;
    }
    
    public Double getExpectedDuration() {
        return this.expectedDuration;
    }
    
    public void setExpectedDuration(Double t) {
        this.expectedDuration = t;
    }
    
    public Double getExpectedDurationStandardDeviation() {
        return this.expectedDurationStandardDeviation;
    }
    
    public void setExpectedDurationStandardDeviation(Double t) {
        this.expectedDurationStandardDeviation = t;
    }
    
     public Double getOptimisticTime() {
        return this.optimisticTime;
    }
    
    public void setOptimisticTime(Double t) {
        this.optimisticTime = t;
    }
    
    public Double getMostLikelyTime() {
        return this.mostLikelyTime;
    }
    
    public void setMostLikelyTime(Double t) {
        this.mostLikelyTime = t;
    }
    
    public Double getPessimisticTime() {
        return this.pessimisticTime;
    }
    
    public void setPessimisticTime(Double t) {
        this.pessimisticTime = t;
    }
}
