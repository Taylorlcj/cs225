/*
*******************************************************
 Class: Mac
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: creates the Computer subclass which prints a message when the Macbook is opened for the first time
 Attributes:
 Method: <<constructor>>Mac(String name, String model), +printMessage():void
********************************************************
*/
public class Mac extends Computer {

    public Mac(String name, String model){
        super(name, model);
    }
    public void printMessage(){
        System.out.println("Congratulations! Your bank account hates you!");
    }
}
