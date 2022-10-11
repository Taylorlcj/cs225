import java.util.Scanner;

/*
*******************************************************
 Class: GameController
 Author: Taylor Jensen
 Date Created: Oct 11, 2022
 Attributes: None
********************************************************
*/
public class GameController {
    public static void main(String[] args) {
        PrizeBoxes prizes = new PrizeBoxes();
        prizes.createPrizeBoxes(30);
        prizes.initializePrizeBoxes();
        prizes.initializeSpecialPrizes();

        Scanner input = new Scanner(System.in);
        int total = 0;
        for (int i = 0; i<5; i++){
            System.out.println("Please choose a box");
            int choice = input.nextInt();
            total += prizes.getPrize(choice);
            System.out.println(prizes.getPrize(choice));
        }
        System.out.println(total);
    }
}