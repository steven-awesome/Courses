package exercise.four;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 4
 */

import exercise.one.AddressBook;

import java.util.*;

public class BanffMarathonRunner extends AddressBook {

    private int time;
    private int years;
    public static BanffMarathonRunner[] runners;

    static {
        runners = new BanffMarathonRunner[]{
                new BanffMarathonRunner("Elena", "Brandon", 341, 1),
                new BanffMarathonRunner("Thomas", "Molson", 273, 2),
                new BanffMarathonRunner("Hamilton", "Winn", 278, 5),
                new BanffMarathonRunner("Suzie", "Sarandin", 329, 7),
                new BanffMarathonRunner("Philip", "Winne", 445, 9),
                new BanffMarathonRunner("Alex", "Trebok", 275, 3),
                new BanffMarathonRunner("Emma", "Pivoto", 275, 4),
                new BanffMarathonRunner("John", "Lenthen", 243, 1),
                new BanffMarathonRunner("James", "Lean", 334, 1),
                new BanffMarathonRunner("Jane", "Ostin", 412, 1),
                new BanffMarathonRunner("Emily", "Car", 393, 4),
                new BanffMarathonRunner("Daniel", "Hamshire", 299, 4),
                new BanffMarathonRunner("Neda", "Bazdar", 343, 3),
                new BanffMarathonRunner("Aaron", "Smith", 317, 6),
                new BanffMarathonRunner("Kate", "Hen", 265, 8)};

    }

    public BanffMarathonRunner(String fn, String ln, int min, int yr) {
        super.setFirstName(fn);
        super.setLastName(ln);
        this.time = min;
        this.years = yr;
    }

    public static BanffMarathonRunner getFastestRunner(BanffMarathonRunner[] runners) {
        Arrays.sort(runners, Comparator.comparing(BanffMarathonRunner::getTime));

        return runners[0];
    }

    /*
    ** Using Array util and Java 8 method reference to create concise, clear, non-redundant code.
    ** Passed in array will be sorted, and return the
     */
    public static BanffMarathonRunner getSecondFastestRunner(BanffMarathonRunner[] runners) {

        Arrays.sort(runners, Comparator.comparing(BanffMarathonRunner::getTime));

        if (runners.length > 1) {
            return runners[runners.length - 2];
        } else {
            return runners[0];
        }

    }

    public static double getAverageTime(BanffMarathonRunner[] runners) {
        int totalTime = 0;
        for (int i = 0; i < runners.length; i++) {
            totalTime += runners[i].getTime();
        }

        return ((double) totalTime) / runners.length;
    }

    public static String getAboveAverageRunners(BanffMarathonRunner[] runners) {
        StringBuilder sb = new StringBuilder();
        double averageTime = getAverageTime(runners);
        for (int i = 0; i < runners.length; i++) {
            BanffMarathonRunner runner = runners[i];
            if ((double) runner.getTime() >= averageTime) {
                sb.append(runner.getFirstName() + " " + runner.getYears() + "\n");
            }
        }

        return sb.toString();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public static void main(String[] args) {

        BanffMarathonRunner[] runners = new BanffMarathonRunner[]{
                new BanffMarathonRunner("Elena", "Brandon", 341, 1),
                new BanffMarathonRunner("Thomas", "Molson", 273, 2),
                new BanffMarathonRunner("Hamilton", "Winn", 278, 5),
                new BanffMarathonRunner("Suzie", "Sarandin", 329, 7),
                new BanffMarathonRunner("Philip", "Winne", 445, 9),
                new BanffMarathonRunner("Alex", "Trebok", 275, 3),
                new BanffMarathonRunner("Emma", "Pivoto", 275, 4),
                new BanffMarathonRunner("John", "Lenthen", 243, 1),
                new BanffMarathonRunner("James", "Lean", 334, 1),
                new BanffMarathonRunner("Jane", "Ostin", 412, 1),
                new BanffMarathonRunner("Emily", "Car", 393, 4),
                new BanffMarathonRunner("Daniel", "Hamshire", 299, 4),
                new BanffMarathonRunner("Neda", "Bazdar", 343, 3),
                new BanffMarathonRunner("Aaron", "Smith", 317, 6),
                new BanffMarathonRunner("Kate", "Hen", 265, 8)};

        BanffMarathonRunner runner = BanffMarathonRunner.getFastestRunner(runners);

        System.out.println("Name: " + runner.getFirstName() + " " + runner.getLastName()
                        + "\nYears: " + runner.getYears()
                        + "\n");
        System.out.println("Name: " + runner.getFirstName() + " " + runner.getLastName()
                + "\nYears: " + runner.getYears()
                + "\n");
    }
}
