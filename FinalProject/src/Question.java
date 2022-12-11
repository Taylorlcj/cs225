/*
*******************************************************
 Class: Question
 Author: Taylor Jensen
 Date Created: Nov 18, 2022
 Purpose: Stores the different type of questions
 Attributes: -answer: String

 Method: +printQuestion(): void
         +checkAnswer(ans: String): boolean

********************************************************
*/
public class Question {
    private String answer;
    private String lesson;

    public void printQuestion(){

    }
    public boolean checkAnswer(String ans){
        return answer.equals(ans);
    }

    //Getter and Setters
    public void setAnswer(String ans){
        answer = ans;
    }

    public void setLesson(String l){
        lesson = l;
    }

    public String getLesson(){
        return lesson;
    }
}
