//***********************************************
// Class: GenericAgent
// Author: Keith Garfield
// Created: October 29, 2022
// Modified:
//
// Attributes: -currentTile: GenericTile - The tile tht agent is currently in.
//             -neighborhood: GenericTile[][] - a 3-by-3 array of tiles composed of current tile plus
//                            the eight adjacent tiles.
//				private int currentx;
//				private int currenty;
//				private int goalx;
//				private int goaly;
//private int directionEntered;
//
// Methods: +move(): int - Returns a random value: 0 = N, 1 = E, 2 = S, 3 = W.
//
// Specialized setters and getters:
//          +setNeighborhood( GenericTile[][] ): void - Sets the 3-by-3 array of neighborhood tiles.
//
//***********************************************
public class GenericAgent {
	private GenericTile currentTile;
	private GenericTile[][] neighborhood = new GenericTile[3][3];
	private int currentx;
	private int currenty;
	private int goalx;
	private int goaly;
	private int directionEntered;


	// ***** Methods *****
	public int move() {
		return (int) Math.floor(4 * Math.random() );
	}
	
	// ***** Setters and Getters *****
	public void setCurrentTile( GenericTile newTile ) {
		currentTile = newTile;
	}
	
	public GenericTile getCurrentTile() {
		return currentTile;
	}
	
	public void setNeighborhood( GenericTile[][] newNeighbors ) {
		neighborhood = newNeighbors;
	}

	public GenericTile[][] getNeighborhood() {
		return neighborhood;
	}

	public void setCurrentx(int currentx) {
		this.currentx = currentx;
	}

	public int getCurrentx() {
		return currentx;
	}

	public void setCurrenty(int currenty) {
		this.currenty = currenty;
	}

	public int getCurrenty() {
		return currenty;
	}

	public void setGoalx(int goalx) {
		this.goalx = goalx;
	}

	public int getGoalx() {
		return goalx;
	}

	public void setGoaly(int goaly) {
		this.goaly = goaly;
	}

	public int getGoaly() {
		return goaly;
	}

	public void setDirectionEntered(int directionEntered) {
		this.directionEntered = directionEntered;
	}

	public int getDirectionEntered() {
		return directionEntered;
	}
}