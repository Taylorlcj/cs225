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
public class GenericTile {
    private boolean[] exits;
    private String description;

    public GenericTile(){
        exits = new boolean[4];
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
}

