package exercise.six;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 6
 */

public class Triangle {

    private boolean rightTriangle;
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isRightTriangle() {

        if (Math.pow(this.getA(), 2) + Math.pow(this.getB(), 2) == Math.pow(this.getC(), 2)){
            return true;
        }
        else {
            return false;
        }

    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public static void main(String[] args) {
        Triangle triangleA = new Triangle(48, 0, 80);
        Triangle triangleB = new Triangle(84, 0, 91);
        Triangle triangleC = new Triangle(45, 55, 75);
        Triangle triangleD = new Triangle(28, 45, 53);

        System.out.println("Triangle A side B: " + Math.sqrt(Math.pow(triangleA.getC(), 2) - Math.pow(triangleA.getA(), 2)));
        System.out.println("Triangle B side B: " + Math.sqrt(Math.pow(triangleB.getC(), 2) - Math.pow(triangleB.getA(), 2)));
        System.out.println("Triangle C isRightTriangle: " + triangleC.isRightTriangle()
                            + "\nTriangle D isRightTriangle: " + triangleD.isRightTriangle());
    }
}
