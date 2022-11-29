/*
*******************************************************
 Class: Programmer
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: This class stores the bulk of the player information
 Attributes: -name:String
             -rank:String
             -computer:Computer
             -language:Language
             -initialBudget:int
             -anxiety:int

 Method: <<constructor>>Programmer(String n, String r, int i, int a)
         +anxietyUp(value: int):void
         +anxietyDown(value: int):void
         +decreaseBudget(amount: int):void
         +printInfo():void
********************************************************
*/
public class Programmer {
    private String name;
    private String rank;
    private Computer computer;
    private Language language;
    private int initialBudget;
    private int anxiety;
    private boolean paidCourse;



    public Programmer(String n, String r, int i, int a){
        name = n;
        rank = r;
        initialBudget = i;
        anxiety = a;
    }

    public void anxietyUp(int value){

    }

    public void anxietyDown(int value){

    }

    public void decreaseBudget(int amount){

    }

    public void printInfo(){

    }


    //Getters and Setters
    public Language getLanguage(){
     return language;
    }
    public void setLanguage(Language l){
        language = l;
    }

    public Computer getComputer(){
        return computer;
    }
    public void setComputer(Computer c){
        computer = c;
    }
    public String getName(){
        return name;
    }
    public void setPaidCourse(boolean pc){
        paidCourse = pc;
    }
    public boolean getPaidCourse(){
        return paidCourse;
    }

}
