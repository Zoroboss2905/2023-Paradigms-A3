// Class: A3
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//


// First test should be StartStage,Queue,EndStage
// Second test should be Start, Queue, Inter, Queue, End
// Make sure everything is working correctly by biasing the time values to enforce starving or blocking etc.
// THEN make the structure match the spec
// Structure can be Hardcoded


class A3{
    public static void main(String args[]){

        int M = Integer.parseInt(args[0]);      // Average Processing Time
        int N = Integer.parseInt(args[1]);      // Range of Processing Time
        int QMax = Integer.parseInt(args[2]);
        double timeLimit = 10000000;            // 10 Million units of 'Time'
        Stage s0, s1;
        Queue q01;
        StatStore statStore = new StatStore();
        Scheduler scheduler = Scheduler.getInstance();


        s0 = new StartStage("s0", M, N, scheduler);
        s1 = new EndStage("s1", M, N, scheduler);

        q01 = new Queue(QMax, "q12");


        scheduler.addToPQueue(s0, 0);
        scheduler.addToPQueue(s1, 0);

        while(scheduler.getCurrentTime()<timeLimit){
            // Run the Program, start to finish for 10Mil units of time
        }

        statStore.fullOutput();
    }
}