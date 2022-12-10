/*
*******************************************************
 Class: SimMain
 Author: Taylor Jensen
 Date Created: Dec 8, 2022
 Purpose:This class allows the game to start and end
 Attributes:

 Method:


********************************************************
*/
public class SimMain {
    public static void main(String[] args){
        GameController controller = new GameController();
        controller.simulate();
    }
}
