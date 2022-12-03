//***********************************************
// Class: GreedyAgent
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
public class GreedyAgent extends GenericAgent{

    public int move() {

//        for(int i = 0; i < getNeighborhood().length; i++){
//            for(int j = 0; j < getNeighborhood()[i].length; j++){
////                System.out.print(getNeighborhood()[i][j] + " ");
//            }
//            System.out.println();
//        }
        if(isNorthValid()){
            return 0;
        }
        else if(isEastValid()){
            return 1;
        }
        else if(isSouthValid()){
            return 2;
        }
        else if(isWestValid()){
            return 3;
        }

        return (int) Math.floor(4 * Math.random() );
    }

    private boolean isNorthValid(){
        if(getCurrenty() <= getGoaly()){
            return false;
        }
        if(getNeighborhood()[0][1] == null){
            return false;
        }
        if(getNeighborhood()[0][1] instanceof SolidTile){
            return false;
        }
        return getCurrentTile().getSingleExit(0);
    }

    private boolean isEastValid(){
        if(getCurrentx() >= getGoalx()){
            return false;
        }
        if(getNeighborhood()[1][2] == null){
            return false;
        }
        if(getNeighborhood()[1][2] instanceof SolidTile){
            return false;
        }
        return getCurrentTile().getSingleExit(1);
    }

    private boolean isSouthValid(){
        if(getCurrenty() >= getGoaly()){
            return false;
        }
        if(getNeighborhood()[2][1] == null){
            return false;
        }
        if(getNeighborhood()[2][1] instanceof SolidTile){
            return false;
        }
        return getCurrentTile().getSingleExit(2);
    }

    private boolean isWestValid(){
        if(getCurrentx() <= getGoalx()){
            return false;
        }
        if(getNeighborhood()[1][0] == null){
            return false;
        }
        if(getNeighborhood()[1][0] instanceof SolidTile){
            return false;
        }
        return getCurrentTile().getSingleExit(3);
    }

}
