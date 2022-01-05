import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class snakeGame {
    public static final int NO_PLAY = 0;
    public static final int LADDER = 1;
    public static final int SNAKE = 2;
    public int dieNo1 = 0;
    public int dieNo2 = 0;

    //Player intial Position
    public void showPosition() {
        int intialPosition = 0;
        out.println("Player Intial Position:" + intialPosition);
    }

    //intializing the Both Player Position
    int player1Position = 0;
    int player2Position = 0;

    //Call the Random Number for Player 1
    Random random = new Random();

    //Player Die Number for Player 1
    public int rollDie() {
        int dieNo1 = random.nextInt(6) + 1;
        out.println("Player 1 Dies Number: " + dieNo1);
        return dieNo1;
    }

    //Check for Player 1 Option
    public void option(int dieNo1) {
        int player1Option = random.nextInt(3);
        switch (player1Option) {
            case NO_PLAY:
                player1Position = dieNo1;
                out.println("Player 1 has to stay in Same postion " + "\t" + "& " + "\t" + "Position is:" + player1Position);
                break;
            case LADDER:
                player1Position = player1Position + dieNo1;
                out.println("Player 1 has got chance to move" + "\t" + "& " + "Position is:" + player1Position);
                break;
            case SNAKE:
                player1Position = player1Position - dieNo1;
                if (player1Position < 0) {
                    player1Position = 0;
                }
                out.println("Player 1 has bitten by snake" + "\t" + "& " + "Position is:" + player1Position);
                break;
        }
    }

    // Check for Player 2 Option
    public void option2(int dieNo2) {
        int player2Option = random.nextInt(3);
        switch (player2Option) {
            case NO_PLAY:
                player2Position = dieNo2;
                out.println("Player 2 has to stay in Same postion " + "\t" + "& " + "\t" + "Position is:" + player2Position);
                break;
            case LADDER:
                player2Position = player1Position + dieNo2;
                out.println("Player 2 has got chance to move" + "\t" + "& " + "Position is:" + player2Position);
                break;
            case SNAKE:
                player2Position = player2Position - dieNo2;
                if (player2Position < 0) {
                    player2Position = 0;
                }
                out.println("Player 2 has bitten by snake" + "\t" + "& " + "Position is:" + player2Position);
                break;
        }
    }

    public static void main(String[] args) {
        snakeGame player = new snakeGame();
        player.showPosition();
        while (player.player1Position < 100 && player.player2Position < 100) {
            int dieNo1 = player.rollDie();
            Scanner Player2 = new Scanner(System.in);
            out.println("Enter the Player 2 Die Number in Between 1 to 6 ");
            int dieNo2 = Player2.nextInt();
            player.option(dieNo1);
            player.option2(dieNo2);
            out.println("Player 1 Current Position is :" + player.player1Position);
            out.println("Player 2 Current Position :" + player.player2Position);
            if (player.player1Position == 100) {
                out.println("Player 1 Won the Game");
            } else if (player.player2Position == 100) {
                out.println("Player 2 Won the Game");
            } else {
                out.println("STILL GAME IS NOT OVER");
            }
        }
    }
}

