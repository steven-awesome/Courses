package exercise.two;

/**
 * Steven Morrissey
 * COMP 268 - Assignment 2, Exercise 2
 */
public class RockPaperScissorsLizardSpock {

    private int consecutiveWins;
    private int lastWinner;
    private static final int LIZARD = 4;
    private static final int SPOCK = 5;
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    private static final int PLAYER1 = 6;
    private static final int PLAYER2 = 7;

    public int getConsecutiveWins() {
        return consecutiveWins;
    }

    public int getLastWinner() {
        return lastWinner;
    }

    /**
     * Uses Math.random() to calculate a number between 1 and 5
     *
     * @return Integer representing a die roll
     */
    public int random() {
        return (int) (Math.random() * 4) + 1;
    }

    //Using switch case as personally I find its great for legibility
    //especially in simple programs. Player 1 & 2 are included in this
    //method since they are declared as final static anyway and I can
    //use convert to produce the player string literals for use later on.

    /**
     * Takes an int and returns a String depending on the case
     *
     * @param i die roll or player number
     * @return String representation of either a die roll acton or player number
     */
    public static String convert(int i) {
        String name = "";
        //Using switch case as personally I find its great for legibility
        //especially in simple programs.
        switch (i) {
            case 1:
                name = "Rock";
                break;
            case 2:
                name = "Paper";
                break;
            case 3:
                name = "Scissors";
                break;
            case 4:
                name = "Lizard";
                break;
            case 5:
                name = "Spock";
                break;
            //Player 1 & 2 are included in this method since they are declared
            //as final static anyway and I can use convert to produce the player
            //string literals for use later on.
            case 6:
                name = "Player 1";
                break;
            case 7:
                name = "Player 2";
                break;
        }
        return name;
    }

    /**
     * Most game logic is done in the play method. After one player has 3
     * consecutive wins, the game ends. A player wins a round by rolling
     * a die and the resulting roll's corresponding action beats the other
     * players roll.
     *
     * @param player1 1st player in the game
     * @param player2 2nd player in the game
     */
    public void play(int player1, int player2) {

        //While loop will end once any player has 3 consecutive wins
        while (getConsecutiveWins() < 3) {
            int winner = 0;
            int playerOneRoll = random();
            int playerTwoRoll = random();
            System.out.println("PLayer 1 roll: " + convert(playerOneRoll)
                    + "\nPlayer 2 roll: " + convert(playerTwoRoll)
                    + "\n");
            if (playerOneRoll == playerTwoRoll) {
                System.out.println("It's a tie! Restarting"
                        + "\n=================\n");
                consecutiveWins = 0;
                lastWinner = 0;
                //restarting the loop
                continue;
                //conditions can be presented from one players perspective
                //and if that player doesn't win, the other player is made
                //the winner
            } else if (playerOneRoll == ROCK && playerTwoRoll == PAPER ||
                    playerOneRoll == ROCK && playerTwoRoll == SPOCK ||
                    playerOneRoll == PAPER && playerTwoRoll == SCISSORS ||
                    playerOneRoll == PAPER && playerTwoRoll == LIZARD ||
                    playerOneRoll == SCISSORS && playerTwoRoll == ROCK ||
                    playerOneRoll == SCISSORS && playerTwoRoll == SPOCK ||
                    playerOneRoll == LIZARD && playerTwoRoll == SCISSORS ||
                    playerOneRoll == LIZARD && playerTwoRoll == ROCK ||
                    playerOneRoll == SPOCK && playerTwoRoll == LIZARD ||
                    playerOneRoll == SPOCK && playerTwoRoll == PAPER) {
                winner = player2;
            } else {
                winner = player1;
            }

            System.out.println("Winner is: " + convert(winner)
                    + "\n=================\n");

            //Checking if a player has won for the first time or it's a
            //consecutive win
            if (getLastWinner() == 0 || getLastWinner() == winner) {
                consecutiveWins++;
            } else {
                consecutiveWins = 0;
            }

            //setting lastWinner to the current round winner to be compared on next
            //loop iteration
            lastWinner = winner;
        }


        System.out.println("Winner of the Game is " + convert(lastWinner) + "!");

    }

    public static void main(String[] args) {
        RockPaperScissorsLizardSpock e2 = new RockPaperScissorsLizardSpock();

        e2.play(RockPaperScissorsLizardSpock.PLAYER1, RockPaperScissorsLizardSpock.PLAYER2);
    }


}
