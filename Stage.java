// Class: Stage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023
// Last Modified: 21/07/2023

import java.util.Random;

public abstract class Stage {
    
    private InterstageStorage sNext;
    private InterstageStorage sPrev;
    private int sCurrentState;       // Either -1: starved, 0: busy or 1: blocked
    private double sLastUpdate;
    private double sProcessingTime;
    private String sName;
    private Widget sStoredWidget;
    private int sMean;
    private int sRange;


    // STAGE STATS
    private double sTime;           // Starve Time
    private double wTime;           // Working Time
    private double bTime;           // Blocked Time

    public abstract void go();

    public void setNext(InterstageStorage newNext){
        sNext = newNext;
    }
    public void setPrev(InterstageStorage newPrev){
        sPrev = newPrev;
    }
    public void setName(String newName){
        sName = newName;
    }
    public InterstageStorage getNext(){
        return sNext;
    }
    public InterstageStorage getPrev(){
        return sPrev;
    }
    public String getName(){
        return sName;
    }

    public int getMean(){
        return sMean;
    }
    public int getRange(){
        return sRange;
    }
    public Widget getStoredWidget(){
        return sStoredWidget;
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
        sProcessingTime = newPTime;
    }
    public void setProcessingTime(int m, int n){
        Random r = new Random();
        double d = r.nextDouble();
        sProcessingTime = m + n*(d-0.5);
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
        return sProcessingTime;
    }

    public abstract boolean push();
    
    public abstract boolean pull();

    public int getCurrentState(){
        return sCurrentState;
    }

    public void setCurrentState(int s, double currentTime){
        if (sCurrentState == s){
            return;
        } else {
            double difference = currentTime - sLastUpdate;
            if(difference < 0){
                // Difference should never be negative
                System.out.println("Somehow, "+this.sName+"has travelled back in time");
            }
            if(sCurrentState == -1){
                // Stage is starved
                addSTime(difference);
            } else if(sCurrentState == 0){
                // Stage is Working
                addWTime(difference);
            } else if(sCurrentState == 1){
                // Stage is Blocked
                addBTime(difference);
            } else {
                // The 'State' of the Stage should always be either -1, 0 or 1.
                System.out.println("Stage of Stage: " + this.sName + " is Invalid");
            }
            sCurrentState = s;
            sLastUpdate = currentTime;
        }
    }
}