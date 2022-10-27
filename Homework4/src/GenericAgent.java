/*
*******************************************************
 Class: GenericAgent
 Author: Taylor Jensen
 Date Created: Oct 25, 2022
 Purpose: Creates the agent that moves along the board
 Attributes: GenericTile currentTile, GenericTile[][] neighborhood
 Method: public char move(),public void printTileDescription()
********************************************************
*/
import java.lang.Math;
public class GenericAgent
{
    private GenericTile currentTile;
    private GenericTile[][] neighborhood = new GenericTile[3][3];

    public char move()
    {
        char direction = ' ';
        boolean done = false;
        boolean[] attempted= new boolean[4];

        while(!done){
            int choice = (int)(Math.random() * 4);
            attempted[choice] = true;
            if (attempted[0] ==true && attempted[1] ==true && attempted[2] ==true && attempted[3] ==true)
            {
                done = true;
                direction = 'X';
            }
            if(choice == 0)
            {
                if (neighborhood[0][1] != null)
                {
                    if(currentTile.getSingleExit(choice))
                    {
                        done = true;
                        direction = 'N';
                    }
                }
            }
            else if(choice == 1)
            {
                if (neighborhood[1][2] != null)
                {
                    if(currentTile.getSingleExit(choice))
                    {
                        done = true;
                        direction = 'E';
                    }
                }
            }
            else if(choice == 2)
            {
                if (neighborhood[2][1] != null)
                {
                    if(currentTile.getSingleExit(choice))
                    {
                        done = true;
                        direction = 'S';
                    }
                }
            }
            else
            {
                if (neighborhood[1][0] != null)
                {
                    if(currentTile.getSingleExit(choice))
                    {
                        done = true;
                        direction = 'W';
                    }
                }
            }
        }
        return direction;
    }

    public void printTileDescription()
    {

    }

    //setters and getters
    public void setCurrentTile(GenericTile tile){
        currentTile = tile;
    }

    public void setNeighborhood(GenericTile[][] tiles){
        neighborhood = tiles;
    }
}
