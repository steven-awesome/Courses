package exercise.nine;


import java.util.ArrayList;
import java.util.Random;

/**
 * Steven Morrissey
 * COMP 268 - Assignment 2, Exercise 9
 */
public class MovingRobot extends Robot {
    ArrayList<Integer> moves = new ArrayList<>();
    int nextMove = 0;

    public MovingRobot(int x, int y) {
        super(x, y);
    }

    /**
     * Verifies the next move for a robot does not take the out of
     * bounds
     *
     * @return boolean whether next move is within boundaries or not
     */
    public boolean validateNextMove() {
        if (x == 0 && (nextMove == LEFT ||
                nextMove == LEFT_DOWN_CORNER ||
                nextMove == LEFT_UP_CORNER)) {
            return false;
        } else if (x == 9 && (nextMove == RIGHT ||
                nextMove == RIGHT_DOWN_CORNER ||
                nextMove == RIGHT_UP_CORNER)) {
            return false;
        }

        if (y == 0 && (nextMove == LEFT_UP_CORNER ||
                nextMove == UP ||
                nextMove == RIGHT_UP_CORNER)) {
            return false;
        } else if (y == 9 && (nextMove == LEFT_DOWN_CORNER ||
                nextMove == DOWN ||
                nextMove == RIGHT_DOWN_CORNER)) {
            return false;
        }
        return true;
    }

    /**
     * Generates a new random number from 1-9
     *
     * @return int result of new generated random int
     */
    public int generateNextMove() {
        return new Random().nextInt(8) + 1;
    }

    /**
     * Verifies if 2 robots occupy the same x & y coordinates
     *
     * @param r1 1st robot
     * @param r2 2nd robot
     * @return boolean whether the 2 robots are occupying same space
     */
    public static boolean sameSlot(Robot r1, Robot r2) {
        return r1.getX() == r2.getX()
                && r1.getY() == r2.getY();
    }

    /**
     * iterates through a robots history of moves and prints result
     *
     * @return String history of robots moves
     */
    public String printMoves() {
        StringBuilder movesString = new StringBuilder();
        moves.forEach(move -> movesString.append(move + ", ").toString());
        return moves.toString();
    }

    /**
     * Assigns the robot to the space specified in the nextMove field
     */
    public void move() {
        switch (nextMove) {
            case UP:
                setY(getY() - 1);
                break;
            case DOWN:
                setY(getY() + 1);
                break;
            case LEFT:
                setX(getX() - 1);
                break;
            case RIGHT:
                setX(getX() + 1);
                break;
            case LEFT_UP_CORNER:
                setX(getX() - 1);
                setY(getY() - 1);
                break;
            case LEFT_DOWN_CORNER:
                setX(getX() - 1);
                setY(getY() + 1);
                break;
            case RIGHT_UP_CORNER:
                setX(getX() + 1);
                setY(getY() - 1);
                break;
            case RIGHT_DOWN_CORNER:
                setX(getX() + 1);
                setY(getY() + 1);
                break;
        }
        moves.add(nextMove);
        System.out.println("New coordinates: " + getX() + " " + getY());
        nextMove = 0;
    }

    public static void main(String[] args) {
        MovingRobot r1 = new MovingRobot(0, 0);
        MovingRobot r2 = new MovingRobot(9, 9);

        while (!sameSlot(r1, r2)) {
            r1.nextMove = r1.generateNextMove();
            if (r1.validateNextMove()) {
                System.out.println("Robot 1 move");
                r1.move();
            }
            if (sameSlot(r1, r2)) {
                break;
            }
            r2.nextMove = r2.generateNextMove();
            if (r2.validateNextMove()) {
                System.out.println("Robot 2 move");
                r2.move();
            }
        }
        System.out.println("Robot 1 sequence of moves: " + r1.printMoves());
        System.out.println("Robot 2 sequence of moves: " + r2.printMoves());
    }
}
