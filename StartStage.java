// Class: StartStage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023 
// Last Modified: 21/07/2023


import java.util.Random;

public class StartStage extends Stage{

    private InterstageStorage next;
    private InterstageStorage prev = null;
    private int currentState;       // Either -1: starved, 0: busy or 1: blocked
    private double lastUpdate;
    private double processingTime;
    private String name;
    private Widget storedWidget;
    private int mean;
    private int range;
    private Scheduler scheduler = Scheduler.getInstance();
    private GetID idGen = GetID.getInstance();


    // STAGE STATS
    private double sTime;           // Starve Time
    private double wTime;           // Working Time
    private double bTime;           // Blocked Time

    public StartStage(String newName, int newMean, int newRange){
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

    public boolean push(){
        // First check this stage to make sure it contains a Widget and it processing, if not then push does nothing.
        if(storedWidget != null){
            setCurrentState(-1, scheduler.getCurrentTime());                // Starved
            return false;
        } else{
            // Then check to see if the queue after this one is full, if so, this stage is now blocked and returns false, so the JOB can set itself again
            if(next.isFull()){
                setCurrentState(1, scheduler.getCurrentTime());           // Blocked
                return false;
            } else {
                // Otherwise Take Widget in this stage and move it to the next queue, if possible (not blocked).
                next.addToQueue(storedWidget, scheduler.getCurrentTime());
                storedWidget = null;
                setCurrentState(-1, scheduler.getCurrentTime());            // Starved
                return true;
            }
        }
    }

    // The Start Stage is Unique in the way that instead of pulling from a previous queue, it CREATES a new widget.
    public boolean pull(){
        if(storedWidget != null){
            return false;   // Already has a widget inside.
        } else {
            // Begin Generating a new Widget
            String identifier = "" + this.name.charAt(2);         // For UID generation purposes
            String newID = idGen.getID();
            String tempUID = newID + identifier;                        // Set the UID in accordance with the Stage it was made in.
            setProcessingTime(mean,range);                              // Generate/Set new processing time for Stage
            storedWidget = new Widget(tempUID);                         // Create and hold new Widget
            scheduler.addToPQueue(this, getProcessingTime());           // Create Job
            storedWidget.appendPath(name);                              // Add this location to widget path storage
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

    public String toString(){
        String output = "";  

        //      stage name        work[%]                starve[t]              block[t]
        output += name + "\t\t" + getWTime() + "%\t\t" + getSTime() + "\t\t" + getBTime() + "\n";

        return output;
    }
}