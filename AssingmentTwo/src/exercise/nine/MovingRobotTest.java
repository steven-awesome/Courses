package exercise.nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;

public class MovingRobotTest {

	@org.junit.Before
    public void setUp() {
        
    }

    @Test
    public void validateNextMove() {
    	MovingRobot mr1 = new MovingRobot(0, 2) {{nextMove = 3;}};
    	MovingRobot mr2 = new MovingRobot(2, 0) {{nextMove = 1;}};
    	MovingRobot mr3 = new MovingRobot(9, 2) {{nextMove = 4;}};
    	MovingRobot mr4 = new MovingRobot(2, 9) {{nextMove = 2;}};
    	MovingRobot mr5 = new MovingRobot(2, 2) {{nextMove = 5;}};
    	
    	assertEquals(false, mr1.validateNextMove());
    	assertEquals(false, mr2.validateNextMove());
    	assertEquals(false, mr3.validateNextMove());
    	assertEquals(false, mr4.validateNextMove());
    	assertEquals(true, mr5.validateNextMove());
    	
    }

    @Test
    public void sameSlot() {
    	MovingRobot mr1 = new MovingRobot(2, 2);
    	MovingRobot mr2 = new MovingRobot(2, 2);
    	
    	assertEquals(true, MovingRobot.sameSlot(mr1, mr2));
    	
    }

    @Test
    public void printMoves() {
   
    	MovingRobot mr = new MovingRobot(2, 3) {{nextMove = 3;}};
    	mr.moves = new ArrayList<>(Collections.singletonList(1));
    	mr.validateNextMove();
    	
    	assertEquals(new ArrayList<>(
    			Arrays.asList(1, 3)), 
    			mr.moves);
    	
    }

    @Test
    public void move() {
    	MovingRobot mr1 = new MovingRobot(2, 3) {{nextMove = 3;}};
    	MovingRobot mr2 = new MovingRobot(1, 3);
    	mr1.move();
    	assertEquals(mr1.getX(), mr2.getX());
    	assertEquals(mr1.getY(), mr2.getY());
    }

}