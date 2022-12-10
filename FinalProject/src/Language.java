/*
*******************************************************
 Class: Language
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: This class stores the player's choice of language that is chosen
 Attributes: -name: String
             -questions: ArrayList<Question>
             -ide: String

 Method: <<constructor>>Language(String n, String[] q, String[] a, String i)
         +checkStatement(question: int):boolean,
         +askQuestion(question: int):void
         +printIdeInfo():string
         +toString():String
         (Static)+loadLanguages(filename: String):ArrayList<Languages>
         (Static)+createMultipleChoice(quest: String, ch: String[], ans: String):Question
         (Static)+createFillInTheBlank(desc: String, state: String, ans: String):Question
********************************************************
*/

// **  imports  **
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
    public boolean checkStatement(int question){
        return true;
    }

    public void askQuestion(int question){

    }

    public String printIdeInfo(){
        return null;
    }

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
