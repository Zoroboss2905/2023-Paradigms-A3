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
        double timeLimit = 10000;            // 10 Million units of 'Time'  // TODO: Reset back to 10Mil, is currently 10K
        Stage s0a, s1;
        InterstageStorage q01;
        Scheduler scheduler = Scheduler.getInstance();
        StatStore statStore = StatStore.getInstance();


        s0a = new StartStage("s0a", M, N);
        s1 = new EndStage("s1", M, N);

        q01 = new InterstageStorage(QMax, "q12");


        scheduler.addToPQueue(s0a, 0);
        scheduler.addToPQueue(s1, 0);

        while(scheduler.getCurrentTime()<timeLimit){
            // Run the Program, start to finish for 10Mil units of time
        }


        // Printing Results.
        System.out.println("Production Stations: \n -------------------------------------------- \nStage:\tWork[%]\t\tStarve[t]\tBlock[t]");
        System.out.println(s0a.toString());
        System.out.println(s1.toString());

        System.out.println(q01.toString());

        statStore.widgetOutput();
    }
}