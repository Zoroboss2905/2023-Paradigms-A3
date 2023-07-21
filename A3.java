// Class: A3
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023
// Last Modified: 21/07/2023


// First test should be StartStage,Queue,EndStage
// Second test should be Start, Queue, Inter, Queue, End
// Make sure everything is working correctly by biasing the time values to enforce starving or blocking etc.
// THEN make the structure match the spec
// Structure can be Hardcoded

import java.util.ArrayList;

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
        ArrayList<Stage> stageList = new ArrayList<Stage>();


        s0a = new StartStage("s0a", M, N);
        s1 = new EndStage("s1", M, N);

        stageList.add(s0a);
        stageList.add(s1);
        

        q01 = new InterstageStorage(QMax, "q12");

        s0a.setNext(q01);

        s1.setPrev(q01);



        scheduler.addToPQueue(s0a, 0);
        scheduler.addToPQueue(s1, 0);

        while(scheduler.getCurrentTime()<timeLimit){
            // Run the Program, start to finish for 10Mil units of time
            // Do the Top Job first, and in the process, set the current time.
            Job topJob = scheduler.removeJob();

            // Take the Job's Stage, and make it do stuff (push, pull)
            topJob.getCurrentStage().go();

            // If top Stage is busy, it's in the wrong spot, create a new job with the correct time.
            if(topJob.getCurrentStage().getCurrentState() == 0){
                scheduler.addToPQueue(topJob.getCurrentStage(), topJob.getCurrentStage().getProcessingTime());
            }

            // process every stage from last stage backwards to first
            for(int i = stageList.size(); i>0; i--){
                stageList.get(i-1).go();
            }

            // Increment time in system to the NEXT top job's time
            scheduler.setCurrentTime(scheduler.getTopJob().getCompletionTime());
            scheduler.setCurrentTime(scheduler.getCurrentTime()+20000);
        }


        // Printing Results.
        System.out.println("Production Stations: \n -------------------------------------------- \nStage:\tWork[%]\t\tStarve[t]\tBlock[t]");
        System.out.println(s0a.toString());
        System.out.println(s1.toString());

        System.out.println(q01.toString());

        statStore.widgetOutput();
    }
}