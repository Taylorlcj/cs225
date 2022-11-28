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
                        String lesson = input.nextLine();
                        String desc = input.nextLine();
                        String state = input.nextLine();
                        String ans = input.nextLine();
                        questions.add(createFillInTheBlank(desc, state, ans, lesson));
                    }
                    else if(type.equals("multiple-choice")) {
                        String lesson = input.nextLine();
                        String quest = input.nextLine();
                        String[] ch = {input.nextLine(),input.nextLine(),input.nextLine()};
                        String ans = input.nextLine();
                        questions.add(createMultipleChoice(quest, ch, ans, lesson));
                    }
                    else{
                        break;
                    }
                }
                languages.add(new Language(name, questions, ide));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("You broke my simulator! That file doesn't exist dang it!");
        }
        return languages;
    }

    public static Question createMultipleChoice(String quest, String[] ch, String ans, String l){
        MultipleChoice q = new MultipleChoice();
        q.setQuestion(quest);
        q.setChoices(ch);
        q.setAnswer(ans);
        q.setLesson(l);
        return q;
    }
    public static Question createFillInTheBlank(String desc, String state, String ans, String l){
        FillInTheBlank q = new FillInTheBlank();
        q.setDescription(desc);
        q.setStatement(state);
        q.setAnswer(ans);
        q.setLesson(l);
        return q;
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
