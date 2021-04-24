package projectV1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DiceGUI extends JFrame implements ActionListener {

	private JButton buttonStart = new JButton("START GAME");
	private JTextField player1Name = new JTextField();
	private JTextField player2Name = new JTextField();
	private JLabel p1NameLabel = new JLabel();
	private JLabel p2NameLabel = new JLabel();
	RoundPanel panelArray[] = new RoundPanel[12];
	private JButton buttonDice = new JButton("WÜRFELN");
	private JButton buttonSave = new JButton("PUNKTE SICHERN");
	private JLabel messageLabel = new JLabel();
	private JLabel moveIndicatorP1 = new JLabel();
	private JLabel moveIndicatorP2 = new JLabel();
	Game game1 = new Game();
	boolean firstEnd = true;

	public DiceGUI() {
		setLayout(null);
		player1Name.setBounds(20, 20, 100, 25);
		player2Name.setBounds(140, 20, 100, 25);
		buttonStart.setBounds(270, 20, 120, 25);
		add(player1Name);
		add(player2Name);
		add(buttonStart);
		buttonStart.addActionListener(this);
		p1NameLabel.setBounds(100, 50, 100, 25);
		p2NameLabel.setBounds(330, 50, 100, 25);
		add(p1NameLabel);
		add(p2NameLabel);
		messageLabel.setBounds(130, 385, 300, 25);
		add(messageLabel);
		for (int i = 0; i < panelArray.length; i++) {
			panelArray[i] = new RoundPanel();
		}
		int y = 80;
		for (int j = 0; j < panelArray.length / 2; j++) {
			panelArray[j].setBounds(15, y, 220, 50);
			add(panelArray[j]);
			y = y + 50;
		}
		y = 80;
		for (int w = panelArray.length / 2; w < panelArray.length; w++) {
			panelArray[w].setBounds(245, y, 220, 50);
			add(panelArray[w]);
			y = y + 50;
		}
		moveIndicatorP1.setBounds(15, 380, 220, 7);
		moveIndicatorP1.setBackground(Color.GREEN);
		add(moveIndicatorP1);
		moveIndicatorP2.setBounds(245, 380, 220, 7);
		moveIndicatorP2.setBackground(Color.GREEN);
		add(moveIndicatorP2);
		moveIndicatorP1.setOpaque(true);
		moveIndicatorP2.setOpaque(true);
		moveIndicatorP1.setVisible(false);
		moveIndicatorP2.setVisible(false);
		buttonDice.setBounds(50, 430, 150, 25);
		buttonSave.setBounds(270, 430, 150, 25);
		add(buttonDice);
		add(buttonSave);
		buttonDice.addActionListener(this);
		buttonSave.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 600);
		setTitle("Dice Game");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonStart) {
			for (int i = 0; i < panelArray.length; i++) {
				for (int j = 0; j <= 7; j++) {
					panelArray[i].setValue(j, "0");
				}
				messageLabel.setText(null);
				p1NameLabel.setText(player1Name.getText());
				p2NameLabel.setText(player2Name.getText());

			}
			game1.reset();
			moveIndicatorP1.setVisible(true);
			moveIndicatorP2.setVisible(false);
			firstEnd = true;

		} else if (e.getSource() == buttonDice) {
			Player p = game1.rollDice();
			panelArray[p.transmittedPanelCount].setValue(p.labelCount, p.diceValueStr);
			panelArray[p.transmittedPanelCount].setValue(6, p.roundPointsStr);
			panelArray[p.transmittedPanelCount].setValue(7, p.totalPointsStr);
			System.out.println("playerNr: " + p.playerNr + " transmittedPanelCount: " + p.transmittedPanelCount
					+ " labelCount: " + p.labelCount + " diceValue: " + p.diceValueStr + " playerEnd: " + p.playerEnd
					+ " gameEnd: " + game1.gameEnd + " roundPoints: " + p.roundPointsStr + " totalPoints: "
					+ p.totalPointsStr + " firstEnd: " + firstEnd);
			if (game1.gameEnd == true) {
				if (game1.winner == 3) {
					messageLabel.setText("Das Spiel ist vorbei. Es steht unentschieden.");
				} else if (game1.winner == 1) {
					messageLabel.setText("Das Spiel ist vorbei. " + p1NameLabel.getText() + " hat gewonnen.");
				} else if (game1.winner == 2) {
					messageLabel.setText("Das Spiel ist vorbei. " + p2NameLabel.getText() + " hat gewonnen.");
				}
			}

			if (p.playerNr == 1) {
				if (game1.aPlayerFinished() == false) {
					moveIndicatorP2.setVisible(true);
					moveIndicatorP1.setVisible(false);
				} else if (firstEnd == true) {
					firstEnd = false;
					moveIndicatorP2.setVisible(true);
					moveIndicatorP1.setVisible(false);
				}
			} else {
				if (game1.aPlayerFinished() == false) {
					moveIndicatorP1.setVisible(true);
					moveIndicatorP2.setVisible(false);
				} else if (firstEnd == true) {
					firstEnd = false;
					moveIndicatorP1.setVisible(true);
					moveIndicatorP2.setVisible(false);
				}
			}

		} else if (e.getSource() == buttonSave) {
			Player p = game1.savePoints();
			if (game1.gameEnd == true) {
				if (game1.winner == 3) {
					messageLabel.setText("Das Spiel ist vorbei. Es steht unentschieden.");
				} else if (game1.winner == 1) {
					messageLabel.setText("Das Spiel ist vorbei. " + p1NameLabel.getText() + " hat gewonnen.");
				} else if (game1.winner == 2) {
					messageLabel.setText("Das Spiel ist vorbei. " + p2NameLabel.getText() + " hat gewonnen.");
				}

			}

			if (p.playerNr == 1) {
				if (game1.aPlayerFinished() == false) {
					moveIndicatorP2.setVisible(true);
					moveIndicatorP1.setVisible(false);
				} else if (firstEnd == true) {
					firstEnd = false;
					moveIndicatorP2.setVisible(true);
					moveIndicatorP1.setVisible(false);
				}
			} else {
				if (game1.aPlayerFinished() == false) {
					moveIndicatorP1.setVisible(true);
					moveIndicatorP2.setVisible(false);
				} else if (firstEnd == true) {
					firstEnd = false;
					moveIndicatorP1.setVisible(true);
					moveIndicatorP2.setVisible(false);
				}
			}

		}
	}

}
