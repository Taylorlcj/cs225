//***********************************************
// Class: RotatingTile
// Author: Taylor Jensen
// Created: Nov 19, 2022
// Modified:
//
// Attributes: -exits: boolean[4] - An array of length 4 [N, E, S, W], #f = locked, #t = unlocked
//             -description: String - a text description of the room.
//
// Methods:
//
// Specialized setters and getters:
//          +setAllExitsValue( boolean ): void - Sets all exits to true or false.
//          +setAllExitsRandom(): void - sets all exits randomly (50/50 true or false)
//
//***********************************************
public class RotatingTile extends GenericTile{

    public void rotateClockwise(){
        boolean temp = getSingleExit(1);
        setSingleExit(1,  getSingleExit(0));
        setSingleExit(0,  getSingleExit(3));
        setSingleExit(3,  getSingleExit(2));
        setSingleExit(2,  temp);
    }

    public void rotateCounterClockwise(){

    }
}
