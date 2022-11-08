/*
*******************************************************
 Class: GameController
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose:This class allows the game to start and end
 Attributes: -player:Programmer
 Method: +main(String[]):void, +simulate():void, -gameOver():boolean, +createComputer(String fileName):Computer[]
********************************************************
*/

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class GameController {
    public static void main(String[] args){
        ArrayList<Computer> computers = loadComputers("ComputerTypes.txt");
        System.out.println("The following computers are available:");
        for(Computer c: computers){
            System.out.println(c);
        }
        System.out.println();
        Programmer player  = createPlayer();
        System.out.println("Welcome to the simulator, " + player.getName());
        System.out.println("\nPotential languages are: " );
        ArrayList<Language> languages = createLanguages();
        for(Language l: languages){
            System.out.println(l);
        }

    }

    public static void simulate(){

    }

    public static boolean gameOver(){
        return true;
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
            System.out.println("You broke my simulator! That file doesnt exist dangit!");
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

    public static Programmer createPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        if(name.trim().isEmpty()){
            name = "Anonymous";
        }
        return new Programmer(name,"student",1500, 0);
    }

    public static ArrayList<Language> createLanguages(){
        ArrayList<Language> languages = new ArrayList<Language>();
        languages.add(new Language("Python", new String[0], new String[0], "Pycharm"));
        languages.add(new Language("Java", new String[0], new String[0], "IntelliJ"));
        languages.add(new Language("C", new String[0], new String[0], "CodeBlocks"));
        languages.add(new Language("C#", new String[0], new String[0], "Visual Studio"));
        return languages;
    }
}
