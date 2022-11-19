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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static ArrayList<Language> loadLanguages(String fileName){
        ArrayList<Language> languages = new ArrayList<Language>();
        File file = new File(fileName);
        try (Scanner input = new Scanner(file)) {

            //get all the languages
            while(input.hasNextLine()){
                String name = input.nextLine();
                String ide = input.nextLine();
                ArrayList<Question> questions = new ArrayList<Question>();
                //get all the questions
                while (input.hasNextLine()){
                    String type = input.nextLine();
                    if(type.equals("fill-in-the-blank")){
                        String desc = input.nextLine();
                        String state = input.nextLine();
                        String ans = input.nextLine();
                        questions.add(createFillInTheBlank(desc, state, ans));
                    }
                    else if(type.equals("multiple-choice")) {
                        String quest = input.nextLine();
                        String[] ch = {input.nextLine(),input.nextLine(),input.nextLine()};
                        String ans = input.nextLine();
                        questions.add(createMultipleChoice(quest, ch, ans));
                    }
                    else{
                        break;
                    }
                }
                languages.add(new Language(name, questions, ide));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("You broke my simulator! That file doesn't exist dangit!");
        }
        return languages;
    }

    public static Question createMultipleChoice(String quest, String[] ch, String ans){
        MultipleChoice q = new MultipleChoice();
        q.setQuestion(quest);
        q.setChoices(ch);
        q.setAnswer(ans);
        return q;
    }
    public static Question createFillInTheBlank(String desc, String state, String ans){
        FillInTheBlank q = new FillInTheBlank();
        q.setDescrtiption(desc);
        q.setStatement(state);
        q.setAnswer(ans);
        return q;
    }
}
