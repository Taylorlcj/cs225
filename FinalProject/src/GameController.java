/*
*******************************************************
 Class: GameController
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose:This class allows the game to start and end
 Attributes:

 Method: (Static)+main(String[]):void
         (Static)+simulate():void
         (Static)+gameOver():boolean
         (Static)+createPlayer():Programmer
         (Static)+pickComputer(computers: ArrayList<Computer>):Computer
         (Static)+pickLanguage(languages:ArrayList<Language>):Language

********************************************************
*/

//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;


public class GameController {
    public static void main(String[] args) {
        ArrayList<Computer> computers = Computer.loadComputers("ComputerTypes.txt");
        System.out.println();
        Programmer player  = createPlayer();
        System.out.println("Welcome to the simulator, " + player.getName() + "!\n");
        System.out.println("*Wakes up in the morning*");
        System.out.println("Hey, I want to be a software developer!");
        System.out.println("I'm going to go to Best Buy and pick out which computer I want to begin my journey with!\n");
        player.setComputer(pickComputer(computers));
        System.out.println("\nYou go home and open your new computer!");
        System.out.print("Your computer displays: ");
        player.getComputer().printMessage();
        System.out.println("Great! Now that I have a computer, all I need is to pick my programming language to code in!\n");
        ArrayList<Language> languages = Language.loadLanguages("ProgrammingLanguage.txt");
        player.setLanguage(pickLanguage(languages));
        player.setPaidCourse(pickCourse());
        System.out.println("Let's get ready to learn!\n");
        teachLesson(player);
        System.out.println("\nI'm finally ready for my interview");
        System.out.println("**Goes to interview**\n");
        giveInterview(player);
        System.out.println("Your work-life has started! You will now receive Yearly reviews!\n");
        ArrayList<String> reviews = readReviews("Reviews.txt");
        workLife(player, reviews);
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
        return new Programmer(name, 0);
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
            System.out.println("I know! I'll use a random number generator!");
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
            System.out.println("I know! I'll use a random number generator!");
        }
        System.out.println(languages.get(choice - 1));
        return languages.get(choice - 1);
    }

    public static boolean pickCourse(){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nNow what kind of learning style should I pick???");
        System.out.println("1. Youtube/Free Courses");
        System.out.println("2. Udemy/Paid Courses");
        System.out.println("Enter one of the above numbers!");

        try {
            choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("\nI'll air on the safe side and go for the free courses");
                return false;
            } else if (choice == 2) {
                System.out.println("\nI'm all in! It's only money!");
                return true;
            }
            else{
                System.out.println("\nI'll air on the safe side and go for the free courses");
                return false;
            }
        }
        catch(Exception e){
            System.out.println("\nI'll air on the safe side and go for the free courses");
            return false;
        }

    }

    public static void teachLesson(Programmer player){
        int numQuestions = player.getLanguage().getQuestions().size();
        for (int i = 0; i < 2; i++){
            Question q = player.getLanguage().getQuestions().get(i);
            askQuestionLesson(q, player.getPaidCourse());
        }

    }

    public static void askQuestionLesson(Question q, boolean paid){
        if (paid){
            System.out.println(q.getLesson());
        }
        q.printQuestion();
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        while(!q.checkAnswer(ans)){
            System.out.println("\nTry again!!!");
            ans = scanner.nextLine();
        }
        System.out.println("Great Job!!!\n");
    }

    public static boolean askQuestionInterview(Question q){
        q.printQuestion();
        Scanner scanner = new Scanner(System.in);
        String ans = scanner.nextLine();
        return q.checkAnswer(ans);
    }

    public static void giveInterview(Programmer player){
        int count = 0;
        int numQuestions = player.getLanguage().getQuestions().size();
        for(int i = 2; i < 4; i++){
            Question q = player.getLanguage().getQuestions().get(i);
            if(askQuestionInterview(q)){
                count++;
            }
        }
        if(count == 0 ){
            System.out.println("\nYou suck but we're short on staff so you're hired!");
            player.rankUp();
        }
        else if (count == numQuestions - (numQuestions/2)){
            System.out.println("\nYou are absolutely outstanding! You're hired!");
            player.rankUp();
        }
        else{
            System.out.println("\nYou passed! You're hired!");
            player.rankUp();
        }
        System.out.println("Congrats you are now a " + player.getRank() + " developer!");
    }

    public static ArrayList<String> readReviews(String fileName){
        ArrayList<String> reviews = new ArrayList<String>();
        File file = new File(fileName);
        try (Scanner input = new Scanner(file)) {

            while(input.hasNextLine()){
                reviews.add(input.nextLine());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("\nYou broke my simulator! That file doesn't exist dang it!");
        }
        return reviews;
    }

    public static void workLife(Programmer player, ArrayList<String> reviews){
        int choice;
        Scanner scanner = new Scanner(System.in);

        while(true){
            choice = (int) (Math.random() * reviews.size());
            System.out.println(reviews.get(choice));
            if(choice == 0){
                System.out.println("\nGAME OVER!!!");
                break;
            }
            else if (choice <= 7){
                player.anxietyUp(2);
            }
            else if (choice > 15 ){
                System.out.println("\nAnswer this question for a promotion:");
                if(promotion(player)){
                    System.out.println("\nYou got a promotion!");
                    player.rankUp();
                    System.out.println("Congrats you now have a " + player.getRank() + " position!");
                    player.anxietyDown();
                }
                else{
                    System.out.println("You got it wrong!");
                    player.anxietyUp(1);
                }

            }
            if(player.getAnxiety() >= 9){
                System.out.println("\nYou got too anxious so you quit your job to join the circus!");
                System.out.println("GAME OVER!");
                break;
            }

            if(player.getRank() == Rank.CEO){
                System.out.println("\nYou are now the boss and have all the money and have found the key to happiness!!");
                System.out.println("YOU WIN!");
                break;
            }

            System.out.println("Continue to next year? [Press Enter]");
            scanner.nextLine();
        }

    }

    public static boolean promotion(Programmer player){
        int choice = 0;

        if(player.getRank() == Rank.JUNIOR){
            choice = 4;
        }
        else{
            choice = 5;
        }
        return askQuestionInterview(player.getLanguage().getQuestions().get(choice));
    }

}

