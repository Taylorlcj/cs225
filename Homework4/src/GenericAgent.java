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

        while(!done){
            int choice = (int)(Math.random() * 4);

            if(choice == 0)
            {
                direction = 'N';
                if (neighborhood[0][1] != null)
                {
                    if(currentTile.getSingleExit(choice))
                    {
                        done = true;
                    }
                }
            }
            else if(choice == 1)
            {
                direction = 'E';
                if (neighborhood[1][2] != null)
                {
                    if(currentTile.getSingleExit(choice))
                    {
                        done = true;
                    }
                }
            }
            else if(choice == 2)
            {
                direction = 'S';
                if (neighborhood[2][1] != null)
                {
                    if(currentTile.getSingleExit(choice))
                    {
                        done = true;
                    }
                }
            }
            else
            {
                direction = 'W';
                if (neighborhood[1][0] != null)
                {
                    if(currentTile.getSingleExit(choice))
                    {
                        done = true;
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
