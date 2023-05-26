// Class: Stage
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//



public class Job implements Comparable<Job>{

    private double duration;
    private Stage currentStage;

    public Job(){
        duration = 0;
    }

    public Job(double currentTime, Stage s){
        currentStage = s;
        duration = currentTime;
    }


    public void finishJob(double time){
        currentStage.go(time);
    }

    public void setCurrentStage(Stage newCurrentStage){
    currentStage = newCurrentStage;
    }

    public Stage getCurrentStage(){
        return currentStage;
    }

    
    public void setCurrentTime(double newTime){
        duration = newTime;
    }
    public double getCurrentTime(){
        return duration;
    }
    
     // each job contains reference to a widget and a stage, in addition to a "Completion time"
    

     @Override
    public int compareTo(Job o) {
        
        // this duration < input duration
        if(this.duration < o.duration){
            return -1;
        }

        // this duration == input duration
        if(this.duration == o.duration){
            return 0;
        }

        // this duration > input duration
        else{
            return 1;
        }
    }
}


