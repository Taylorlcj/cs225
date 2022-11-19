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
public class FillInTheBlank extends Question{
    private String description;
    private String statement;

    public void printQuestion(){
        System.out.println(description);
        System.out.println(statement);
    }

    public void setDescrtiption(String desc){
        description = desc;
    }

    public void setStatement(String state){
        statement = state;
    }
}
