// Class: StartStage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//



public class StartStage extends Stage{

    private Queue next;
    private Queue prev = null;
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
        return this.widgetSpawn;
    }

    public void spawnWidget(){
        widgetSpawn++;
    }



    public void go(){
    // Function that is intended to use with the full program, when this function is called it will check 'this' stage to determine whether or not any action can be taken.
    // First it determines wether the current 'Job' is complete, then attempts to push() to the next queue, withholding and delaying the job if the queue is full.
    // Next, if the Stage is empty, attempt to pull() from the previous queue and begin a new job
    }

    // Start Stage generates a new widget using info from the <singleton> getID() (this makes a unique ID when called upon) then, depending on whether the widget was made in S0a or S0b it will append either 'A' or 'B'
    //  

    /*
     * Start Stage when making a new Widget, uses P for the Processing time, where P = M+(N*(d-0.5)) (d is a random number from 1 to 0)
     */


    public void setNext(Queue newNext){
        next = newNext;
    }
    public void setPrev(Queue newPrev){
        prev = newPrev;
    }

    public void push(){
        // Take Widget in this stage and move it to the next queue, if possible (not blocked).
        
    }
    public void pull(){
        // Generate a brand new Widget, processing time and all, then when it is done, push().
    }

}