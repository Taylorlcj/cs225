//***********************************************
// Class: LeftWallAgent
// Author: Taylor Jensen
// Created: December 3, 2022
//
// Attributes:
//
// Methods:
//
// Specialized setters and getters:
//
//
//***********************************************
public class LeftWallAgent extends GenericAgent{

    public int move(){

        for( int i = 0; i < 4; i++){
            int dir = (getDirectionEntered() + 1 + i) % 4;

            if(dir ==0 && isNorthValid()){
                return 0;
            }
            else if(dir ==1 && isEastValid()){
                return 1;
            }
            else if(dir ==2 && isSouthValid()){
                return 2;
            }
            else if(dir ==3 && isWestValid()){
                return 3;
            }
        }

        return (getDirectionEntered() +2) % 4;
    }
    private boolean isNorthValid(){
        if(getNeighborhood()[0][1] == null){
            return false;
        }
        if(getNeighborhood()[0][1] instanceof SolidTile){
            return false;
        }

        return getCurrentTile().getSingleExit(0);
    }

    private boolean isEastValid(){
        if(getNeighborhood()[1][2] == null){
            return false;
        }
        if(getNeighborhood()[1][2] instanceof SolidTile){
            return false;
        }
        return getCurrentTile().getSingleExit(1);
    }

    private boolean isSouthValid(){
        if(getNeighborhood()[2][1] == null){
            return false;
        }
        if(getNeighborhood()[2][1] instanceof SolidTile){
            return false;
        }
        return getCurrentTile().getSingleExit(2);
    }

    private boolean isWestValid(){
        if(getNeighborhood()[1][0] == null){
            return false;
        }
        if(getNeighborhood()[1][0] instanceof SolidTile){
            return false;
        }
        return getCurrentTile().getSingleExit(3);
    }
}
