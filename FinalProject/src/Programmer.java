/*
*******************************************************
 Class: Programmer
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: This class stores the bulk of the player information
 Attributes: -name:String, -questions: String[], -answers: String[], -ide:String
 Method: <<constructor>>Programmer(String n, String r, Computer c, Language l, int i, int a), +anxietyUp(value: int):void,
 +anxietyDown(value: int):void, +decreaseBudget(amount: int):void, +getLanguage():Language, +getComputer():Computer,+printInfo():void
********************************************************
*/
public class Programmer {
    private String name;
    private String rank;
    private Computer computer;
    private Language language;
    private int initialBudget;
    private int anxiety;

    public Programmer(String n, String r, Computer c, Language l, int i, int a){
        name = n;
        rank = r;
        computer = c;
        language = l;
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

    public Language getLanguage(){
     return language;
    }

    public Computer getComputer(){
        return computer;
    }
}
