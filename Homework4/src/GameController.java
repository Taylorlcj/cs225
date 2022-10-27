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
//          -grabNeighbor
//          +placeAgent
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
                maze[i][j].setAllExitsRandom();
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
        System.out.print("Start is at (0, " + (cols - 1)/2 + ") ");
        System.out.println("and Goal is at (" + (cols - 1) + ", " + (cols-1)/2 + ").");
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
        player.setNeighborhood(grabNeighbor());
        turnCounter = 0;
    }

    private GenericTile[][] grabNeighbor(){

        GenericTile[][] tiles = new GenericTile[3][3];

        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col <3; col++)
            {
                if ((playerLocation[0]-1 + row) >= 0 && (playerLocation[1]-1 + col) >= 0 && (playerLocation[0]-1 + row) <maze.length && (playerLocation[1]-1 + col) <maze.length)
                {
                    tiles[row][col] = maze[playerLocation[0]-1 + row][playerLocation[1]-1 + col];
                }
            }
        }
        return tiles;
    }

    public void playGame()
    {
        while(turnCounter < 50 && (playerLocation[0] != (maze.length - 1)/2 || playerLocation[1] != maze.length - 1))
        {
            char direction = player.move();
            if(direction == 'X')
            {
                System.out.println("Agent is stuck!");
                return;
            }
            movePlayer(player.move());
            System.out.println("Agent is at (" + playerLocation[0] + ", "  + playerLocation[1] + ")");
            turnCounter += 1;
        }
        if (playerLocation[0] == (maze.length - 1)/2 && playerLocation[1] == maze.length - 1)
        {
            System.out.println("The agent has reached the goal line!");
        }
        else
        {
            System.out.println("This agent failed and is trash!");
        }
    }

    private void movePlayer(char direction)
    {
        if (direction == 'N')
        {
            playerLocation[0] -= 1;
        }
        else if (direction == 'E')
        {
            playerLocation[1] += 1;
        }
        else if (direction == 'S')
        {
            playerLocation[0] += 1;
        }
        else
        {
            playerLocation[1] -= 1;
        }
        player.setCurrentTile(maze[playerLocation[0]][playerLocation[1]]);
        player.setNeighborhood(grabNeighbor());
    }
// ***** Setters and Getters *****

}
