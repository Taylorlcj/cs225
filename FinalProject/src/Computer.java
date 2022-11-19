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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public String toString(){
        return name + ": " + model;
    }

    public static ArrayList<Computer> loadComputers(String fileName){
        ArrayList<Computer> computers = new ArrayList<Computer>();
        File file = new File(fileName);
        try (Scanner input = new Scanner(file)) {
            while(input.hasNextLine()){
                String make = input.nextLine();
                String model = input.nextLine();
                computers.add(createComputer(make, model));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("You broke my simulator! That file doesn't exist dangit!");
        }
        return computers;
    }
    public static Computer createComputer(String make, String model){
        if(make.toLowerCase().equals("mac")){
            return new Mac(model);
        }
        else if (make.toLowerCase().equals("windows")) {
            return new Windows(model);
        }
        else if (make.toLowerCase().equals("chrome")) {
            return new Chrome(model);
        }
        else{
            return new Linux(model);
        }
    }
}
