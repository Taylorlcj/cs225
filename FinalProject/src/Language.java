/*
*******************************************************
 Class: Language
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: This class stores the player's choice of language that is chosen
 Attributes: -name: String
             -questions: ArrayList<Question>
             -ide: String

 Method: <<constructor>>Language(n: String, q: String[], a: String[], i: String)
         +toString():String
********************************************************
*/

// **  imports  **
import java.util.ArrayList;

public class Language {

    // **  Attributes  **
    private String name;
    private ArrayList<Question> questions;
    private String ide;

    // ** Constructor **
    public Language(String n, ArrayList<Question>  q, String i){
        name = n;
        questions = q;
        ide = i;
    }

    // **  Methods  **
    public String toString(){
        return name + " uses the ide " + ide ;
    }

    // **  Getters and Setters  **
    public String getName(){
        return name;
    }
    public ArrayList<Question> getQuestions(){
        return questions;
    }
    public String getIde(){
        return ide;
    }
}
