// Class: Widget
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//



public class Widget{
    
    private String uniqueID;
    private String path;
    private boolean s3as5a;
    private boolean s3as5b;
    private boolean s3bs5a;
    private boolean s3bs5b;
    private int s3;         // 1 = a, 2 = b
    private int s5;         // 1 = a, 2 = b


    public Widget(){
        path = "";
        s3as5a = false;
        s3as5b = false;
        s3bs5a = false;
        s3bs5b = false;
        s3 = 0;
        s5 = 0;
    }

    public void appendPath(String addon){
        if(addon.equalsIgnoreCase("s3a")){
            s3 = 1;
        } else if(addon.equalsIgnoreCase("s3b")){
            s3 = 2;
        } else if(addon.equalsIgnoreCase("s5a")){
            s5 = 1;
        } else if(addon.equalsIgnoreCase("s5b")){
            s5 = 2;
        }
        path = path + addon + ", ";
    }

    public void howDIdWeGetHere(){
        if((s3 == 1) && (s5 == 1)){
            s3as5a = true;
        } else if((s3 == 1) && (s5 == 2)){
            s3as5b = true;
        } else if((s3 == 2) && (s5 == 1)){
            s3bs5a = true;
        } else if((s3 == 2) && (s5 == 2)){
            s3bs5b = true;
        } else {
            //System.out.println("Something went wrong with applying correct pathing information to each widget.");
        }
    }
}