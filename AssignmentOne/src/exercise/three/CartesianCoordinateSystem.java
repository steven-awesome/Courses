package exercise.three;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 3
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class CartesianCoordinateSystem {

    /*
    **takes 2 coordinates, and uses built in Java Math library
    **to calculate the distance between the points
     */
    public double calculateDistance (double x1, double y1, double x2, double y2) {
        double differenceInX = x2 - x1;
        double differenceInY = y2 - y1;
        return Math.sqrt(Math.pow(differenceInX, 2)
                + Math.pow(differenceInY, 2));
    }

    public static void main(String[] args) {
        //Created the scanner and asked for input here as the API says
        //to accept the doubles in the method itself
        Scanner scanner = new Scanner(System.in);
        CartesianCoordinateSystem cartesianCoordinateSystem = new CartesianCoordinateSystem();
        NumberFormat nf = NumberFormat.getNumberInstance();

        System.out.println("Please enter X1");
        double x1 = scanner.nextDouble();
        System.out.println("Please enter Y1");
        double y1 = scanner.nextDouble();
        System.out.println("Please enter X2");
        double x2 = scanner.nextDouble();
        System.out.println("Please enter Y2");
        double y2 = scanner.nextDouble();

        nf.setMaximumFractionDigits(2);
        System.out.println(" Distance is: " + nf.format(cartesianCoordinateSystem.calculateDistance(x1, y1, x2, y2)));
    }

}
