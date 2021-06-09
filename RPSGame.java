import java.util.Random;
public class RPSGame 
{

  private Random rand;
  private int playerScore;
  private int computerScore;
  private int rounds;
  private String computerChoice;
  private boolean playerWins;
  private boolean computerWins;

  //sets variable values
  public RPSGame(Random r) 
  {
    rand = r;
    rounds=0;
    playerScore=0;
    computerScore=0;
    playerWins=false;
    computerWins=false;
    computerChoice="";
  }//end RPSGame

  //checks player input
  public boolean isValidInput(String inputStr) 
  {
    if(inputStr.equals("R") || inputStr.equals("P") || inputStr.equals("S"))
    {
      return true;
    }//end if
    return false;
  }//end isValidInput

  //compares player input with computer choice
  public void playRound(String playerChoice) 
  {
    resetRound();
    computerChoice = getRandomChoice();
    if(computerChoice.equals("R") && playerChoice.equals("S"))
    {
      computerScore++;
      computerWins=true;
    }
    else if(computerChoice.equals("S") && playerChoice.equals("P"))
    {
      computerScore++;
      computerWins=true;
    }
    else if(computerChoice.equals("P") && playerChoice.equals("R"))
    {
      computerScore++;
      computerWins=true;
    }
    else if(computerChoice.equals("S") && playerChoice.equals("R"))
    {
      playerScore++;
      playerWins=true;
    }
    else if(computerChoice.equals("P") && playerChoice.equals("S"))
    {
      playerScore++;
      playerWins=true;
    }
    else if(computerChoice.equals("R") && playerChoice.equals("P"))
    {
      playerScore++;
      playerWins=true;
    }
    else
    {
      playerWins=false;
      computerWins=false;
    }
    rounds++;
  }//end playRound

  //return computerChoice
  public String getComputerChoice()
  {
    return computerChoice;
  }//end getComputerChoice

  //returns playerWins
  public boolean playerWins()
  {
    return playerWins;
  }//end playerWins

  //returns computerWins
  public boolean computerWins() 
  {
    return computerWins;
  }//end computerWins

  //determines tie
  public boolean isTie()
  {
    if(playerWins==false && computerWins==false)
    {
    return true;
    }
    return false;
  }//end isTie

  //returns rounds played + scores
  public String getScoreReportStr()
  {
    String report = "Total plays: "+rounds+"\nYour score: "+playerScore+", computer score: "+computerScore;

    return report;
  }//end getScoreReportStr

  //randomizes computerChoice
  private String getRandomChoice() 
  {
    int n = rand.nextInt(3);//random number(0-2)
    if(n==0)
    {
      return "R";
    }
    else if(n==1)
    {
      return "S";
    }
    else
    {
      return "P";
    }
  }//end getRandomChoice

  //resets round variables
  private void resetRound()
  {
    computerChoice = "";
    playerWins=false;
    computerWins=false;
  }//end resetRound

}//end RPSGame