//***********************************************
// Class: MGMain
// Author: Keith Garfield
// Created: October 16, 2022
// Modified: October 30, 2022 - Added requests to create agent and play the game.
//
// Attributes: +ctrl: GameController - Sets up and executes the game.
//
// Methods: +main(String[]): void - Creates the GameController object and begins the game.
//          +createMaze(int, int): void - Checks for legality of maze, requests controller to create the maze.
//                                 Maze is created with randomize locked/unlocked doors.
//          +createMaze(int, int, boolean): void - Maze is created with all doors locked or unlocked.
//          +createAgent( Agent ): void - Requests controller to create agent. Input enumerated type Agent.
//          +playGame(): void - Requests controller to play the entire game.
//
//***********************************************

public class MGMain {
	private GameController ctrl = new GameController();
	
	// ***** Methods *****
	public static void main( String[] args ){
		MGMain me = new MGMain();
//		me.createMaze(5, 5);
		me.createMaze("Maze.dat");
		me.createAgent( Agent.LeftWall);
		me.playGame();
	}
	
	public void createMaze(int rows, int cols) {
		if (ctrl.isMazeLegal(rows, cols) ) {
			ctrl.createMaze( rows, cols );
			ctrl.printMaze();
		}
	}

	public void createMaze(int rows, int cols, boolean doorValue) {
		if (ctrl.isMazeLegal(rows, cols) ) {
			ctrl.createMaze( rows, cols, doorValue );
			ctrl.printMaze();
		}
	}
	//reading from a file
	public void createMaze(String fileName){
		ctrl.createMaze(fileName);
		ctrl.printMaze();
	}
	
	public void createAgent( Agent agentType) { 
		ctrl.setAgent( agentType);
	}
	
	public void playGame() {
		ctrl.playGame();
	}


	
	// ***** Setters and Getters *****
}