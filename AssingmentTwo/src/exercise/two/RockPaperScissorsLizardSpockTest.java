package exercise.two;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;

public class RockPaperScissorsLizardSpockTest {

    @Spy
    public RockPaperScissorsLizardSpock rpsls;

    @Before
    public void setUp() {
        rpsls = new RockPaperScissorsLizardSpock();
    }

    @Test
    public void convert() {
    }

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {8, 2, 10},
                {4, 5, 9},
                {5, 5, 10}
        });
    }

    @Test
    public void play() {
        when(rpsls.getConescutiveWins()).thenReturn(4);
        rpsls = new RockPaperScissorsLizardSpock(4, 1);
        rpsls.play(1,2);
    }

}