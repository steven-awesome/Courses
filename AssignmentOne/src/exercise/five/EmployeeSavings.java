package exercise.five;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 5
 */

import exercise.one.AddressBook;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class EmployeeSavings extends AddressBook{

    private double accountValue;
    private double[] monthlyInterests;
    private double[] monthlySavings;
    public static final double ANNUAL_INTEREST_RATE = 0.05;

    public EmployeeSavings(String firstName, String lastName){
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public EmployeeSavings(String firstName, String lastName,
                           double[] monthlyInterests, double[] monthlySavings) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.monthlyInterests = monthlyInterests;
        this.monthlySavings = monthlySavings;
    }

    /*
    ** Uses Java 8 functional streams that calculates total account value
     */
    public double getAccountValue() {
        accountValue += Arrays.stream(monthlySavings).sum();
        accountValue += Arrays.stream(monthlyInterests).sum();
        return accountValue;
    }

    public double[] getMonthlyInterest() {
        return monthlyInterests;
    }

    public double[] getMonthlySavings() {
        return monthlySavings;
    }

    /*
    ** Returns only the interests for each month
     */
    public double[] calculateInterests(){
        double lastMonthSavingsWithInterest = 0;
        double monthlyRate = 1 + (ANNUAL_INTEREST_RATE / 12);
        monthlyInterests = new double[12];
        for(int i = 0; i < monthlySavings.length; i++){
            if(i == 0){
                monthlyInterests[i] = (lastMonthSavingsWithInterest + monthlySavings[i])
                        * monthlyRate - lastMonthSavingsWithInterest - monthlySavings[i];
                lastMonthSavingsWithInterest =
                        (lastMonthSavingsWithInterest + monthlySavings[i]) * monthlyRate;
            } else {
                monthlyInterests[i] = monthlySavings[i] * monthlyRate - monthlySavings[i];
                lastMonthSavingsWithInterest = monthlySavings[i] * monthlyRate;
            }
        }
        return monthlyInterests;
    }

    public double[] generateMonthlySavings(){
        monthlySavings = new double[12];
        for (int i = 0; i < monthlySavings.length; i++) {
            monthlySavings[i] = Math.random() * 700 + 100;
        }
        return monthlySavings;
    }

    public static String getReport(EmployeeSavings[] arr){
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
        nf.setMaximumFractionDigits(2);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append("Account value for " + arr[i].getFirstName() + " " + arr[i].getLastName()
                    + " is: " + nf.format(arr[i].getAccountValue()) +"\n");
        }
        return sb.toString();
    }

    public static void main(String[] args){

        EmployeeSavings[] employeeSavings = new EmployeeSavings[]{
            new EmployeeSavings("Elena", "Brandon"),
            new EmployeeSavings("Thomas", "Molson"),
            new EmployeeSavings("Hamilton", "Winn"),
            new EmployeeSavings("Suzie", "Sarandin"),
            new EmployeeSavings("Philip", "Winne"),
            new EmployeeSavings("Alex", "Trebok"),
            new EmployeeSavings("Emma", "Pivoto"),
            new EmployeeSavings("John", "Lenthen"),
            new EmployeeSavings("James", "Lean"),
            new EmployeeSavings("Jane", "Ostin"),
            new EmployeeSavings("Emily", "Car"),
            new EmployeeSavings("Daniel", "Hamshire"),
            new EmployeeSavings("Neda", "Bazdar"),
            new EmployeeSavings("Aaron", "Smith"),
            new EmployeeSavings("Kate", "Hen")
        };

        List<EmployeeSavings> employeeSavingsList = Arrays.asList(employeeSavings);

        for (EmployeeSavings emp : employeeSavingsList) {
            emp.generateMonthlySavings();
            emp.calculateInterests();
        }
        System.out.print(EmployeeSavings.getReport(employeeSavings));

    }
}
