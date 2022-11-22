/*
*******************************************************
 Class:FillInTheBlank
 Author: Taylor Jensen
 Date Created: Nov 18, 2022
 Purpose: Classifies all the questions that are FilL in the blank

 Attributes:-description: String
            -statement: String

 Method:+printQuestion(): void

********************************************************
*/
public class FillInTheBlank extends Question{
    private String description;
    private String statement;

    public void printQuestion(){
        System.out.println(description);
        System.out.println(statement);
    }


    //Getter and Setters
    public void setDescription(String desc){
        description = desc;
    }

    public void setStatement(String state){
        statement = state;
    }
}
