package exercise.one;

import java.util.Scanner;

/**
 * Steven Morrissey
 * COMP 268 - Assignment 2, Exercise 1
 */
public class ReversedSentence {
    public static String change5thPosition(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            if (i != 0
                    && charArr[i] != ' '
                    && i % 5 == 0) {
                charArr[i] = 'z';
            }
        }
        sb.append(charArr);
        return sb.toString();
    }

    /**
     * Transforms a sequential list of the characters from 2D array
     * to String
     *
     * @param arr a 2 dimension character array
     * @return String representation of the 2D chr array
     */
    public static String printChar2DArray(char[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (char[] charArr : arr) {
            for (char chr : charArr) {
                if (chr != 0) {
                    sb.append(chr);
                }
            }
        }
        return truncateSentence(sb.toString());
    }

    /**
     * A string is reversed char by char starting at the last index
     * and returned as a new string
     *
     * @param s String to be reversed
     * @return new String
     */
    public static String reverseByCharacter(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder charArrCopy = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) {
            charArrCopy.append(charArr[i]);
        }
        return charArrCopy.toString();
    }

    /**
     * A String is reversed word by word and returned as a new String
     *
     * @param s String to be reversed
     * @return new String
     */
    public static String reverseByWord(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            sb.append(strArr[i] + " ");
        }
        String processedString = truncateSentence(sb.toString());

        return processedString;
    }

    /**
     * Uses String trim() method to trim a provided String
     *
     * @param s String to trim
     * @return new String without trailing or leading whitespace
     */
    public static String truncateSentence(String s) {
        return s.trim();
    }

    public static void main(String[] args) {
        char[][] charArray = new char[3][80];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String temp;
            System.out.println("Please enter a sentence");
            while (sc.hasNextLine()) {
                temp = sc.nextLine();
                if (temp.length() <= 80) {
                    if (i == 0) {
                        charArray[i] = reverseByCharacter(temp).toCharArray();
                    } else if (i == 1) {
                        charArray[i] = reverseByWord(temp).toCharArray();
                    } else if (i == 2) {
                        charArray[i] = change5thPosition(temp).toCharArray();
                    }
                    break;

                } else {
                    System.out.println("Please enter a string less than 80 characters long");
                }
            }


        }

        System.out.println(printChar2DArray(charArray));
    }


}
