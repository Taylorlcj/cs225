/*
*******************************************************
 Class: GameController
 Author: Taylor Jensen
 Date Created: Oct 11, 2022
 Attributes: None
********************************************************
*/
import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        PrizeBoxes prizes = new PrizeBoxes();
        prizes.createPrizeBoxes(30);
        prizes.initializePrizeBoxes();
        prizes.initializeSpecialPrizes();

        Scanner input = new Scanner(System.in);
        int total = 0;
        for (int i = 0; i<5; i++){
            System.out.println("Please choose a box between and including 1 and 30");
            int choice = input.nextInt() - 1;
            while(choice < 0 || choice >29){
                System.out.println("You entered an invalid value, please try again!");
                System.out.println("Please choose a box between and including 1 and 30");
                choice = input.nextInt() - 1;
            }
            total += prizes.getPrize(choice);
            System.out.println("Your prize is: " + prizes.getPrize(choice));
        }
        System.out.println("Your grand total is " + total + "\n");



        total = 0;
        prizes.setAllBoxes(101);
        System.out.println("At least one box has a value greater than 100");
        for (int i = 0; i<5; i++){
            System.out.println("Please choose a box between and including 1 and 30");
            int choice = input.nextInt() - 1;
            while(choice < 0 || choice >29){
                System.out.println("You entered an invalid value, please try again!");
                System.out.println("Please choose a box between and including 1 and 30");
                choice = input.nextInt() - 1;
            }
            total += prizes.getPrize(choice);
            System.out.println("Your prize is: " + prizes.getPrize(choice));
        }
        System.out.println("Your grand total is " + total + "\n");



        total = 0;
        prizes.setAllBoxes(50);
        System.out.println("There are no boxes that have a value of -100");
        for (int i = 0; i<5; i++){
            System.out.println("Please choose a box between and including 1 and 30");
            int choice = input.nextInt() - 1;
            while(choice < 0 || choice >29){
                System.out.println("You entered an invalid value, please try again!");
                System.out.println("Please choose a box between and including 1 and 30");
                choice = input.nextInt() - 1;
            }
            total += prizes.getPrize(choice);
            System.out.println("Your prize is: " + prizes.getPrize(choice));
        }
        System.out.println("Your grand total is " + total);
    }
}