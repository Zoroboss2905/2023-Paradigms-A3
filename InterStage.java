// Class: InterStage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//



public class InterStage extends Stage{

    private Queue next;
    private Queue prev;




    private void setNext(Queue newNext){
        next = newNext;
    }
    private void setPrev(Queue newPrev){
        prev = newPrev;
    }

    /*
     * can just tell the widgets to go to a unless full, then go b if a is full.
     * it doesnt really matter though, theyll both be working pretty much at all times.
     * they are not supposed to talk to each other.
     */


}
