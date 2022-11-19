import java.util.ArrayList;

/*
*******************************************************
 Class: Language
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: This class stores the player's choice of language that is chosen
 Attributes: -name:String, -questions: String[], -answers: String[], -ide:String
 Method: <<constructor>>Language(String n, String[] q, String[] a, String i),+checkStatement(question: int):boolean,
 +askQuestion(question: int):void, +printIdeInfo():string
********************************************************
*/
public class Language {
    private String name;
    private ArrayList<Question> questions;
    private String ide;
    public Language(String n, ArrayList<Question>  q, String i){
        name = n;
        questions = q;
        ide = i;
    }

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
