package exercise.two;

/**
 * Created by fista on 7/16/2017.
 */
public class RockPaperScissorsLizardSpock {

    private int conescutiveWins;
    private int lastWinner;
    private static final int LIZARD = 4;
    private static final int SPOCK = 5;
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;
    private static final int PLAYER1 = 6;
    private static final int PLAYER2 = 7;

    //Have to declare default constructor so I can use the other one for testing
    public RockPaperScissorsLizardSpock(){}

    //Declaring loaded constructor for testing purposes
    public RockPaperScissorsLizardSpock(int conescutiveWins, int lastWinner) {
        this.conescutiveWins = conescutiveWins;
        this.lastWinner = lastWinner;
    }

    public int getConescutiveWins(){
        return conescutiveWins;
    }

    public int getLastWinner() { return lastWinner; }

    public int random(){return (int) ( Math.random() * 4) + 1; }

    public static String convert(int i) {
        String name = "";
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
            case 6:
                name = "Player 1";
                break;
            case 7:
                name = "Player 2";
                break;
        }
        return name;
    }

    public void play(int player1, int player2) {

       while(getConescutiveWins() <= 3){
           int winner = 0;
           int playerOneRoll = random();
           int playerTwoRoll = random();
           System.out.println("PLayer 1 roll: " + convert(playerOneRoll)
                                +"\nPlayer 2 roll: " + convert(playerTwoRoll)
                                +"\n");
           if(playerOneRoll == playerTwoRoll){
               System.out.println("It's a tie! Restarting"
                                    +"\n=================\n");
               continue;
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
                   +"\n=================\n");

           if (getLastWinner() == 0 || getLastWinner() == winner) {
               conescutiveWins++;
           } else {
               conescutiveWins = 0;
           }

           lastWinner = winner;
       }


        System.out.println("Winner of the Game is " + convert(lastWinner) + "!");

    }

    public static void main(String[] args) {
        RockPaperScissorsLizardSpock e2 = new RockPaperScissorsLizardSpock();

        e2.play(RockPaperScissorsLizardSpock.PLAYER1, RockPaperScissorsLizardSpock.PLAYER2);
    }


}
