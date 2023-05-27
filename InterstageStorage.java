// Class: Queue
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InterstageStorage {
    private String name;
    private int qMax;
    private Queue<Widget> widgetArray;
    private Queue<Double> widgetData;
    private double duration;
    private int totalItemCount;
    private ArrayList<Integer> averageArray;

    public InterstageStorage(int newQMax, String newName) {
        name = newName;
        qMax = newQMax;
        new LinkedList<Integer>();
        widgetArray = new LinkedList<Widget>();
        widgetData = new LinkedList<Double>();
        averageArray = new ArrayList<Integer>();
        totalItemCount = 0;
    }

    // TODO Fill out comments on all this

    public String getName(){
        return name;
    }

    public boolean isFull(){
        // Interstage storage is full
        if(widgetArray.size() == qMax) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(widgetArray.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void addToQueue(Widget inputWidget, double time){
            widgetArray.add(inputWidget);
            updateItemAverage(widgetArray.size());
            widgetData.add(time);
    }

    public Widget removeFromQueue(double d){
        Widget widget = widgetArray.poll();

        if(widget != null){
            double timeEntered = widgetData.poll();
            double duration = d - timeEntered;
            updateItemAverage(widgetArray.size());
            concatenateDuration(duration);
        }
        return widget;
    }

    private void updateItemAverage(int i) {
        averageArray.add(i);
    }

    public void concatenateDuration(double d) {
        duration += d;
        totalItemCount++;
    }

    public String calcAverage(){
        double average = duration / totalItemCount;
        return String.format("%4.2f", average);
    }

    // The Average Time an item spends in the queue
    public double averageTime(){
        double avgTime = 0;
//TODO: fix this
        return avgTime;
    }

    // The Average number of items in the queue at any time.
    public String averageItems() {
        double total = 0;
        // 
        for(int i = 0; i < averageArray.size(); i++){
            total += averageArray.get(i);
        }
        double average = total / averageArray.size();
        return String.format("%4.2f", average);
    }

    // output
    public String toString(){
        String output = "";
        output += name + " \t" + calcAverage() + " \t" + averageItems() + "\n";
        return output;
    }
}