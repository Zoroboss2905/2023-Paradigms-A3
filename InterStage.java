// Class: InterStage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//

import java.util.Random;

public class InterStage extends Stage{

    private Queue next;
    private Queue prev;
    private int currentState;       // Either -1: starved, 0: busy or 1: blocked
    private double lastUpdate;
    private double processingTime;
    private String name;
    private Widget storedWidget;
    private int mean;
    private int range;
    private Scheduler scheduler;


    // STAGE STATS
    private double sTime;           // Starve Time
    private double wTime;           // Working Time
    private double bTime;           // Blocked Time

    public Stage(String newName, int newMean, int newRange, Scheduler newScheduler){
        sTime = 0;
        wTime = 0;
        bTime = 0;
        lastUpdate = 0;
        processingTime = 0;
        name = newName;
        storedWidget = null;
        mean = newMean;
        range = newRange;
        scheduler = newScheduler;
    }

    public abstract int getWidgetSpawnCount();
    public abstract void spawnWidget();

    public abstract void go(double t);

    public void setNext(Queue newNext){
        next = newNext;
    }
    public void setPrev(Queue newPrev){
        prev = newPrev;
    }
    public void setName(String newName){
        name = newName;
    }


    public void addSTime(double addTime){
        sTime = sTime + addTime;
    }
    public void addWTime(double addTime){
        wTime = wTime + addTime;
    }
    public void addBTime(double addTime){
        bTime = bTime + addTime;
    }
    public void setProcessingTime(double newPTime){
        processingTime = newPTime;
    }
    public void setProcessingTime(int m, int n){
        Random r = new Random();
        double d = r.nextDouble();
        processingTime = m + n*(d-0.5);
    }

    public String getSTime(){
        return String.format("%4.2f", sTime);
    }
    public String getWTime(){
        // This one outputs as a percentage, so figure that out first.
        double wUpTime = wTime/(sTime+wTime+bTime);
        return String.format("%4.2f", wUpTime);
    }
    public String getBTime(){
        return String.format("%4.2f", bTime);
    }
    public double getProcessingTime(){
        return processingTime;
    }

    public boolean push(){
        // First check to see if the queue after this one is full, if so, this stage is now blocked and returns false, so the JOB can set itself again
        if(next.isFull()){
            currentState = 1;
            return false;
        } else {
            // Otherwise Take Widget in this stage and move it to the next queue, if possible (not blocked).
            next.addToQueue(storedWidget);
            storedWidget = null;
            currentState = -1;
            return true;
        }
    }
    
    public boolean pull(){
        // Take Widget from prev queue and add it to this stage.
        // Preconditions: Stage empty, Widget in prev queue
        if(storedWidget != null){
            return false;   // Already has a widget inside.
        } else if(prev.isEmpty() == true){
            currentState = -1;
            return false;   // There is nothing to pull, therefore Starved.
        } else{
            // All conditions are met, pull the item from prev and place it in the Stage.
            Widget tempWidget = prev.removeFromQueue();
            setProcessingTime(mean, range);
            storedWidget = tempWidget;
            scheduler.addToPQueue(this, getProcessingTime());
            // also apply a time and create a new job.
            return true;
        }
    }

    public void setCurrentState(int s, double currentTime){
        if (currentState == s){
            return;
        } else {
            double difference = currentTime - lastUpdate;
            if(difference < 0){
                // Difference should never be negative
                System.out.println("Somehow, "+this.name+"has travelled back in time");
            }
            if(currentState == -1){
                // Stage is starved
                addSTime(difference);
            } else if(currentState == 0){
                // Stage is Working
                addWTime(difference);
            } else if(currentState == 1){
                // Stage is Blocked
                addBTime(difference);
            } else {
                // The 'State' of the Stage should always be either -1, 0 or 1.
                System.out.println("Stage of Stage: " + this.name + " is Invalid");
            }
            currentState = s;
            lastUpdate = currentTime;
        }
    }
}
