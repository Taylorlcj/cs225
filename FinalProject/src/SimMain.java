/*
*******************************************************
 Class: SimMain
 Author: Taylor Jensen
 Date Created: Dec 8, 2022
 Purpose: This class runs the game
 Attributes:
 Method: +main(args: String[]): void

********************************************************
*/
public class SimMain {
    public static void main(String[] args){
        GameController controller = new GameController();
        controller.simulate();
    }
}
