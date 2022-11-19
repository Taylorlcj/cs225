/*
*******************************************************
 Class: Question
 Author: Taylor Jensen
 Date Created: Nov 18, 2022
 Purpose:
 Attributes:
 Method:
********************************************************
*/
public class Question {
    private String answer;

    public void printQuestion(){

    }
    public boolean checkAnswer(String ans){
        return answer.equals(ans);
    }

    public void setAnswer(String ans){
        answer = ans;
    }

}
