package projectV1;

public class Game {
	int labelCountP1 = 1;
	int labelCountP2 = 1;
	int switcher;
	Player player1 = new Player(1);
	Player player2 = new Player(2);
	boolean gameEnd = false;
	int winner;

	public Game() {
		switcher = 1;
	}

	public Player rollDice() {
		int diceValue = (int) (Math.random() * 6) + 1; // Zahl würfeln
		if (switcher == 1) { // Wenn Spieler 1 an der Reihe ist

			if (diceValue % 2 == 0) { // schauen ob gewürfelte Zahl gerade ist
				player1.even(labelCountP1, diceValue);
				labelCountP1++;
				if (labelCountP1 > 5) {
					labelCountP1 = 1;
				}
			} else {
				player1.uneven(labelCountP1, diceValue);
				labelCountP1 = 1;
			}
			if (player2.playerEnd == false) {
				switcher = 2;// Spieler wechseln
			}
			endCheck();
			return player1;
		} else {// Wenn Spieler 2 an der Reihe ist

			if (diceValue % 2 == 0) { // schauen ob gewürfelte Zahl gerade ist
				player2.even(labelCountP2, diceValue);
				labelCountP2++;
				if (labelCountP2 > 5) {
					labelCountP2 = 1;
				}
			} else {
				player2.uneven(labelCountP2, diceValue);
				labelCountP2 = 1;
			}
			if (player1.playerEnd == false) {
				switcher = 1;// Spieler wechseln
			}
			endCheck();
			return player2;
		}
	}

	public Player savePoints() {
		if (switcher == 1) { // Wenn Spieler 1 an der Reihe ist
			labelCountP1 = 1;
			player1.savePoints();
			if (player2.playerEnd == false) {
				switcher = 2;// Spieler wechseln
			}
			endCheck();
			return player1;
		} else {// Wenn Spieler 2 an der Reihe ist
			labelCountP2 = 1;
			player2.savePoints();
			if (player1.playerEnd == false) {
				switcher = 1;// Spieler wechseln
			}
			endCheck();
			return player2;
		}
	}

	public void endCheck() {
		if (player1.playerEnd == true && player2.playerEnd == true) {
			gameEnd = true;
			if (player1.totalPoints == player2.totalPoints) {
				winner = 3;
			} else if (player1.totalPoints > player2.totalPoints) {
				winner = 1;
			} else if (player2.totalPoints > player1.totalPoints) {
				winner = 2;
			}
		}
	}

	public void reset() {
		labelCountP1 = 1;
		labelCountP2 = 1;
		gameEnd = false;
		switcher = 1;
		player1.reset(1);
		player2.reset(2);
	}

	public boolean aPlayerFinished() {
		boolean aPlayerFinished = false;
		if (player1.playerEnd == true) {
			aPlayerFinished = true;
		} else if (player2.playerEnd == true) {
			aPlayerFinished = true;
		}

		return aPlayerFinished;

	}
}
