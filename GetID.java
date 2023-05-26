// Class: GetID
// Author: Jarrod Aubin
// Subject: SENG2200 Programming Languages and Paradigms
// Assignment 3
// 12/05/2023   ||  12/05/2023
//


// SINGLETON CLASS
//WIP
public class GetID {
    // Using a singleton class, generate a unique ID for each widget that is generated
    // in the final implementation make sure that the ID is appended with either an 'a' or a 'b'
    private static GetID single_instance = null;

    private GetID(){
        
    }

    public static synchronized GetID getInstance(){
        if (single_instance == null){
            single_instance = new GetID();
        }
        return single_instance;
    }
} 