package exercise.one;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ReversedSentenceTest {

    @Test
    public void change5thPosition() {
        String s = "testing    my class with junit";
        String expected = "testizg    my czass zith zunit";
        String result = ReversedSentence.change5thPosition(s);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void printChar2DArray() {
        char[][] chr2DArray = new char[2][6];
        chr2DArray[0][0] = 't';
        chr2DArray[0][1] = 'e';
        chr2DArray[0][2] = 's';
        chr2DArray[0][3] = 't';
        chr2DArray[0][4] = ' ';
        chr2DArray[1][0] = 's';
        chr2DArray[1][1] = 't';
        chr2DArray[1][2] = 'r';
        chr2DArray[1][3] = 'i';
        chr2DArray[1][4] = 'n';
        chr2DArray[1][5] = 'g';

        String expectedOutput = "test string";
        String printedArray = ReversedSentence.printChar2DArray(chr2DArray);

        Assert.assertEquals(expectedOutput, printedArray);

    }

    @Test
    public void reverseByCharacter() {
        String original = "test string to reverse";
        String reversed = ReversedSentence.reverseByCharacter(original);
        String expectedOutput = "esrever ot gnirts tset";

        Assert.assertEquals(expectedOutput, reversed);
    }

    @Test
    public void reverseByWord() {
        String original = "test string to reverse";
        String reversed = ReversedSentence.reverseByWord(original);
        String expectedOutput = "reverse to string test";

        Assert.assertEquals(expectedOutput, reversed);
    }

    @Test
    public void truncateSentence() {
        String original = "   test string to truncate   ";
        String truncated = ReversedSentence.truncateSentence(original);
        String expected = "test string to truncate";

        Assert.assertEquals(expected, truncated);
    }

}