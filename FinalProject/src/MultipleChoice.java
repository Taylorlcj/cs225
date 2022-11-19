/*
*******************************************************
 Class:
 Author: Taylor Jensen
 Date Created: Nov 18, 2022
 Purpose:
 Attributes:
 Method:
********************************************************
*/
public class MultipleChoice extends Question{
    private String question;
    private String[] choices;

    public void printQuestion(){
        System.out.println(question);
        for (int i = 0; i < choices.length; i++) {
            System.out.println(choices[i]);
        }
    }

    public void setQuestion(String quest){
        question = quest;
    }

    public void setChoices(String[] ch){
        choices = ch;
    }
}
