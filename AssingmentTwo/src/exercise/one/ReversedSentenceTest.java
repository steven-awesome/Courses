package exercise.one;

import org.junit.Assert;
import org.junit.Test;

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
    }

    @Test
    public void reverseByCharacter() {
    }

    @Test
    public void reverseByWord() {
    }

    @Test
    public void truncateSentence() {
    }

}