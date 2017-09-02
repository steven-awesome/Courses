package exercise.nine;
/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 9
 */

import java.util.ArrayList;

public class Number {

    /*
    ** Checking conditions 1 by 1 and adding to list if true
     */
    public static ArrayList<String> iterate() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 113; i++) {
            String temp = i + ": ";
            if (isOdd(i)) {
                temp += i + " is odd, ";
            }
            if (isDivisibleBy5(i)) {
                temp += "hi five, ";
            }
            if (isDivisibleBy7(i)) {
                temp += "wow, ";
            }
            if (isPrime(i)) {
                temp += "prime";
            }
            temp += "\n";
            list.add(temp);
        }
        return list;
    }

    public static boolean isDivisibleBy5(int n) {

        return n % 5 == 0;
    }

    public static boolean isDivisibleBy7(int n) {

        return (n + (n + 1)) % 7 == 0;
    }

    public static boolean isOdd(int n) {

        return n % 2 != 0;
    }

    /*
    ** Prime is being checked by remainder of divisions of every number
    ** in sequence up to the square root of i
     */

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        for (String str : iterate()) {
            System.out.println(str);
        }
    }
}
