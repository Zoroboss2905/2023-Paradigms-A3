// Class: Scheduler
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//


import java.util.PriorityQueue;

public class Scheduler {
    private double currentTime;
    private PriorityQueue<Job> jobQueue;

    public Scheduler(){
        currentTime = 0;
        jobQueue = new PriorityQueue<Job>();
    }

    public void addToPQueue(Stage stage, double currentTime){
        Job Job = new Job(currentTime + currentTime, stage);
        jobQueue.offer(Job);
    }

    public Job removeJob(){
        Job outputJob = jobQueue.poll();

        currentTime = outputJob.getCurrentTime();
        return outputJob;
    }

    public double getCurrentTime(){
        return currentTime;
    }

}