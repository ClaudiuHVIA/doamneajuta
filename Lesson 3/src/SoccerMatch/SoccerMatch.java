package SoccerMatch;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject {

	private String team0 = "Dream Team";
	private String team1 = "Old Boys";
	private int dreamTeamScore;
	private int oldBoysScore;
	private int dreamTeamTackle;
	private int oldBoysTackle;

	private PropertyChangeSupport support = new PropertyChangeSupport(this);

	public void startMatch() {
		System.out.println("Match starting \n\n");
		dreamTeamScore = 0;
		oldBoysScore = 0;
		Random random = new Random();
		for(int i = 0; i < 90; i++) {

			int rand = random.nextInt(100);
			int whichTeam = random.nextInt(2);

			if(rand < 8) {
				// score goal
				scoreGoal(whichTeam);
			} else if(rand < 12) {
				// penalty
				roughTackle(whichTeam);
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}
		System.out.println("\n\nDreamTeam "+dreamTeamScore+" - "+oldBoysScore+" OldBoys");

		if(dreamTeamScore>oldBoysScore)
		{
			System.out.println("\nDream Team WON!");
		} else if(dreamTeamScore == oldBoysScore)
		{
			System.out.println("\nIt's a DRAW!");
		}
		else {
			System.out.println("\nOld Boys WON!");
		}

		System.out.println("Dream Team tackles "+dreamTeamTackle+" - "+oldBoysTackle+" Old Boys tackles");

		System.out.println("\n\nMatch ended");
	}

	private void roughTackle(int whichTeam) {
		if(whichTeam == 0) {
			// TODO team0 made a rough tackle
			int dreamTeamPreviousTackle = dreamTeamTackle;
			dreamTeamTackle++;
			System.out.println("Dream Team made a rough tackle");
			support.firePropertyChange("Dream Team made a rough tackle", dreamTeamPreviousTackle, dreamTeamTackle);
		} else {
			// TODO team1 made a rough tackle
			int oldBoysPreviousTackle = oldBoysTackle;
			oldBoysTackle++;
			System.out.println("Old Boys made a rough tackle");
			support.firePropertyChange("Old Boys made a rough tackle", oldBoysPreviousTackle, oldBoysTackle);
		}
	}

	private void scoreGoal(int whichTeam) {
		if(whichTeam == 0) {
			// TODO team0 scored
			int dreamTeamPreviousScore = dreamTeamScore;
			dreamTeamScore++;
			System.out.println("Dream Team scored!");
			support.firePropertyChange("Dream Team scored", dreamTeamPreviousScore, dreamTeamScore);
		} else {
			// TODO team1 scored
			int oldBoysPreviousScore = oldBoysScore;
			oldBoysScore++;
			System.out.println("Old Boys scored!");
			support.firePropertyChange("Old Boys scored", oldBoysPreviousScore, oldBoysScore);
		}
	}

	@Override public void addPropertyChangeListener(String eventName,
			PropertyChangeListener listener)
	{
		support.addPropertyChangeListener(eventName, listener);
	}

	@Override public void addPropertyChangeListener(
			PropertyChangeListener listener)
	{
		support.addPropertyChangeListener(listener);
	}

	@Override public void removePropertyChangeListener(String eventName,
			PropertyChangeListener listener)
	{
		support.removePropertyChangeListener(eventName, listener);
	}

	@Override public void removePropertyChangeListener(
			PropertyChangeListener listener)
	{
		support.removePropertyChangeListener(listener);
	}
}
