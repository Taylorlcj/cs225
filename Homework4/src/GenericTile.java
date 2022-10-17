/*
*******************************************************
 Class: GenericTile
 Author: Taylor Jensen
 Date Created: Oct 16, 2022
 Purpose: Creating a single tile for the board
 Attributes: exits: Boolean[4], description: string
 Method: enterAction(): void , exitAction(): void , specialAction(): void
********************************************************
*/
import java.lang.Math;
public class GenericTile {
    private boolean[] exits;
    private String description;

    //
    public GenericTile(){
        exits = new boolean[4];
        for (int i = 0; i < 4; i++)
        {
            int choice = (int) Math.floor(2 * Math.random());
            if(choice == 1)
            {
                exits[i] = true;
            }
        }
    }

    public void enterAction(){

    }
    public void exitAction(){

    }
    public void specialAction(){

    }

    //setter for Description
    public void setDescription(String description) {
        this.description = description;
    }

    //getter for getDescription
    public String getDescription() {
        return description;
    }

    //setter for Exits
    public void setExits(boolean[] exits) {
        this.exits = exits;
    }

    //getter for Exits
    public boolean[] getExits() {
        return exits;
    }

    public String printStatus()
    {
        String printStatus = "(N, S, E, W) status: (";
        if(exits[0] == true)
        {
           printStatus += "U,";
        }
        else
        {
            printStatus += "L,";
        }
        if(exits[1] == true)
        {
            printStatus += "U,";
        }
        else
        {
            printStatus += "L,";
        }
        if(exits[2] == true)
        {
            printStatus += "U,";
        }
        else
        {
            printStatus += "L,";
        }
        if(exits[3] == true)
        {
            printStatus += "U)";
        }
        else
        {
            printStatus += "L)";
        }
        return printStatus;
    }
}

