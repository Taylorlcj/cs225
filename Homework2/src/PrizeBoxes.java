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
    public int[] getPrizes(){
        return prizes;
    }
    public void setPrizes(int[] p){
        prizes = p;
    }
}
