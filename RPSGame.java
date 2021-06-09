import java.util.Random;
public class RPSGame {

  private Random rand;
  private int playerScore;
  private int computerScore;
  private int rounds;
  private String computerChoice;
  private boolean playerWins;
  private boolean computerWins;

  public RPSGame(Random r) 
  {
    rand = r;
    rounds=0;
    playerScore=0;
    computerScore=0;
    playerWins=false;
    computerWins=false;
    computerChoice="";
  }

  public boolean isValidInput(String inputStr) 
  {
    if(inputStr.equals("R") || inputStr.equals("P") || inputStr.equals("S"))
    {
      return true;
    }
    return false;
  }

  
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
  }

  public String getComputerChoice()
  {
    return computerChoice;
  }

  public boolean playerWins()
  {
    return playerWins;
  }

  public boolean computerWins() 
  {
    return computerWins;
  }

  public boolean isTie()
  {
    if(playerWins==false && computerWins==false)
    {
    return true;
    }
    return false;
  }

  public String getScoreReportStr()
  {
    String report = "Total plays: "+rounds+"\nYour score: "+playerScore+", computer score: "+computerScore;

    return report;
  }

  private String getRandomChoice() 
  {
    int n = rand.nextInt(3);
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
  }

  private void resetRound()
  {
    computerChoice = "";
    playerWins=false;
    computerWins=false;
  }

}