/*
*******************************************************
 Class:MultipleChoice
 Author: Taylor Jensen
 Date Created: Nov 18, 2022
 Purpose: Classifies all the questions that are multiple choice
 Attributes:-question: string
            -choices: String[]

 Method: +printQuestion(): void

********************************************************
*/
public class MultipleChoice extends Question{
    private String question;
    private String[] choices;

    public void printQuestion(){
        System.out.println(question);
        for (String choice : choices) {
            System.out.println(choice);
        }
    }

    //Getter and Setters
    public void setQuestion(String quest){
        question = quest;
    }

    public void setChoices(String[] ch){
        choices = ch;
    }
}
