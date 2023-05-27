// Class: Stage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//



public class Job implements Comparable<Job>{

    private double completionTime;
    private Stage currentStage;

    public Job(){
        completionTime = 0;
    }

    public Job(double newCompletionTime, Stage s){
        currentStage = s;
        completionTime = newCompletionTime;
    }

    public void finishJob(){
        currentStage.go();
    }

    public void setCurrentStage(Stage newCurrentStage){
    currentStage = newCurrentStage;
    }

    public Stage getCurrentStage(){
        return currentStage;
    }

    
    public void setCompletionTime(double newTime){
        completionTime = newTime;
    }
    public double getCompletionTime(){
        return completionTime;
    }
       

     @Override
    public int compareTo(Job o) {
        
        // this completionTime < input completionTime
        if(this.completionTime < o.completionTime){
            return -1;
        }

        // this completionTime == input completionTime
        if(this.completionTime == o.completionTime){
            return 0;
        }

        // this completionTime > input completionTime
        else{
            return 1;
        }
    }
}


