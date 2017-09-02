package exercise.three;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class CreditCard {
    private int evenSum;
    private int oddSum;
    private int sum;
    private String ccNumber;
    private String company;

    public CreditCard(String num) {

        this.ccNumber = num;
    }

    public boolean isDivisibleBy10() {

        Integer ccNum = 0;
        try {
            ccNum = Integer.parseInt(ccNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("CC number String contains non-numeric characters");
        }

        return ccNum % 10 == 0;


    }
    public boolean isValid() {

        if (validateLength() && validateNumber() && validateCompany()) {
            return true;
        }
        System.out.println("Card number provided is not valid: " + getCcNumber());
        return false;
    }

    public boolean validateCompany() {

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

    public boolean validateLength() {

        if (getCcNumber().length() >= 13
                && getCcNumber().length() <= 16) {
            return true;
        }
        return false;
    }

    public boolean validateNumber(){
        String ccNum = getCcNumber();

        try {
            Long.parseLong(ccNumber);
            long[] numArray = new long[ccNum.length()];

            for (int i = 0; i < ccNum.length(); i++) {
                numArray[i] = Long.parseLong(
                        Character.toString(ccNum.charAt(i)));
            }

            for (int i = numArray.length - 1; i >= 0; i--) {
                if ((i + 2) % 2 == 0) {
                    if (numArray[i] * 2 > 9) {
                        evenSum += (numArray[i]*2) % 10 + 1;
                    } else {
                        evenSum += numArray[i] * 2;
                    }
                } else {
                    oddSum += numArray[i];
                }
            }

            return validateSums();
        } catch (NumberFormatException nfe) {
            System.out.println("CC number String contains non-numeric or " +
                                "invalid characters");
        }

        return false;
    }

    public boolean validateSums() {
        sum = getEvenSum() + getOddSum();
        return getSum() % 10 == 0;
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
        cc1.isValid();
        cc2.isValid();
        cc3.isValid();
        cc4.isValid();
        cc5.isValid();
        cc6.isValid();
    }


}
