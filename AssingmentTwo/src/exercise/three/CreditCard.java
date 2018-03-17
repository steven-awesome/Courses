package exercise.three;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Steven Morrissey
 * COMP 268 - Assignment 2, Exercise 3
 */
public class CreditCard {
    private int evenSum;
    private int oddSum;
    private int sum;
    private String ccNumber;
    private String company;

    public CreditCard(String num) {

        this.ccNumber = num;
    }

    /**
     * Verifies the sums at the end of the luhn algorithm for integrity
     *
     * @return boolean whether the CC number is valid or not
     */
    public boolean isDivisibleBy10() {

        Integer ccNum = 0;
        try {
            //Parsing CC number so it can be verified and handling parsing error
            ccNum = Integer.parseInt(ccNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("CC number String contains non-numeric characters");
        }

        return getSum() % 10 == 0;
    }

    /**
     * Final verification of all 3 requirements of a valid CC number
     *
     * @return boolean whether CC number is valid or not
     */
    public boolean isValid() {

        if (validateLength() && validateNumber() && validateCompany()) {
            return true;
        }
        System.out.println("Card number provided is not valid: " + getCcNumber());
        return false;
    }

    /**
     * Verifies the starting of a CC number for a valid card provider
     *
     * @return boolean whether CC number is from a valid provider
     */
    public boolean validateCompany() {

        //Uses Regex to validate a card company before checking for and setting
        //individual company names. I felt there was less redundancy this way
        if (getCcNumber().matches("^4\\d*|5\\d*|6\\d*|(37)\\d*")) {
            if (getCcNumber().startsWith("4")) {
                company = "Visa";
            } else if (getCcNumber().startsWith("5")) {
                company = "MasterCard";
            } else if (getCcNumber().startsWith("37")) {
                company = "American Express";
            } else if (getCcNumber().startsWith("6")) {
                company = "Discover";
            }
            System.out.println("Valid card " + getCcNumber() +
                    " issued by: " + getCompany());
            return true;
        }
        return true;
    }

    /**
     * Verified a cc Number for valid length range
     *
     * @return boolean whether CC number is within valid range
     */
    public boolean validateLength() {

        if (getCcNumber().length() >= 13
                && getCcNumber().length() <= 16) {
            return true;
        }
        return false;
    }

    /**
     * This implements the main calculation of luhn algorithm.
     *
     * @return boolean whether the CC number meets the luhn criteria
     */
    public boolean validateNumber() {
        String ccNum = getCcNumber();

        try {
            //Parsing long immediately for error handling
            Long.parseLong(ccNumber);
            long[] numArray = new long[ccNum.length()];

            for (int i = 0; i < ccNum.length(); i++) {
                //using charAt index to return each character, then transforming to string
                //and finally parsing long into the numArray
                numArray[i] = Long.parseLong(
                        Character.toString(ccNum.charAt(i)));
            }

            //This implements the whole luhn algorithm calculation
            for (int i = numArray.length - 1; i >= 0; i--) {
                if ((i + 2) % 2 == 0) {
                    if (numArray[i] * 2 > 9) {
                        evenSum += (numArray[i] * 2) % 10 + 1;
                    } else {
                        evenSum += numArray[i] * 2;
                    }
                } else {
                    oddSum += numArray[i];
                }
            }

            //validating the sum of evenSum and oddSum
            return validateSums();
        } catch (NumberFormatException nfe) {
            System.out.println("CC number String contains non-numeric or " +
                    "invalid characters");
        }

        return false;
    }

    /**
     * Verifies if the sum at the end of the luhn algorithm is divisible by 10
     *
     * @return boolean whether divisible by 10 or not
     */
    public boolean validateSums() {
        sum = getEvenSum() + getOddSum();
        return isDivisibleBy10();
    }

    public int getEvenSum() {
        return evenSum;
    }

    public int getOddSum() {
        return oddSum;
    }

    public int getSum() {
        return sum;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public String getCompany() {
        return company;
    }

    public static void main(String[] args) {
        CreditCard cc1 = new CreditCard("4916986239473270");
        CreditCard cc2 = new CreditCard("5527938827663505");
        CreditCard cc3 = new CreditCard("6011800466522395");
        CreditCard cc4 = new CreditCard("370890549413843");
        CreditCard cc5 = new CreditCard("414141414141414");
        CreditCard cc6 = new CreditCard("5527ABCDEF663505");
        CreditCard cc7 = new CreditCard("49169862394732700000000");
        CreditCard cc8 = new CreditCard("4141414");
        CreditCard cc9 = new CreditCard("1916986239473270");
        cc1.isValid();
        cc2.isValid();
        cc3.isValid();
        cc4.isValid();
        cc5.isValid();
        cc6.isValid();
        cc7.isValid();
        cc8.isValid();
        cc9.isValid();
    }


}
