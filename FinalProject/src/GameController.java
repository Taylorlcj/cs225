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
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class GameController {
    public static void main(String[] args) {
        ArrayList<Computer> computers = loadComputers("ComputerTypes.txt");
        System.out.println();
        Programmer player  = createPlayer();
        System.out.println("Welcome to the simulator, " + player.getName());
        player.setComputer(pickComputer(computers));
        ArrayList<Language> languages = loadLanguages("ProgrammingLanguage.txt");
        player.setLanguage(pickLanguage(languages));
//        for (Language l : languages) {
//            System.out.println(l.getName());
//            System.out.println(l.getIde());
//            for (Question q : l.getQuestions()) {
//                q.printQuestion();
//            }
//            System.out.println(l.getQuestions().get(2).checkAnswer("b"));
//        }
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
            System.out.println("You broke my simulator! That file doesn't exist dangit!");
        }
        return computers;
    }

    public static ArrayList<Language> loadLanguages(String fileName){
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
                        String desc = input.nextLine();
                        String state = input.nextLine();
                        String ans = input.nextLine();
                        questions.add(createFillInTheBlank(desc, state, ans));
                    }
                    else if(type.equals("multiple-choice")) {
                        String quest = input.nextLine();
                        String[] ch = {input.nextLine(),input.nextLine(),input.nextLine()};
                        String ans = input.nextLine();
                        questions.add(createMultipleChoice(quest, ch, ans));
                    }
                    else{
                        break;
                    }
                }
                languages.add(new Language(name, questions, ide));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("You broke my simulator! That file doesn't exist dangit!");
        }
        return languages;
    }

    public static Question createMultipleChoice(String quest, String[] ch, String ans){
        MultipleChoice q = new MultipleChoice();
        q.setQuestion(quest);
        q.setChoices(ch);
        q.setAnswer(ans);
        return q;
    }
    public static Question createFillInTheBlank(String desc, String state, String ans){
        FillInTheBlank q = new FillInTheBlank();
        q.setDescrtiption(desc);
        q.setStatement(state);
        q.setAnswer(ans);
        return q;
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
