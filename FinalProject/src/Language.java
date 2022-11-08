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
    private String[] questions;
    private String[] answers;
    private String ide;
    public Language(String n, String[] q, String[] a, String i){
        name = n;
        questions = q;
        answers = a;
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
        return name + " uses the ide " + ide;
    }
}
