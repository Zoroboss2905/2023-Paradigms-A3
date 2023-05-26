// Class: Queue
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//

import java.util.ArrayList;

// We can use Arraylist for the Queue

public class Queue {
    // Queue limited to size QMax

    int QMax;
    String name;
    
    ArrayList<Widget> myList = new ArrayList<Widget>();

    // Arraylist of Widgets.
    Queue(int newQMax, String newName){
        QMax = newQMax;

    }
    Queue(){}  


    public boolean isFull(){
        if(myList.size()==QMax){
            return true;
        } else{
            return false;
        }
    }

    public boolean addToQueue(Widget newWidget){
        if(isFull() == false){
            myList.add(newWidget);
            return true;
        } else {
            return false;
        }
    }

    public Widget removeFromQueue(){
        Widget tempWidget = myList.get(0);
        myList.remove(0);
        return tempWidget;
    }
}
