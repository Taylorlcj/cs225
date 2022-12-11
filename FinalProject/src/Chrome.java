/*
*******************************************************
 Class: Chrome
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: creates the Computer subclass which prints a message when the Chromebook is opened for the first time
 Attributes:
 Method: <<constructor>>Chrome(model: String)
         +printMessage():void
********************************************************
*/
public class Chrome extends Computer{
    public Chrome( String model){
        super("Chrome", model);
    }

    public void printMessage(){
        System.out.println("Congratulations! You have purchased a computer that cannot even run a desktop IDE, now you have to use the Web version of the IDE!");
    }
}
