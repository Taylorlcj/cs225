/*
*******************************************************
 Class: YourSurfaceAreaCalculator
 Author: Taylor Jensen
 Date Created: Sep 29, 2022
 Attributes: None
********************************************************
*/

//I apologize if this sucks, I will do better next time
import java.util.Scanner;
public class YourSurfaceAreaCalculator {
    public static void main( String[] args ) {
        double length, height, width;
        Scanner in = new Scanner( System.in );

        // First Test case
        length = 0.0;
        height = 0.0;
        width = 0.0;
        System.out.println("First Test case: length = height = width = 0" );
        System.out.println("Expected results: SA = 0.0, SASI = 0.0");
        System.out.print("Surface area in inches squared, SA = " );
        System.out.println(2 * (length*height + width*height + length*width) + ".");
        System.out.print("Surface area in square centimeters, SASI = " );
        System.out.println(2.54 * 2.54 * 2 * (length*height + width*height + length*width) + ".\n\n");

        // Second Test case
        length = 15.0;
        height = 10.0;
        width = 0.0;
        System.out.println("Second Test case: length = 15.0, height = 10.0, width = 0.0" );
        System.out.println("Expected results: SA = 300.0, SASI = 1935.48");
        System.out.print("Surface area in square inches, SA = " );
        System.out.println(2 * (length*height + width*height + length*width) + ".");
        System.out.print("Surface area in square centimeters, SASI = " );
        System.out.println(2.54 * 2.54 * 2 * (length*height + width*height + length*width) + ".\n\n");

        // Third Test case
        length = 10.0;
        height = 1.0;
        width = 1.0;
        System.out.println("Third Test case: length = 10.0, height = 1.0, width = 1.0" );
        System.out.println("Expected results: SA = 42.0, SASI = 270.97");
        System.out.print("Surface area in square inches, SA = " );
        System.out.println(2 * (length*height + width*height + length*width) + ".");
        System.out.print("Surface area in square centimeters, SASI = " );
        System.out.println(2.54 * 2.54 * 2 * (length*height + width*height + length*width) + ".\n\n");


        System.out.print("Input length please: ");
        length = in.nextDouble();
        System.out.print("Input height please: ");
        height = in.nextDouble();
        System.out.print("Input width please: ");
        width = in.nextDouble();
        System.out.print("Surface area in square inches, SA = " );
        System.out.println(2 * (length*height + width*height + length*width) + ".");
        System.out.print("Surface area in square centimeters, SASI = " );
        System.out.println(2.54 * 2.54 * 2 * (length*height + width*height + length*width) + ".\n\n");
    }
}