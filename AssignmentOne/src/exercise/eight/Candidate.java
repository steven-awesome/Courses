package exercise.eight;

/*
Steven Morrissey
May 23, 2017
Comp 268
Assignment 1, Exercise 8
 */

import exercise.one.AddressBook;

import java.util.ArrayList;
import java.util.List;

public class Candidate extends AddressBook {
    private boolean innovation;
    private double grade;
    private double regulation;
    private String communication;

    public Candidate(String fn, String ln, double grade, String comm, boolean innov, double reg) {
        super.setFirstName(fn);
        super.setLastName(ln);
        this.innovation = innov;
        this.grade = grade;
        this.regulation = reg;
        this.communication = comm;
    }

    /*
    ** Method takes each candidate passed in and checks first for grade and
    ** then subsequent checks for communication and then innovation, else if grades
    ** arent met check for regulation and communication.
     */
    public static ArrayList<Candidate> getEligibleCandidates(Candidate[] cands) {
        ArrayList<Candidate> eligibleCands = new ArrayList<>();
        for (Candidate cand : cands) {
            if (cand.getGrade() >= 85) {
                if (!cand.getCommunication().equals("poor")) {
                    eligibleCands.add(cand);
                } else if (cand.getCommunication().equals("poor") && cand.isInnovative() == true) {
                    eligibleCands.add(cand);
                }
            } else if (cand.getGrade() < 85
                    && cand.getRegulation() >= 0.5
                    && !cand.getCommunication().equals("poor")) {
                eligibleCands.add(cand);
            }
        }
        return eligibleCands;
    }

    public boolean isInnovative() {
        return innovation;
    }

    public void setInnovation(boolean innovation) {
        this.innovation = innovation;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getRegulation() {
        return regulation;
    }

    public void setRegulation(double regulation) {
        this.regulation = regulation;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public static void main(String[] args) {
        Candidate[] candidates = new Candidate[]{
                new Candidate("Elena", "Brandon", 82.30, "poor", true, 0.5),
                new Candidate("Thomas", "Molson", 85.10, "poor", false, 1.0),
                new Candidate("Hamilton", "Winn", 77.77, "average", false, .8),
                new Candidate("Suzie", "Sarandin", 69.93, "average", false, 0),
                new Candidate("Philip", "Winne", 93.03, "average", true, 1.0),
                new Candidate("Alex", "Trebok", 88.61, "poor", true, 0.7),
                new Candidate("Emma", "Pivoto", 55.99, "excellent", false, 0.8),
                new Candidate("John", "Lenthen", 87.49, "excellent", true, 0.9),
                new Candidate("James", "Lean", 88.00, "average", false, 0.5),
                new Candidate("Jane", "Ostin", 91.20, "excellent", true, 0.6),
                new Candidate("Emily", "Car", 66.79, "average", false, 0.3),
                new Candidate("Daniel", "Hamshire", 76.65, "average", true, 0.2),
                new Candidate("Neda", "Bazdar", 55.89, "excellent", true, 0.5),
                new Candidate("Aaron", "Smith", 90.01, "excellent", false, 0.3),
                new Candidate("Kate", "Hen", 87.9, "poor", false, 0.8)
        };

        List<Candidate> candidateList = getEligibleCandidates(candidates);
        StringBuilder sb = new StringBuilder("Eligible Candidates: ");
        candidateList.forEach(cand -> sb.append("\n" + cand.getFirstName() + " " + cand.getLastName()));
        System.out.println(sb.toString());
    }
}
