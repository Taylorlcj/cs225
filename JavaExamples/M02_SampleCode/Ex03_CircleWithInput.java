// *********************************************************
// Class: CircleWithInput
// Author: Keith Garfield
// Date: Jan 17, 2020
// Modified: Aug 27, 2020 - Added inputs for x-, y- coordinates and displayed them.
//
// Purpose: In class demonstration of declaration and basic operations
//
// Attributes: none
//
// Methods: +main(): void
//
//*************************************************************
import java.util.Scanner;

public class Ex03_CircleWithInput {
	
	
  public static void main(String[] args) {
      double xLocation, yLocation;
	  double radius;
	  Scanner input = new Scanner(System.in);
	  
	  System.out.print("Enter a number for radius: ");
	  radius = input.nextDouble();
	  
	  System.out.print("Enter a number for circle center x-coordinate: ");
	  xLocation = input.nextDouble();
	  
  	  System.out.print("Enter a number for circle center y-coordinate: ");
	  yLocation = input.nextDouble();
	
	  
	  System.out.println("Circle center is at (" + xLocation + ", " + yLocation + ")");
	  System.out.println("Circle radius = " + radius + ".");
	  System.out.println("Circle Area = " + radius * radius * Math.PI + ".");
	  
  }  
	
}