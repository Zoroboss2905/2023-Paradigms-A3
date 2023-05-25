// Class: Stage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//


public abstract class Stage {
    
    private Queue next;
    private Queue prev;
    private int currentState;       // Either -1: starved, 0: busy or 1: blocked
    private double lastUpdate;
    private double processingTime;
    private String name;


    // STAGE STATS
    private double sTime;           // Starve Time
    private double wTime;           // Working Time
    private double bTime;           // Blocked Time

    public Stage(String name){
        sTime = 0;
        wTime = 0;
        bTime = 0;
        lastUpdate = 0;
        processingTime = 0;
    }


    // Stage stat Getters
    public double getSTime(){
        return this.sTime;
    }
    public double getWTime(){
        return this.wTime;
    }
    public double getBTime(){
        return this.bTime;
    }
    public abstract int getWidgetSpawnCount();
    public abstract void spawnWidget();

    public abstract void go();

    public void setNext(Queue newNext){
        next = newNext;
    }
    public void setPrev(Queue newPrev){
        prev = newPrev;
    }


    public void addSTime(){

    }
    public void addWTime(){

    }
    public void addBTime(){
        
    }

    public void push(){
        // Take Widget in this stage and move it to the next queue, if possible (not blocked).
    }
    public void pull(){
        // Take Widget from prev queue and add it to this stage.
        // Preconditions: Stage empty, Widget in prev queue
    }

    public void setCurrentState(int s, double currentTime){
        if (currentState == s){

        } 
    }

}