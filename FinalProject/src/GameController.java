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
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;


public class GameController {
    public static void main(String[] args) {
        ArrayList<Computer> computers = Computer.loadComputers("ComputerTypes.txt");
        System.out.println();
        Programmer player  = createPlayer();
        System.out.println("Welcome to the simulator, " + player.getName());
        player.setComputer(pickComputer(computers));
        ArrayList<Language> languages = Language.loadLanguages("ProgrammingLanguage.txt");
        player.setLanguage(pickLanguage(languages));
    }
    public static void simulate(){

    }

    public static boolean gameOver(){
        return true;
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

    public static Computer pickComputer(ArrayList<Computer> computers){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which computer do I wanna choose?");
        for (int i = 0; i < computers.size(); i++){
            System.out.println((i+1) + ". " + computers.get(i));
        }
        System.out.println("Enter one of the above numbers!");
        try {
            choice = scanner.nextInt();
            computers.get(choice - 1);
        }
        catch(Exception e){
            choice = 1 + (int) (Math.random() * computers.size());
            System.out.println("I know! I'll use a number random generator!");
        }
        computers.get(choice - 1).purchaseMethod();
        return computers.get(choice - 1);
    }

    public static Language pickLanguage(ArrayList<Language> languages){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which language do I wanna choose?");
        for (int i = 0; i < languages.size(); i++){
            System.out.println((i+1) + ". " + languages.get(i));
        }
        System.out.println("Enter one of the above numbers!");
        try {
            choice = scanner.nextInt();
            languages.get(choice - 1);
        }
        catch(Exception e){
            choice = 1 + (int) (Math.random() * languages.size());
            System.out.println("I know! I'll use a number random generator!");
        }
        System.out.println(languages.get(choice - 1));
        return languages.get(choice - 1);
    }
}
