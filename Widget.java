// Class: Widget
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023  
// Last Modified: 21/07/2023



public class Widget{
    
    private String uniqueID;
    private String path;

    public Widget(String newUID){
        uniqueID = newUID;
        path = "";
    }

    public void appendPath(String addon){
        path = path + addon + "-";
    }

    public String whereDidWeComeFrom(){
        String aOrB = "" + uniqueID.charAt(uniqueID.length()-1);        // Last Item in UID (either a of b)
        return aOrB;        
    }

    public int howDIdWeGetHere(){
        String s3 = path.charAt(12) + "";
        String s5 = path.charAt(19) + "";
        if((s3.equals("a")) && (s5.equals("a"))){
            return 0;   // Path taken was s3a s5a
        } else if((s3.equals("a")) && (s5.equals("b"))){
            return 1;   // Path taken was s3a s5b
        } else if((s3.equals("b")) && (s5.equals("a"))){
            return 2;   // Path taken was s3b s5a
        } else if((s3.equals("b")) && (s5.equals("b"))){
            return 3;   // Path taken was s3b s5b
        } else {
            //System.out.println("Something went wrong with applying correct pathing information to a widget.");
            return -1;
        }
    }
}