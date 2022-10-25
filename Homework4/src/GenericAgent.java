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
public class GenericAgent
{
    private GenericTile currentTile;
    private GenericTile[][] neighborhood = new GenericTile[3][3];

    public char move()
    {
        return ' ';
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
