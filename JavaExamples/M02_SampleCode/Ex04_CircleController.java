//************************************************************
//  Class: CircleController
//  Author: Keith Garfield
//  Date Created: Jan 22, 2020
//  Modified: Jan 20, 2022 -- Added attributes and mtheods to comment block
//
//  Purpose: In class demonstration of object creation and use
//
//  Attributes: none
//
//  Methods: +main(String): void
//
//************************************************************
public class Ex04_CircleController {
	
	public static void main(String[] args) {
		Ex04_CircleObject circle01 = new Ex04_CircleObject();
		Ex04_CircleObject circle02 = new Ex04_CircleObject();
			
		System.out.println("Area = " + circle01.calculateArea() + ".");
		System.out.println("Perimeter = " + circle01.calculatePerimeter() + ".");
		
		circle01.setRadius(10);		
		System.out.println("Area = " + circle01.calculateArea() + ".");
		System.out.println("Perimeter = " + circle01.calculatePerimeter() + ".");

		circle01.setRadius(15);
		System.out.println("Area = " + circle01.calculateArea() + ".");
		System.out.println("Perimeter = " + circle01.calculatePerimeter() + ".");

		circle02.setRadius(18);		
		System.out.println("Area = " + circle02.calculateArea() + ".");
		System.out.println("Perimeter = " + circle02.calculatePerimeter() + ".");	
		
	}
}