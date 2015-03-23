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
    private double duration;
    private double probabilityOnTime;
    private double probabilityByDeadline;
    private float totalMinSlack;
    private double specifiedDeadline;
    private double expectedDuration;
    private double expectedDurationStandardDeviation;
    
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
}
