import java.util.Scanner;
import java.util.Random;

public class Main 
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to Rock, Paper, Scissors.\nYou will play against the computer! :)\n");

    Scanner scan = new Scanner(System.in);
    boolean keepPlaying = true;

    String playerStr = "", computerStr = "";
    int seed = 123456;

    Random rnd = new Random(seed);
    RPSGame game = new RPSGame(rnd);

    while(keepPlaying) 
    {
      System.out.println("Enter R for rock, P for paper, or S for scissors. Enter X to quit.");
      playerStr = scan.nextLine();
      System.out.println("You entered: "+playerStr);
      if(playerStr.equalsIgnoreCase("X"))
        keepPlaying = false;
      else if (game.isValidInput(playerStr))
      {
        game.playRound(playerStr);
        System.out.println("The computer chose: "+game.getComputerChoice());
        if(game.computerWins())
          System.out.println("Computer wins!");
        else if(game.playerWins())
          System.out.println("You win!");
        else
          System.out.println("It's a tie!");

        System.out.println(game.getScoreReportStr());

      }

    }
  System.out.println("\nThanks for playing!\nAshley Holm, Final Project");
  }
}