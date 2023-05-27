// Class: Stage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//

import java.util.Random;

public abstract class Stage {
    
    private InterstageStorage next;
    private InterstageStorage prev;
    private int currentState;       // Either -1: starved, 0: busy or 1: blocked
    private double lastUpdate;
    private double processingTime;
    private String name;
    private Widget storedWidget;
    private int mean;
    private int range;


    // STAGE STATS
    private double sTime;           // Starve Time
    private double wTime;           // Working Time
    private double bTime;           // Blocked Time

    public Stage(String newName, int newMean, int newRange){
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

    public abstract int getWidgetSpawnCount();
    public abstract void spawnWidget();

    public abstract void go();

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

    public int getMean(){
        return mean;
    }
    public int getRange(){
        return range;
    }
    public Widget getStoredWidget(){
        return storedWidget;
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

    public abstract boolean push();
    
    public abstract boolean pull();

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