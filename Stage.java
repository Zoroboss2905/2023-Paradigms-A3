// Class: Stage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//


public class Stage {
    
    private Queue next;
    private Queue prev;


    private void proceed(){
        // Function that is intended to use with the full program, when this function is called it will check 'this' stage to determine whether or not any action can be taken.
        // First it determines wether the current 'Job' is complete, then attempts to push() to the next queue, withholding and delaying the job if the queue is full.
        // Next, if the Stage is empty, attempt to pull() from the previous queue and begin a new job
    }



    private void setNext(Queue newNext){
        next = newNext;
    }
    private void setPrev(Queue newPrev){
        prev = newPrev;
    }

    private void push(){
        // Take Widget in this stage and move it to the next queue, if possible (not blocked).
    }
    private void pull(){
        // Take Widget from prev queue and add it to this stage.
        // Preconditions: Stage empty, Widget in prev queue
    }

}
