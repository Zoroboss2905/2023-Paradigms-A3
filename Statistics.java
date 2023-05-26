// Class: Statistics
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
// Contains any and all information about the widget and its path, including time spent in each stage and queue.



public class Statistics {
    
    // What things need to be kept track of inside the program?
    /*
     * per Widget:
     * Path
     *
     * per Queue:
     * Time
     * average number of Widgets in a queue at any given time
     */

    // Each Queue contains these Statistics:
    private double qActiveTime;     //
    private double qWidgetUptime;   //

    // Queue Setters, Getters and Functions
    public void setQActiveTime(double newActiveTime){
        qActiveTime = newActiveTime;
    }
    public double getQActiveTime(){
        return qActiveTime;
    }
    public void setQWidgetUptime(double newUptime){
        qWidgetUptime = newUptime;
    }
    public double getQWidgetUptime(){
        return qWidgetUptime;
    }
}
