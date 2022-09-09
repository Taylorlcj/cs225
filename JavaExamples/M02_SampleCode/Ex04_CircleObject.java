// *********************************************************
// Class: CircleObject
// Author: Keith Garfield
// Date Created: Jan 17, 2020
// Date Modified: Jan 21, 2020 - why?
//
// Purpose: In class demonstration of declarations, object creation,
//          and basic operations
//
// Attributes: 	-xLocation: int - x-coordinate, center of circle
//				-yLocation: int - y-coordinate, center of circle
//				-radius: double - radius of the circle
//
// Methods: 	+calculateArea(): double - calculates and returns the area of the circle
//				+calculatePerimeter(): double - calculate and returns the perimeter of the circle
//*************************************************************

public class Ex04_CircleObject {
      private double xLocation, yLocation;
	  private double radius;	
	
	// ************************ Methods *********************
    public static void main(String[] args) {  
	  System.out.println("Somebody called the main method.");
    }	
	
	public double calculateArea() {
		return radius * radius * Math.PI;
	}
	
	public double calculatePerimeter() {
		return 2 * radius * Math.PI;
	}
	
	// ************ Setters and Getters **********************
	public double getXLocation() {
		return xLocation;
	}
	
	public void setXLocation(double newXLocation ) {
		xLocation = newXLocation;
	}
	
	public double getYLocation() {
		return yLocation;
	}
	
	public void setYLocation( double newYLocation ) {
		yLocation = newYLocation;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius( double newRadius ) {
		radius = newRadius;
	}
		
}