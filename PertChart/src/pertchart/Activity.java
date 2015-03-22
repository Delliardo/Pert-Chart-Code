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
}
