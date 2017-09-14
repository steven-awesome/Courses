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
        String expected = "testzng    my zlass with juniz";
        String result = ReversedSentence.change5thPosition(s);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void printChar2DArray() {
        char[][] chr2DArray = new char[2][2];
        chr2DArray[0][0] = 't';
        chr2DArray[0][1] = 'e';
        chr2DArray[1][0] = 's';
        chr2DArray[1][1] = 't';

        String expectedOutput = "test";
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
        String expectedOutput = "tset gnirts ot esrever";

        Assert.assertEquals(expectedOutput, reversed);
    }

    @Test
    public void truncateSentence() {
        String original = "   test   ";
        String truncated = ReversedSentence.truncateSentence(original);
        String expected = "test";

        Assert.assertEquals(expected, truncated);
    }

}