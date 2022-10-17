/*
*******************************************************
 Class: GameController
 Author: Taylor Jensen
 Date Created: Oct 16, 2022
 Purpose: Controls the maze and prints summary of maze
 Attributes: maze, playerLocation, turnCounter
 Method: createMaze
********************************************************
*/
public class GameController {

    private GenericTile[][] maze;

    public GenericTile[][] createMaze(int n){
        if (n % 2 == 0)
        {
            return null;
        }
        maze = new GenericTile[n][n];

        for (int row = 0; row <maze.length; row++)
        {
            for (int col = 0; col < maze[row].length; col++)
            {
                GenericTile tile = new GenericTile();
                maze[row][col] = tile;
            }
        }
        return maze;
    }
    public void printSummary()
    {
        for (int row = 0; row <maze.length; row++)
        {
            for (int col = 0; col < maze[row].length; col++)
            {
                System.out.println("Tile (" + row  + "," + col + ") " + maze[row][col].printStatus());
            }
        }
    }

}
