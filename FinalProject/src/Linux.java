/*
*******************************************************
 Class: Linux
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: creates the Computer subclass which prints a message when the Linux computer is opened for the first time
 Attributes:
 Method: <<constructor>>Linux(String name, String model), +printMessage():void
********************************************************
*/
public class Linux extends Computer {

    public Linux(String model){
        super("Linux", model);
    }
    public void printMessage(){
        System.out.println("Congratulations! You have purchased an overly complex and difficult machine to operate. Good luck, you'll need it.");
    }
}
