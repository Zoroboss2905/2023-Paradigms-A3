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
    private Queue<Widget> widgetQueue;
    private LinkedList<Double> widgetData;
    private double duration;
    private int totalItemCount;
    private ArrayList<Integer> averageArray;

    public InterstageStorage(int newQMax, String newName) {
        name = newName;
        qMax = newQMax;
        widgetQueue = new LinkedList<Widget>();
        widgetData = new LinkedList<Double>();
        averageArray = new ArrayList<Integer>();
        totalItemCount = 0;
    }

    public String getName(){
        return name;
    }

    // True if widgetQueue is full
    public boolean isFull(){
        if(widgetQueue.size() == qMax +1) {
            return true;
        }
        else{
            return false;
        }
    }

    // True if widgetQueue is empty
    public boolean isEmpty(){
        if(widgetQueue.size()==1){
            return true;
        }
        else{
            return false;
        }
    }


    // Adds a new Widget into the back of the queue.    Also updates the time that the item was added into the queue, for stat gathering purposes.
    public void addToQueue(Widget inputWidget, double time){
            widgetQueue.add(inputWidget);
            updateItemAverage(widgetQueue.size());
            widgetData.add(time);
    }

    // Removes a widget from the front of the queue.    Also updates the time that the item was present in the queue, for stat gathering purposes.
    public Widget removeFromQueue(double d){
        Widget widget = widgetQueue.poll();

        if(widget != null){
            double timeEntered = widgetData.poll();
            double duration = d - timeEntered;
            updateItemAverage(widgetQueue.size());
            addDuration(duration);
        }
        return widget;
    }

    // Updates the number of items present in the queue
    private void updateItemAverage(int i) {
        averageArray.add(i);
    }

    // Adds amount of time Item was present in queue to the total time spent in queue
    public void addDuration(double d) {
        duration += d;
        totalItemCount++;
    }

    // Averages out the time spent in queue
    public String calcAverage(){
        double average = duration / totalItemCount;
        return String.format("%4.2f", average);
    }

    // The Average number of items in the queue at any time.
    public String averageItems() {
        double total = 0;
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