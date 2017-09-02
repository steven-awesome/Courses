package exercise.one;

import com.sun.deploy.util.StringUtils;

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
            sb.append(charArr.toString() + "\n");
        }
        return sb.toString();
    }

    public static String reverseByCharacter(String s){
        char[] charArr = s.toCharArray();
        ArrayList<Character> charArrCopy = new ArrayList<>();
        for(int i = charArr.length - 1; i >=0; i--){
            charArrCopy.add(charArr[i]);
        }
        return charArrCopy.toString();
    }

    public static String reverseByWord(String s){
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            sb.append(strArr[i] + " ");
        }

        return sb.toString();
    }

    public static String truncateSentence(String s){
        return s.trim();
    }


}
