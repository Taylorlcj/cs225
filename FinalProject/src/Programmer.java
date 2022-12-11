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
             -anxiety:int
             -paidCourse:boolean

 Method: <<constructor>>Programmer(n: String, a: int)
         +anxietyUp(value: int):void
         +anxietyDown():void
         +rankUp():void
********************************************************
*/
public class Programmer {
    private String name;
    private Rank rank;
    private Computer computer;
    private Language language;
    private int anxiety;
    private boolean paidCourse;


    //Methods
    public Programmer(String n, int a){
        name = n;
        rank = Rank.STUDENT;
        anxiety = a;
    }

    public void anxietyUp(int value){
        anxiety += value;
    }

    public void anxietyDown(){
        anxiety--;
    }

    public void rankUp(){
        if(rank == Rank.STUDENT){
            rank = Rank.JUNIOR;
        }
        else if (rank == Rank.JUNIOR){
            rank = Rank.SENIOR;
        }
        else if (rank == Rank.SENIOR){
            rank = Rank.CEO;
        }
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
    public Rank getRank() {
        return rank;
    }
    public int getAnxiety() {
        return anxiety;
    }
}
