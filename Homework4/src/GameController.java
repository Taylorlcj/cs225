//***********************************************
// Class: GameController
// Author: Keith Garfield
// Created: October 16, 2022
// Modified:
//
// Attributes: -maze: GenericTile[][] -- An n-by-n array of tiles composing the maze
//             -private GenericAgent player;
//             -private int[] playerLocation = new int[2];
//             -private int turnCounter;
//
// Methods: +createMaze(int, int): void - Creates the maze, requests the tiles to set their door status.
//          +printMaze: void - Prints the door status of every tile in the maze.
//          +printMazeSummary: void - Prints the maze size, identifies Start and Goal tiles.
//          +convertExitsToString: String - Utility method to compose a string from status of tile doors.
//
//***********************************************
public class GameController {
    private GenericTile[][] maze;
    private GenericAgent player;
    private int[] playerLocation = new int[2];
    private int turnCounter;


    // ***** Methods *****
    public void createMaze( int rows, int cols ) {
        maze = new GenericTile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = new GenericTile();
                maze[i][j].setAllExitsValue( true );
            }
        }
    }
    public void printMaze() {
        for (int i = 0; i < maze.length; i++)
        {
            for (int j=0; j < maze[i].length; j++)
            {
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
        for (int i = 0; i < exits.length; i++)
        {
            if (exits[i])
            {
                msg = msg + "U, ";
            }
            else
            {
                msg = msg + "L, ";
            }
        }
        msg = msg + ").";
        return msg;
    }

    public void placeAgent()
    {
        player  = new GenericAgent();
        playerLocation[0] = (maze.length-1)/2;
        playerLocation[1] = 0;
        player.setCurrentTile(maze[playerLocation[0]][playerLocation[1]]);
    }

    private GenericTile[][] grabNeighbor(){

        GenericTile[][] tiles = new GenericTile[3][3];

        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col <3; col++)

            {
                tiles[row][col] = maze[playerLocation[0]-1 + row][playerLocation[1]-1 + col];
            }
        }
        return tiles;
    }

// ***** Setters and Getters *****

}
