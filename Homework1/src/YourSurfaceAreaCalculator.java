/*
*******************************************************
Class: YourSurfaceAreaCalculator
 Author: Taylor Jensen
 Date Created: Sep 29, 2022
 Attributes: None
********************************************************
*/

import java.util.Scanner;
public class YourSurfaceAreaCalculator {
    public static void main( String[] args ) {
        double length, height, width;
        Scanner in = new Scanner( System.in );
// Test case 1: length = height = width = 0
        length = 0.0;
        height = 0.0;
        width = 0.0;
        System.out.println("Test case 1: length = height = width = 0" );
        System.out.println("Expected results: SA = 0.0, SASI = 0.0");
        System.out.print("Surface area in square inches, SA = " );
        System.out.println(2 * (length*height + width*height + length*width) +
                ".");
        System.out.print("Surface area in square centimeters, SASI = " );
        System.out.println(2.54 * 2.54 * 2 * (length*height + width*height +
                length*width) + ".\n\n");
// Test case 2: length = height = width = 0
        length = 15.0;
        height = 10.0;
        width = 0.0;
        System.out.println("Test case 2: length = 15.0, height = 10.0, width = 0.0" );
        System.out.println("Expected results: SA = 300.0, SASI = 1935.48");
        System.out.print("Surface area in square inches, SA = " );
        System.out.println(2 * (length*height + width*height + length*width) +
                ".");
        System.out.print("Surface area in square centimeters, SASI = " );
        System.out.println(2.54 * 2.54 * 2 * (length*height + width*height +
                length*width) + ".\n\n");
// Test case 3: length = height = width = 0
        length = 10.0;
        height = 1.0;
        width = 1.0;
        System.out.println("Test case 3: length = 10.0, height = 1.0, width = 1.0" );
        System.out.println("Expected results: SA = 42.0, SASI = 270.97");
        System.out.print("Surface area in square inches, SA = " );
        System.out.println(2 * (length*height + width*height + length*width) +
                ".");
        System.out.print("Surface area in square centimeters, SASI = " );
        System.out.println(2.54 * 2.54 * 2 * (length*height + width*height +
                length*width) + ".\n\n");
// Allow user to input values (no exception handling or verification of input)
        System.out.print("Input the length: ");
        length = in.nextDouble();
        System.out.print("Input the height: ");
        height = in.nextDouble();
        System.out.print("Input the width: ");
        width = in.nextDouble();
        System.out.print("Surface area in square inches, SA = " );
        System.out.println(2 * (length*height + width*height + length*width) +
                ".");
        System.out.print("Surface area in square centimeters, SASI = " );
        System.out.println(2.54 * 2.54 * 2 * (length*height + width*height +
                length*width) + ".\n\n");
    }
}