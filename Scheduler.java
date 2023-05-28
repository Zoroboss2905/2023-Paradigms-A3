// Class: Scheduler
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//


import java.util.PriorityQueue;

// Make scheduler a singleton and parse a reference to allstages

public class Scheduler {
    private double currentTime;
    private PriorityQueue<Job> jobQueue;

    private static Scheduler single_instance = null;

    private Scheduler(){
        currentTime = 0;
        jobQueue = new PriorityQueue<Job>();
    }

    public static synchronized Scheduler getInstance(){
        if (single_instance == null){
            single_instance = new Scheduler();
        }
        return single_instance;
    }

    public void setCurrentTime(double newCurrentTime){
        currentTime = newCurrentTime;
    }

    public double getCurrentTime(){
        return currentTime;
    }

    public Job getTopJob(){
        return jobQueue.peek();
    }

    public void addToPQueue(Stage stage, double duration){
        Job Job = new Job(currentTime + duration, stage);    // Create new Job that completes at current+duration.
        jobQueue.offer(Job);                                 // Insert Sort into the Priority Queue based on the completionTime.
    }

    public Job removeJob(){
        Job outputJob = jobQueue.poll();                // Takes the top job and removes it from the top of the list.
        currentTime = outputJob.getCompletionTime();    // Set overall time to this job's completion time.
        return outputJob;
    }
}