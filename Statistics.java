// Class: Statistics
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
// Contains any and all information about the widget and its path, including time spent in each stage and queue.



public class Statistics {
    
    // What things need to be kept track of inside the program?
    /*
     * per stage:
     * Starve Time
     * Working Time
     * Blocked Time
     * 
     * per Start Stage:
     * Number of Widgets Created
     * 
     * per Widget:
     * Path
     * 
     * per Queue:
     * Time
     * average number of Widgets in a queue at any given time
     */

    // Each Stage contains these statistics:
    private double sTime;           // Starve Time
    private double wTime;           // Working Time
    private double bTime;           // Blocked Time

    // The Starter Stage(s) specifically also contain this Statistic:
    private int widgetSpawn;        // Incrementing number represents the number of widgets created on THIS Stage.

    // Each Widget contains these Statistics:
    private String path;            // A single String that contains text reprasentative of the widget's path through the stages. for example "0a12b345"

    // Each Queue contains these Statistics:
    private double qActiveTime;     //
    private double qWidgetUptime;   //


    // Stage Setters ad Getters
    private void setSTime(double newSTime){
        sTime = newSTime;
    }
    private void setWTime(double newWTime){
        wTime = newWTime;
    }
    private void setBTime(double newBTime){
        bTime = newBTime;
    }
    private double getSTime(){
        return this.sTime;
    }
    private double getWTime(){
        return this.wTime;
    }
    private double getBTime(){
        return this.bTime;
    }

    // StartStage Setters, Getters and Functions
    private void setWidgetSpawn(int newWidSpwn){
        widgetSpawn = newWidSpwn;
    }
    private void addWidgetSpawn(){
        widgetSpawn++;
    }
    private int getWidgetSpawn(){
        return widgetSpawn;
    }

    // Widget Setters, Getters and Functions
    private void setPath(String newPath){
        path = newPath;
    }
    private void addPath(String addon){
        path = path + addon;
    }
    private String getPath(){
        return path;
    }

    // Queue Setters, Getters and Functions
    private void setQActiveTime(double newActiveTime){
        qActiveTime = newActiveTime;
    }
    private double getQActiveTime(){
        return qActiveTime;
    }
    // TODO:
    // Rework the Queue Stats, they currently dont make enough sense.

}
