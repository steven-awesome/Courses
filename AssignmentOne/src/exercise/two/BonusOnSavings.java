package exercise.two;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 2
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class BonusOnSavings {

    /*
    ** Takes the commitment and four quarterly parameters and calculates
     */
    public double computeBonus(double commitment, double q1, double q2, double q3, double q4) {
        final double quarterMinSavings = commitment * 3;
        final double annualMinSavings = commitment * 12;
        final double annualTotal = q1 + q2 + q3 + q4;
        double totalBonus = 0;

        //Declaring ArrayList so quarterly savings can be added then iterated
        // over for less redundancy
        ArrayList<Double> quarterlies = new ArrayList<>();
        quarterlies.addAll(Arrays.asList(q1, q2, q3, q4));

        //Adding up the eligible quarterly bonuses
        for (Double quarter : quarterlies) {
            if (quarter >= quarterMinSavings) {
                totalBonus += quarter * 0.03;
            }
        }

        //Logic for calculating total annual bonus
        if (annualTotal >= annualMinSavings) {
            totalBonus += annualTotal * 0.05;
            if (annualTotal >= annualMinSavings * 1.25) {
                totalBonus += (annualTotal - annualMinSavings);
            }
        }

        return totalBonus;
    }

    public static void main(String[] args) {
        //To format final savings for display purposes
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        //Creating two objects for test
        BonusOnSavings employeeOne = new BonusOnSavings();
        BonusOnSavings employeTwo = new BonusOnSavings();
        String employeeOneSavings = nf.format(
                employeeOne.computeBonus(2000, 5000, 7000, 4000, 8000)
        );
        String employeeTwoSavings = nf.format(
                employeTwo.computeBonus(3000, 6000, 9000, 10000, 17000)
        );
        System.out.println(employeeOneSavings);
        System.out.println(employeeTwoSavings);
    }

}
