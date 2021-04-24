package projectV1;

public class Player {

	int playerNr;

	String diceValueStr;
	String roundPointsStr;
	String totalPointsStr;

	int labelCount;
	int panelCount;

	int transmittedPanelCount;

	int roundPoints = 0;
	int totalPoints = 0;

	boolean playerEnd = false;

	public Player(int tempPlayerNr) {
		if (tempPlayerNr == 1) {
			panelCount = 0;
		} else if (tempPlayerNr == 2) {
			panelCount = 6;
		}
		playerNr = tempPlayerNr;
	}

	public void even(int tempLabelCount, int diceValue) {
		labelCount = tempLabelCount;

		roundPoints = roundPoints + diceValue;
		totalPoints = totalPoints + diceValue;

		// alle Werte zu Strings machen
		diceValueStr = Integer.toString(diceValue);
		roundPointsStr = Integer.toString(roundPoints);
		totalPointsStr = Integer.toString(totalPoints);
		transmittedPanelCount = panelCount;
		if (labelCount == 5) {
			panelCount++;
			roundPoints = 0;
		}
		endCheck();
		System.out.println("even Dice Value: " + diceValue);
	}

	public void uneven(int getLabelCount, int diceValue) {

		labelCount = getLabelCount;
		totalPoints = totalPoints - roundPoints;
		roundPoints = 0;
		// alle Werte zu Strings machen
		diceValueStr = Integer.toString(diceValue);
		roundPointsStr = Integer.toString(roundPoints);
		totalPointsStr = Integer.toString(totalPoints);
		transmittedPanelCount = panelCount;
		panelCount++;
		endCheck();
		System.out.println("uneven Dice Value: " + diceValue);
	}

	public void savePoints() {
		panelCount++;
		roundPoints = 0;
		endCheck();
	}

	public void endCheck() {
		if (playerNr == 1) {
			if (panelCount > 5) {
				playerEnd = true;
			}
		} else if (playerNr == 2) {
			if (panelCount > 11) {
				playerEnd = true;
			}
		}
	}

	public void reset(int tempPlayerNr) {
		if (tempPlayerNr == 1) {
			panelCount = 0;
		} else if (tempPlayerNr == 2) {
			panelCount = 6;
		}
		playerNr = tempPlayerNr;
		playerEnd = false;
		totalPoints = 0;
	}
}
