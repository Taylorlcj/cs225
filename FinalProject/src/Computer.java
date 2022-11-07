/*
*******************************************************
 Class: Computer
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose: This class determines what happens when the player purchases a computer
 Attributes: -name:String, -model:String
 Method: <<constructor>>Computer(String n, String m), +purchaseMessage():void, +printMessage():void
********************************************************
*/
public class Computer{
    private String name;
    private String model;

    public Computer(String n, String m){
        name = n;
        model = m;
    }
    public void purchaseMethod(){
        System.out.println("You purchased a " + name + " " + model);
    }

    public void printMessage(){
        System.out.println("Wow, how did you end up not picking from the only possible options???");
    }

}
