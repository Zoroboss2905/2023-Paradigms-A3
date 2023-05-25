// Class: InterStage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//



public class InterStage extends Stage{

    private Queue next;
    private Queue prev;
    private String currentState;    // Either 'Idle', 'Active', 'Blocked' or 'Starved'
    private double lastUpdate;

    // STAGE STATS
    private double sTime;           // Starve Time
    private double wTime;           // Working Time
    private double bTime;           // Blocked Time
    private int widgetSpawn;        // The number of widgets created on THIS Stage.

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
    public int getWidgetSpawnCount(){
        return 0;
    }
    public void spawnWidget(){}





    public void go(){
    // Function that is intended to use with the full program, when this function is called it will check 'this' stage to determine whether or not any action can be taken.
    // First it determines wether the current 'Job' is complete, then attempts to push() to the next queue, withholding and delaying the job if the queue is full.
    // Next, if the Stage is empty, attempt to pull() from the previous queue and begin a new job
    }



    public void setNext(Queue newNext){
        next = newNext;
    }
    public void setPrev(Queue newPrev){
        prev = newPrev;
    }

    /*
     * can just tell the widgets to go to a unless full, then go b if a is full.
     * it doesnt really matter though, theyll both be working pretty much at all times.
     * they are not supposed to talk to each other.
     */


}
