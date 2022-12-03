//***********************************************
// Class: RotatingTile
// Author: Taylor Jensen
// Created: Nov 21, 2022
// Modified:
//
// Attributes:
//
// Methods: +rotateClockwise(): void - rotates the tile clockwise
//          +rotateClockwise(): void - rotates the tile counterclockwise
//
// Specialized setters and getters:
//
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
        boolean temp = getSingleExit(0);
        setSingleExit(0,  getSingleExit(1));
        setSingleExit(1,  getSingleExit(2));
        setSingleExit(2,  getSingleExit(3));
        setSingleExit(3,  temp);
    }
}
