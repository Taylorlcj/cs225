/*
*******************************************************
 Class: GameController
 Author: Taylor Jensen
 Date Created: Nov 6, 2022
 Purpose:This class allows the game to start and end
 Attributes:

 Method:
         +simulate():void
         +gameOver():boolean
         +createPlayer():Programmer
         +pickComputer(computers: ArrayList<Computer>):Computer
         +pickLanguage(languages:ArrayList<Language>):Language

********************************************************
*/

//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;


public class GameController {
    private Programmer player;
    public void simulate() {
        System.out.println();
        player  = createPlayer();
        printIntro();
        player.setComputer(pickComputer(loadComputers("ComputerTypes.txt")));
        System.out.println("\nYou go home and open your new computer!");
        System.out.print("Your computer displays: ");
        player.getComputer().printMessage();
        System.out.println("Great! Now that I have a computer, all I need is to pick my programming language to code in!\n");
        player.setLanguage(pickLanguage(loadLanguages("ProgrammingLanguage.txt")));
        player.setPaidCourse(pickCourse());
        teachLesson();
        giveInterview();
        System.out.println("Your work-life has started! You will now receive Yearly reviews!\n");
        workLife(readReviews("Reviews.txt"));
    }

    public void printIntro(){
        System.out.println("Welcome to the simulator, " + player.getName() + "!\n");
        System.out.println("*Wakes up in the morning*");
        System.out.println("Hey, I want to be a software developer!");
    }

    public Programmer createPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        if(name.trim().isEmpty()){
            name = "Anonymous";
        }
        return new Programmer(name, 0);
    }

    public Computer pickComputer(ArrayList<Computer> computers){
        int choice = 0;
        System.out.println("I'm going to go to Best Buy and pick out which computer I want to begin my journey with!\n");
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

    public Language pickLanguage(ArrayList<Language> languages){
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

    public boolean pickCourse(){
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

    public void teachLesson(){
        System.out.println("Let's get ready to learn!\n");
        int numQuestions = player.getLanguage().getQuestions().size();
        for (int i = 0; i < 2; i++){
            Question q = player.getLanguage().getQuestions().get(i);
            askQuestionLesson(q, player.getPaidCourse());
        }

    }

    public void askQuestionLesson(Question q, boolean paid){
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

    public void giveInterview(){
        int count = 0;
        System.out.println("\nI'm finally ready for my interview");
        System.out.println("**Goes to interview**\n");
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

    public ArrayList<String> readReviews(String fileName){
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

    public void workLife( ArrayList<String> reviews){
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
                if(promotion()){
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

    public boolean promotion(){
        int choice = 0;

        if(player.getRank() == Rank.JUNIOR){
            choice = 4;
        }
        else{
            choice = 5;
        }
        return askQuestionInterview(player.getLanguage().getQuestions().get(choice));
    }

    public ArrayList<Computer> loadComputers(String fileName){
        ArrayList<Computer> computers = new ArrayList<Computer>();
        File file = new File(fileName);
        try (Scanner input = new Scanner(file)) {
            while(input.hasNextLine()){
                String name = input.nextLine();
                String model = input.nextLine();
                computers.add(createComputer(name, model));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("You broke my simulator! That file doesn't exist dangit!");
        }
        return computers;
    }
    public Computer createComputer(String name, String model){
        if(name.toLowerCase().equals("mac")){
            return new Mac(model);
        }
        else if (name.toLowerCase().equals("windows")) {
            return new Windows(model);
        }
        else if (name.toLowerCase().equals("chrome")) {
            return new Chrome(model);
        }
        else{
            return new Linux(model);
        }
    }
    public ArrayList<Language> loadLanguages(String fileName){
        ArrayList<Language> languages = new ArrayList<Language>();
        File file = new File(fileName);
        try (Scanner input = new Scanner(file)) {

            //get all the languages
            while(input.hasNextLine()){
                String name = input.nextLine();
                String ide = input.nextLine();
                ArrayList<Question> questions = new ArrayList<Question>();
                //get all the questions
                while (input.hasNextLine()){
                    String type = input.nextLine();
                    if(type.equals("fill-in-the-blank")){
                        String lesson = input.nextLine();
                        String desc = input.nextLine();
                        String state = input.nextLine();
                        String ans = input.nextLine();
                        questions.add(createFillInTheBlank(desc, state, ans, lesson));
                    }
                    else if(type.equals("multiple-choice")) {
                        String lesson = input.nextLine();
                        String quest = input.nextLine();
                        String[] ch = {input.nextLine(),input.nextLine(),input.nextLine()};
                        String ans = input.nextLine();
                        questions.add(createMultipleChoice(quest, ch, ans, lesson));
                    }
                    else{
                        break;
                    }
                }
                languages.add(new Language(name, questions, ide));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("You broke my simulator! That file doesn't exist dang it!");
        }
        return languages;
    }

    public Question createMultipleChoice(String quest, String[] ch, String ans, String l){
        MultipleChoice q = new MultipleChoice();
        q.setQuestion(quest);
        q.setChoices(ch);
        q.setAnswer(ans);
        q.setLesson(l);
        return q;
    }
    public Question createFillInTheBlank(String desc, String state, String ans, String l){
        FillInTheBlank q = new FillInTheBlank();
        q.setDescription(desc);
        q.setStatement(state);
        q.setAnswer(ans);
        q.setLesson(l);
        return q;
    }

}

