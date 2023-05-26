// Class: A3
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//

import java.util.PriorityQueue;

// First test should be StartStage,Queue,EndStage
// Second test should be Start, Queue, Inter, Queue, End
// Make sure everything is working correctly by biasing the time values to enforce starving or blocking etc.
// THEN make the structure match the spec
// Structure can be Hardcoded


class A3{
    public static void main(String args[]){

        int QMax = Integer.parseInt(args[2]);
        Stage s0, s1;
        Queue q01;
        StatStore statStore = new StatStore();
        PriorityQueue<Job> jobQueue = new PriorityQueue<Job>();         // peek takes info, poll takes info and removes element


        s0 = new StartStage();
        s1 = new EndStage();

        q01 = new Queue(QMax, "q12");
        /*
         * args[0] is M (AVG Processing time)
         * args[1] is N (Range of processing time)
         * args[2] is QMax
         * 
         * 
         * Priority Queue contains Jobs.
         */



         statStore.fullOutput();
    }
}