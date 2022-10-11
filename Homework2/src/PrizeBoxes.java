import java.lang.Math;
public class PrizeBoxes {
    private int[] prizes;

    // ***** Methods *****
    public void createPrizeBoxes(int numBoxes) {
        prizes = new int[numBoxes];
    }

    public void initializePrizeBoxes() {
        for (int i = 0; i < prizes.length; i++) {
            prizes[i] = (int) Math.floor(81 * Math.random()) + 20;
        }
    }

    public void initializeSpecialPrizes() {
        int index = (int) Math.floor(prizes.length * Math.random());
        prizes[index] = 0;
        index = (int) Math.floor(prizes.length * Math.random());
        prizes[index] = -100;
    }
    //getter for the entire array
    public int[] getPrizes(){
        return prizes;
    }
    //setter for the entire array
    public void setPrizes(int[] p){
        prizes = p;
    }
    //getter for a specific element
    public int getPrize(int index){
        return prizes[index];
    }
    //setter for specific element
    public void setPrize(int index, int num){
            prizes[index] = num;
    }
    public void setAllBoxes(int value){
        for (int i = 0; i < prizes.length; i++) {
            prizes[i] = value;
        }
    }
}
