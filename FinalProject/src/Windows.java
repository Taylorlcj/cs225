/*
*******************************************************
 Class: Windows
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: creates the Computer subclass which prints a message when the Windows laptop is opened for the first time
 Attributes:
 Method: <<constructor>>Windows(String name, String model)
         +printMessage():void
********************************************************
*/
public class Windows extends Computer {

    public Windows(String model){
        super("Windows", model);
    }
    public void printMessage(){
        System.out.println("Congratulations! This computer was a very smart and budget-friendly purchase!");
    }
}
