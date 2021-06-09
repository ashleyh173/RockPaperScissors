import java.util.Scanner;
import java.util.Random;

public class Main 
{
  public static void main(String[] args)
  {
    //intro text
    System.out.println("Don't you miss playing your favorite game of Rock Paper Scissors, \nbut can't play due to social distancing?\nLook no further and play against the computer! :)\n");

    Scanner scan = new Scanner(System.in);
    boolean keepPlaying = true;
    String playerStr = "", computerStr = "";
    int seed = 123456;
    Random rnd = new Random(seed);
    RPSGame game = new RPSGame(rnd);

    while(keepPlaying) 
    {
      System.out.println("Enter R for rock, P for paper, or S for scissors. Enter X to quit.");
      playerStr = scan.nextLine();//reads players input
      System.out.println("You entered: "+playerStr);
      if(playerStr.equalsIgnoreCase("X"))//if player ends game
      {
        keepPlaying = false;//end while loop
      }//end if
      else if (game.isValidInput(playerStr))
      {
        game.playRound(playerStr);
        System.out.println("The computer chose: "+game.getComputerChoice());
        //outputs winner of round
        if(game.computerWins())
        {
          System.out.println("Computer wins!");
        }//end if
        else if(game.playerWins())
        {
          System.out.println("You win!");
        }//end else if
        else
        {
          System.out.println("It's a tie!");
        }//end else
        System.out.println(game.getScoreReportStr());//updates score

      }//end else if

    }//end while loop
  //end game text
  System.out.println("\nThanks for playing!\nAshley Holm, Final Project");
  }//end main 
}//end Main class 