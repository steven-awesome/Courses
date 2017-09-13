package exercise.one;


import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by fista on 7/16/2017.
 */
public class ReversedSentence {
    public static String change5thPosition(String s){
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArr.length; i++){
            if ( charArr[i] != ' ' && (i + 1) % 5 == 0) {
                charArr[i] = 'z';
            } else {

            }
        }
        sb.append(charArr);
        return sb.toString();
    }

    public static String printChar2DArray(char[][] arr){
        StringBuilder sb = new StringBuilder();
        for (char[] charArr : arr){
            for (char chr : charArr) {
                sb.append(chr + "\n");
            }
        }
        return sb.toString();
    }

    public static String reverseByCharacter(String s){
        char[] charArr = s.toCharArray();
        StringBuilder charArrCopy = new StringBuilder();
        for(int i = charArr.length - 1; i >=0; i--){
            charArrCopy.append(charArr[i]);
        }
        return charArrCopy.toString();
    }

    public static String reverseByWord(String s){
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            //re-using the existing method to do part of the work
            String reversedWord = reverseByCharacter(str);
            sb.append(reversedWord + " ");
        }
        String processedString = truncateSentence(sb.toString());

        return processedString;
    }

    public static String truncateSentence(String s){
        //Using built-in String method to remove trailing and leading whitespace
        return s.trim();
    }


}
