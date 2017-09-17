package exercise.nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MovingRobotTest {

    @Before
    public void setUp() {

    }

    @Test
    public void validateNextMove() {
        MovingRobot mr1 = new MovingRobot(0, 2) {{
            nextMove = 3;
        }};
        MovingRobot mr2 = new MovingRobot(2, 0) {{
            nextMove = 1;
        }};
        MovingRobot mr3 = new MovingRobot(9, 2) {{
            nextMove = 4;
        }};
        MovingRobot mr4 = new MovingRobot(2, 9) {{
            nextMove = 2;
        }};
        MovingRobot mr5 = new MovingRobot(2, 2) {{
            nextMove = 5;
        }};

        assertEquals(false, mr1.validateNextMove());
        assertEquals(false, mr2.validateNextMove());
        assertEquals(false, mr3.validateNextMove());
        assertEquals(false, mr4.validateNextMove());
        assertEquals(true, mr5.validateNextMove());

    }

    @Test
    public void sameSlot() {
        //setting two robots with same coordinates
        MovingRobot mr1 = new MovingRobot(2, 2);
        MovingRobot mr2 = new MovingRobot(2, 2);
        //setting one robot with different coordinates
        MovingRobot mr3 = new MovingRobot(2, 1);

        //first two robots should occupy same slot
        assertEquals(true, MovingRobot.sameSlot(mr1, mr2));
        //3rd robot doesn't occupy same slot
        assertEquals(false, MovingRobot.sameSlot(mr1, mr3));

    }

    @Test
    public void printMoves() {

        //initializing a MovingRobot with a nexMove field set for simple testing
        MovingRobot mr = new MovingRobot(2, 3) {{
            nextMove = 3;
        }};
        //initalizing moves with a single value list, then validating next move
        //to initiate the move and add another move into the history
        mr.moves = new ArrayList<>(Collections.singletonList(1));
        mr.move();

        //verifies that both the initialized value and the applied move are in
        //the list
        assertEquals(new ArrayList<>(
                        Arrays.asList(1, 3)), mr.moves);

    }

    @Test
    public void move() {
        //initiaizing a new MovingRobot with a nextMove set
        MovingRobot mr1 = new MovingRobot(2, 3) {{
            nextMove = 3;
        }};
        //initializing a 2nd robot which is expected to be in the spot that
        //the 1st robot will be after it's move
        MovingRobot mr2 = new MovingRobot(1, 3);
        mr1.move();
        //verifying both coordinates to ensure it was done properly
        assertEquals(mr1.getX(), mr2.getX());
        assertEquals(mr1.getY(), mr2.getY());
    }

}