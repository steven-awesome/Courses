package exercise.seven;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 7
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HailstoneSequence {

    public static ArrayList<Integer> getHailstoneSequence(int n) {
        ArrayList<Integer> hailstoneSequence = new ArrayList<>();
        hailstoneSequence.add(n);
        int total = n;
        while (true) {
            if (total == 1) {
                break;
            } else if (total % 2 == 0) {
                total /= 2;
                hailstoneSequence.add(total);
            } else {
                total = (total * 3) + 1;
                hailstoneSequence.add(total);
            }
        }
        return hailstoneSequence;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an integer to start sequence: ");
        List<Integer> hailstoneSequence =  HailstoneSequence.getHailstoneSequence(sc.nextInt());
        System.out.println(hailstoneSequence.toString() + "\n" +
                "Number of steps: " + hailstoneSequence.size());
    }
}
