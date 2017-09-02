package exercise.ten;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 10
 */

import java.util.Scanner;

public class TaxReturn {
    /**
     * Constructs a TaxReturn object for a given income and
     * marital status, and computes the tax.
     *
     * @param anIncome the taxpayer income
     * @param aStatus  either SINGLE or MARRIED
     * @param children number of children
     */
    public TaxReturn(double anIncome, int aStatus, int children) {
        income = anIncome;
        status = aStatus;
        this.children = children;
    }
    /*
    ** tax is calculated based on marital status, # of children and income
     */
    public double getTax() {
        double tax = 0;
        if (status == SINGLE) {
            if (income <= SINGLE_BRACKET1)
                tax = RATE1 * income;
            else if (income <= SINGLE_BRACKET2)
                tax = RATE1 * SINGLE_BRACKET1
                        + RATE2 * (income - SINGLE_BRACKET1);
            else if (income <= SINGLE_BRACKET3)
                tax = RATE1 * SINGLE_BRACKET1
                        + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
                        + RATE3 * (income - SINGLE_BRACKET2);
            else if (income > SINGLE_BRACKET3)
                tax = RATE1 * SINGLE_BRACKET1
                        + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
                        + RATE3 * (SINGLE_BRACKET3 - SINGLE_BRACKET2)
                        + RATE4 * (income - SINGLE_BRACKET4);
        } else if (status == SINGLE_PARENT) {
            if (income <= SINGLE_BRACKET1)
                tax = RATE1 * income;
            else if (income <= SINGLE_BRACKET2)
                tax = RATE1 * SINGLE_BRACKET1
                        + RATE2 * (income - SINGLE_BRACKET1);
            else
                tax = RATE1 * SINGLE_BRACKET1
                        + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
                        + RATE3 * (income - SINGLE_BRACKET2);
            tax -= (CHILDREN_REDUCTION * children);
        } else if (status == MARRIED) {
            if (income <= MARRIED_BRACKET1)
                tax = RATE1 * income;
            else if (income <= MARRIED_BRACKET2)
                tax = RATE1 * MARRIED_BRACKET1
                        + RATE2 * (income - MARRIED_BRACKET1);
            else if (income <= MARRIED_BRACKET3)
                tax = RATE1 * MARRIED_BRACKET1
                        + RATE2 * (MARRIED_BRACKET2 - MARRIED_BRACKET1)
                        + RATE3 * (income - MARRIED_BRACKET2);
            else if (income > MARRIED_BRACKET3) {
                tax = RATE1 * MARRIED_BRACKET1
                        + RATE2 * (MARRIED_BRACKET2 - MARRIED_BRACKET1)
                        + RATE3 * (MARRIED_BRACKET3 - MARRIED_BRACKET2)
                        + RATE5 * (income - MARRIED_BRACKET4);
            }
        } else if (status == UNKNOWN) {
            tax = RATE6 * income;
        }
        return tax;
    }

    public static final int SINGLE = 1;
    public static final int SINGLE_PARENT = 3;
    public static final int MARRIED = 2;
    public static final int UNKNOWN = 0;
    private static final double RATE1 = 0.15;
    private static final double RATE2 = 0.28;
    private static final double RATE3 = 0.31;
    private static final double RATE4 = 0.25;
    private static final double RATE5 = 0.35;
    private static final double RATE6 = 0.33;
    private static final double SINGLE_BRACKET1 = 21450;
    private static final double SINGLE_BRACKET2 = 51900;
    private static final double SINGLE_BRACKET3 = 249999;
    private static final double SINGLE_BRACKET4 = 150000;
    private static final double MARRIED_BRACKET1 = 35800;
    private static final double MARRIED_BRACKET2 = 86500;
    private static final double MARRIED_BRACKET3 = 349999;
    private static final double MARRIED_BRACKET4 = 200000;
    private double income;
    private int status;
    private int children;
    private static final double CHILDREN_REDUCTION = 5000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your income: ");
        double income = in.nextDouble();
        System.out.print("Enter S (single), P (single parent) or M (married): ");
        String input = in.next();
        System.out.println("Enter number of children");
        int children = in.nextInt();
        int status = 0;
        if (input.equalsIgnoreCase("S"))
            if (children != 0)
                status = TaxReturn.SINGLE_PARENT;
            else
                status = TaxReturn.SINGLE;
        else if (input.equalsIgnoreCase("M"))
            status = TaxReturn.MARRIED;
        else if (input.equalsIgnoreCase("P"))
            status = TaxReturn.SINGLE_PARENT;
        else
            status = TaxReturn.UNKNOWN;
        TaxReturn aTaxReturn = new TaxReturn(income, status, children);
        System.out.println("The tax is " + aTaxReturn.getTax());
    }
}