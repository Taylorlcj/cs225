/*
*******************************************************
 Class: MGMain
 Author: Taylor Jensen
 Date Created: Oct 16, 2022
 Purpose: Runs the game
 Attributes: game: GameController
 Method: main(String[]): void
********************************************************
*/
public class MGMain {

    public static void main(String[] args)
    {
        GameController game = new GameController();
        game.createMaze(3);
        game.printSummary();
    }
}
