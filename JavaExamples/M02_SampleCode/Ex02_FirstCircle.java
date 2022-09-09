// *********************************************************
// Class: FirstCircle
// Author: Keith Garfield
// Date: Jan 17, 2020
//
// Purpose: In class demonstration of declaration and basic operations
//
// Attributes: none
//
// Methods: +main(): void
//
//*************************************************************

public class Ex02_FirstCircle {
	// attributes go here
	
  public static void main(String[] args) {
      int xLocation, yLocation;  
	  double radius;
	  
	  xLocation = 20;
	  yLocation = 15;
	  radius = 10.0;
	  
	  System.out.println("Circle center is at (" + xLocation + ", " + yLocation + ").");
	  System.out.println("Circle radius = " + radius + ".");
	  System.out.println("Circle Area = " + radius * radius * Math.PI + ".");

  }  
	
}  

