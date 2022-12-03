//***********************************************
// Class: GameController
// Author: Keith Garfield
// Created: October 16, 2022
// Modified: Oct 20, 2022 -- Modified to add the generic agent, create movement, set win/loss conditions.
// Modified: Nov 21, 2022 -- Modified the moveAgent, isMoveLegal, and the createMaze methods
//
// Attributes: -maze: GenericTile[][] - An n-by-n array of tiles composing the maze. Order is [col][row].
//             -agent: GenericAgent - The agent moving through the maze.
//             -agentLocation: int[2] - The [col][row] position of the agent in the maze.
//             -turnCounter: int - Tracks move attempts. Increments for every attempt regardless of success.
//
// Game Play Methods: 
//          +playGame(): Moves that agent until agent wins or loses.
//          +agentIsInGoal(): boolean - Returns TRUE if the agent is in the goal tile, FALSE otherwise.
//          +hasAgentWon(): boolean - Returns TRUE if the agent is in the goal tile, FALSE otherwise.
//          +hasAgentLost(): boolean - Returns TRUE if turn counter has reached limit, FALSE otherwise. 
//
// Movement Methods:
//          +moveAgent(): void - Executes one game move. Updates agentLocation and increments turnCounter.
//          +isMoveLegal(): boolean - Returns TRUE if agent's requested move results in a change location, FALSE otherwise.
//          +isDoorLocked(GenericTile, int): boolean - Returns TRUE if door in current tile is locked, FALSE otherwise.
//                                                     Inputs are current tile location and direction (specified as an int).
//
// Game Creation Methods:
//          +createMaze(int, int): void - Creates an m-by-n array of tiles with doors randomly locked/unlocked.
//                                        Inputs are number of columns, number of rows.
//          +createMaze(int, int, boolean): void - Creates an m-by-n array of tiles, all doors locked or unlocked.
//                                        Inputs are number of columns, number of rows, locked status (TRUE or FALSE).
//			 +createMaze(String filename): void - Reads in Maze.dat for maze information.
////
//			+isMazeLegal(int, int): boolean - Returns true iff maze is n-by-n and n is odd.
//
// Printing Game State Methods:
//          +printMaze(): void - Prints the door status of every tile in the maze.
//          +printMazeSummary(): void - Prints the maze size, identifies Start and Goal tiles.
//          +convertExitsToString(): String - Utility method to compose a string from status of tile doors.
//          +printAgentLocation(): void - Prints [col][row] position of the agent. 
//
// Specialized Setters/Getters:
//          +setAgent(Agent): void - Creates the agent of specified type. Input is enumerated type Agent.
//
//***********************************************


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

//THIS IS XY/COL ROW FORM!!!! I REPEAT, THIS IS XY/COL ROW FORM
public class GameController {
	private GenericTile[][] maze;
	private GenericAgent agent;
	private int[] agentLocation = new int[2];
	private int turnCounter = 0;
	
	// ***** Game Play Methods *****
	public void playGame() {
		while (!hasAgentLost() && !hasAgentWon() ) {
			moveAgent();
			turnCounter++;
		}
		
		if ( hasAgentLost() ) {
			printAgentLocation();
			System.out.println("Agent has moved 50 times without reaching the goal. Agent has lost.");
		}
		
		if ( hasAgentWon() ) {
			printAgentLocation();
			System.out.println("Agent has reached the goal. Agent has won.");
		}
	}

	public boolean agentIsInGoal() {
		boolean inGoal = false;
		
		if ( agentLocation[0] == (maze.length -1) ) {
			if ( agentLocation[1] == ( (maze[0].length - 1 )/2 ) ) {
				inGoal = true;
			}
		}
		
		return inGoal;
	}
	
	public boolean hasAgentWon() {
		boolean agentWon = false;
		
		if ( agentIsInGoal() ) {
			agentWon = true;
		}	
		return agentWon;
	}
	
	public boolean hasAgentLost() {
		boolean agentLost = false;
		
		if (turnCounter > 50) {
			agentLost = true;
		}
		return agentLost;
	}
	
	// ***** Movement Methods *****
	public void moveAgent() {
		int direction = agent.move(); // Note: should use enumerated types?
		int col = agentLocation[0]; // This feels like a hack.
		int row = agentLocation[1];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] instanceof RotatingTile){
					double chance = Math.random();
					if(chance <= 0.01){
						((RotatingTile) maze[i][j]).rotateCounterClockwise();
					}
				}
			}
		}
		
		if ( isMoveLegal( direction ) ) {
			if (maze[col][row] instanceof RotatingTile){
				((RotatingTile) maze[col][row]).rotateClockwise();
			}
			switch (direction) {
				case 0: agentLocation[1]--;
						break;
				case 1: agentLocation[0]++;
						break;
				case 2: agentLocation[1]++;
						break;
				case 3: agentLocation[0]--;
						break;
				default: System.out.println("GameController: moveAgent() method default case activated. Something is wrong!");
			}
		}
		
		printAgentLocation();
	}
	
	public boolean isMoveLegal( int direction ) {
		boolean legality = true;
		int col = agentLocation[0]; // This feels like a hack.
		int row = agentLocation[1];
		
		if ( isDoorLocked( maze[col][row], direction ) ) {
			legality = false;
		}
		
		switch ( direction ) {
			case 0:
					if ( row == 0 ) {
						legality = false;
					}
					else if ( maze[col][row - 1] instanceof SolidTile) {
						legality = false;
					}
				break;
			case 1:
					if ( col == maze.length - 1 ) {
						legality = false;
					}
					else if ( maze[col + 1][row] instanceof SolidTile) {
						legality = false;
					}
					break;
			case 2:
					if ( row == maze[0].length - 1 ) {
						legality = false;
					}
					else if ( maze[col][row + 1] instanceof SolidTile) {
						legality = false;
					}
					break;
			case 3:
					if ( col == 0 ) {
						legality = false;
					}
					else if ( maze[col - 1][row] instanceof SolidTile) {
						legality = false;
					}
					break;
			default: System.out.println("GameController: isMoveLegal() method default case activated. Something is wrong!");
		}
		
		return legality;
	}
	
	public boolean isDoorLocked( GenericTile tile, int direction ) {
		return !tile.getSingleExit( direction );
	}
		
	// ***** Game Creation Methods *****
	public void createMaze( int cols, int rows ) {
		maze = new GenericTile[cols][rows];
		
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				double chance = Math.random();
				if(chance <= 0.50){
					maze[i][j] = new StaticTile();
					maze[i][j].setAllExitsRandom();
				}
				else if(chance <= 0.85){
					maze[i][j] = new RotatingTile();
					maze[i][j].setAllExitsRandom();
				}
				else{
					maze[i][j] = new SolidTile();
					maze[i][j].setAllExitsValue(false);
				}
			}
		}
		maze[0][(maze[0].length - 1) / 2] = new StaticTile();
		maze[0][(maze[0].length - 1) / 2].setAllExitsRandom();
		maze[maze[0].length-1][(maze[0].length - 1) / 2] = new StaticTile();
		maze[maze[0].length-1][(maze[0].length - 1) / 2].setAllExitsRandom();
	}

	public void createMaze(int cols, int rows, boolean doorValues) {
		maze = new GenericTile[cols][rows];
		
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				maze[i][j] = new GenericTile();
				maze[i][j].setAllExitsValue( doorValues );
				double chance = Math.random();
				if(chance <= 0.50){
					maze[i][j] = new StaticTile();
					maze[i][j].setAllExitsValue( doorValues );
				}
				else if(chance <= 0.85){
					maze[i][j] = new RotatingTile();
					maze[i][j].setAllExitsValue( doorValues );

				}
				else{
					maze[i][j] = new SolidTile();
					maze[i][j].setAllExitsValue(false);
				}
			}
		}
		maze[0][(maze[0].length - 1) / 2] = new StaticTile();
		maze[0][(maze[0].length - 1) / 2].setAllExitsValue(doorValues);
		maze[maze[0].length-1][(maze[0].length - 1) / 2] = new StaticTile();
		maze[maze[0].length-1][(maze[0].length - 1) / 2].setAllExitsValue(doorValues);
	}

	//loading from a file
	public void createMaze(String fileName){
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			// make a String called line
			String line;
			int cols = Integer.parseInt(br.readLine());
			int rows = Integer.parseInt(br.readLine());
			if(!isMazeLegal(rows, cols)){
				return;
			}

			maze = new GenericTile[cols][rows];

			for(int i = 0; i < cols; i++){
				for(int j = 0; j < rows; j++){
					line = br.readLine();
					String[] lineColumns;
					lineColumns = line.split(" ");

					if(lineColumns[2].equals("Static")){
						maze[i][j] = new StaticTile();

					}
					else if(lineColumns[2].equals("Solid")){
						maze[i][j] = new SolidTile();
					}
					else if(lineColumns[2].equals("Rotating")){
						maze[i][j] = new RotatingTile();

					}
					else{
						System.out.println("What the heck did you do to my code????");
					}

					for(int k = 0; k < 4; k++){
						if(lineColumns[k+4].equals("L")){
							maze[i][j].setSingleExit(k, false);
						}
						else{
							maze[i][j].setSingleExit(k, true);
						}
					}

				}
			}
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	// ***** Printing Game State Methods *****
	public void printMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j=0; j < maze[i].length; j++) {
				System.out.print("Tile (" + i + ", " + j + ") " );
				System.out.println( convertExitsToString(i, j));
			}
		}
		printMazeSummary();
	}
	
	public void printMazeSummary() {
		int cols = maze.length;
		System.out.print("There are " + cols + " rows and columns in the maze. ");
		System.out.print("Start is at (" + (cols - 1)/2 + ", 0), ");
		System.out.println("and Goal is at (" + (cols - 1)/2 + ", " + (cols-1) + ").");
	}
	
	public String convertExitsToString( int row, int col ) {
		boolean[] exits = maze[row][col].getAllExits();
		String msg = "(N, E, S, W) status: (";
		
		for (int i = 0; i < exits.length; i++) {
			if (exits[i]) {
				msg = msg + "U, ";
			} else {
				msg = msg + "L, ";
			}
		}
		msg = msg + ").";
		
		return msg;
	}
	
	public void printAgentLocation() {
		System.out.print("The agent is at column " + agentLocation[0]);
		System.out.println(" and row " + agentLocation[1] +".");
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
	public void setAgent( Agent agentType) {
		switch (agentType) {
		case Generic: agent = new GenericAgent();
					  break;
		case Greedy: agent = new GenericAgent();
					System.out.println("Gamecontroller: Creating Greedy agent requires definition.");
					  break;
		case LeftWall: agent = new GenericAgent();
					System.out.println("Gamecontroller: Creating LeftWall agent requires definition.");
					  break;
		default: agent = new GenericAgent();
		}
		
		agentLocation[0] = 0;
		agentLocation[1] = ( maze[0].length - 1) / 2;
		printAgentLocation();
	}
	

		
}