//***********************************************
// Class: MGMain
// Author: Keith Garfield
// Created: October 16, 2022
// Modified: Taylor Jensen
//
// Attributes: +ctrl: GameController - Sets up and executes the game.
//
// Methods: +main(String[]): void - Creates the GameController object and begins the game.
//          +createMaze(int, int): void - Checks for legality of maze, requests controller to create the maze
//          +isMazeLegal(int, int): boolean - Returns true iff maze is n-by-n and n is odd.
//
//***********************************************
public class MGMain {
    private GameController ctrl = new GameController();
    // ***** Methods *****
    public static void main( String[] args ){
        MGMain me = new MGMain();
        me.createMaze(5, 5);
    }
    public void createMaze(int rows, int cols) {
        if (isMazeLegal(rows, cols) ) {
            ctrl.createMaze( rows, cols );
            ctrl.printMaze();
        }
    }
    public boolean isMazeLegal(int rows, int cols) {
        boolean legality = true;
        if ( rows != cols ) {
            legality = false;
            System.out.println("The maze does not have an equal number of rows and columns.");
            System.out.println("The maze will not be created.");
        }
        if ( rows%2 != 1 ) {
            legality = false;
            System.out.println("The maze does not have an odd number of rows and columns.");
            System.out.println("The maze will not be created.");
        }
        return legality;
    }
// ***** Setters and Getters *****
}