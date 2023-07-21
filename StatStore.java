// Class: StatStore
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   
// Last Modified: 21/07/2023

import java.util.ArrayList;

public class StatStore {

    private static StatStore single_instance = null;

    private ArrayList<Widget> widgetStorage;
    private int aCount;
    private int bCount;
    private int aa, ab, ba, bb;

    private StatStore(){
        widgetStorage = new ArrayList<Widget>();
        aCount = 0;
        bCount = 0;
        aa = 0;
        ab = 0;
        ba = 0;
        bb = 0;
    }

    public static synchronized StatStore getInstance(){
        if (single_instance == null){
            single_instance = new StatStore();
        }
        return single_instance;
    }

    public void addCompleteWidget(Widget newWidget){
        widgetStorage.add(newWidget);
    }

    public void widgetOutput(){
        System.out.println("Widget Specific info printed here.");
        for(int i=0; i<widgetStorage.size(); i++){
            // First Determine the path that each widget took, incrementing a value based on result.
            switch(widgetStorage.get(i).howDIdWeGetHere()){
                case -1:{
                    System.out.println("Path for a Widget is Invalid");
                    break;
                }
                case 0:{
                    // path was aa
                    aa++;
                    break;
                }
                case 1:{
                    // path was ab
                    ab++;
                    break;
                }
                case 2:{
                    // path was ba
                    ba++;
                    break;
                }
                case 3:{
                    // path was bb
                    bb++;
                    break;
                }
            }
            // Then determine where the Widgets were spawned.
            String aOrB = widgetStorage.get(i).whereDidWeComeFrom();      // Returns either a or b, to show where this widget was created.
            if(aOrB.equalsIgnoreCase("a")){
                aCount++;
            } else if(aOrB.equalsIgnoreCase("b")){
                bCount++;
            } else{
                System.out.println("Something went wrong and the StartStage hasnt branded each widget.");
                break;
            }
        }
        // Loop is finished, all data is aquired, time to print.

        // First do Production Paths
        System.out.println("\n Production Paths: \n ------------------");
        System.out.println("S3a -> S5a: \t" + Integer.toString(aa));
        System.out.println("S3a -> S5b: \t" + Integer.toString(ab));
        System.out.println("S3b -> S5a: \t" + Integer.toString(ba));
        System.out.println("S3b -> S5b: \t" + Integer.toString(bb));

        // Then do Production Widgets
        System.out.println("/n Production Widgets: \n ------------------");
        System.out.println("S0a: " + Integer.toString(aCount));
        System.out.println("S0a: " + Integer.toString(bCount));
    }
}
