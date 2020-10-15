package SoccerMatch;

public class StartSoccerMatch
{
  public static void main(String[] args)
  {
    SoccerMatch soccerMatch = new SoccerMatch();
    DreamTeamFans dtf = new DreamTeamFans();
    OldBoysFans obf = new OldBoysFans();
    Referee referee = new Referee();
    soccerMatch.addPropertyChangeListener(dtf);
    soccerMatch.addPropertyChangeListener(obf);
    soccerMatch.addPropertyChangeListener(referee);
    soccerMatch.startMatch();
  }
}
