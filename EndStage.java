// Class: EndStage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023 
// Last Modified: 21/07/2023

import java.util.Random;

public class EndStage extends Stage{

    private InterstageStorage next;
    private InterstageStorage prev;
    private int currentState;       // Either -1: starved, 0: busy or 1: blocked
    private double lastUpdate;
    private double processingTime;
    private String name;
    private Widget storedWidget;
    private int mean;
    private int range;
    private Scheduler scheduler = Scheduler.getInstance();
    private StatStore statStore = StatStore.getInstance();


    // STAGE STATS
    private double sTime;           // Starve Time
    private double wTime;           // Working Time
    private double bTime;           // Blocked Time

    public EndStage(String newName, int newMean, int newRange){
        sTime = 0;
        wTime = 0;
        bTime = 0;
        lastUpdate = 0;
        processingTime = 0;
        name = newName;
        storedWidget = null;
        mean = newMean;
        range = newRange;
    }      

    public int getWidgetSpawnCount(){return 0;}     // Does nothing in this Stage
    public void spawnWidget(){}                     // Does nothing in this Stage

    public void go(){
        this.push();
        this.pull();
    }

    public void setNext(InterstageStorage newNext){
        next = newNext;
    }
    public void setPrev(InterstageStorage newPrev){
        prev = newPrev;
    }
    public void setName(String newName){
        name = newName;
    }
    public InterstageStorage getNext(){
        return next;
    }
    public InterstageStorage getPrev(){
        return prev;
    }
    public String getName(){
        return name;
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

    // EndStage is unique in the way that push() cannot fail. it sends the widget to the StatStore to be processed instead.
    public boolean push(){
        if(storedWidget != null){
            // Take the current widget and move it to the StatStore.
            statStore.addCompleteWidget(storedWidget);
            // All else is the same
            storedWidget = null;
            setCurrentState(-1, scheduler.getCurrentTime());           // Starved
            return true;
        } else{
            return false;
        }
    }
    
    public boolean pull(){
        // Take Widget from prev queue and add it to this stage.
        // Preconditions: Stage empty, Widget in prev queue
        if(storedWidget != null){
            return false;   // Already has a widget inside.
        } else if(prev.isEmpty() == true){
            setCurrentState(-1, scheduler.getCurrentTime());           // Starved
            return false;   // There is nothing to pull, therefore Starved.
        } else{
            // All conditions are met, pull the item from prev and place it in the Stage.
            Widget tempWidget = prev.removeFromQueue(scheduler.getCurrentTime());
            setProcessingTime(mean, range);
            storedWidget = tempWidget;
            scheduler.addToPQueue(this, getProcessingTime());
            storedWidget.appendPath(name);
            setCurrentState(0, scheduler.getCurrentTime());           // Working
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
