# DiceGame
## German
![UML](https://github.com/herzkadani/DiceGame/blob/d1979b779647626061514c1bce4eeb0b7eea6ab4/UML.png)
### Funktionsbechreibung
2 Spieler, welche ihren Namen selber eingeben können müssen in 6 Runden möglichst viele Punkte durch das Würfeln eines digitalen Würfels erzielen. Pro Runde darf jeder Spieler maximal 5 Mal würfeln. Sobald ein Spieler jedoch eine ungerade Zahl würfelt verliert er alle Punkte der Runde. Nach jedem mal würfeln wird der Spieler gewechselt. Es besteht die Möglichkeit die Runde vorzeitig abzubrechen um die bereits erzielten Punkte zu sichern. Der Spieler, welche die meisten Punkte nach 6 Runden erzielt gewinnt das Spiel.
Das Spiel kann mehrmals hintereinander gespielt werden. Um das Spiel neu zu starten genügt die erneute Betätigung des “START GAME" Knopfs. 
### Klassenbeschreibung
#### Starter
Die Starter-Klasse dient dem Starten der Applikation. Sie ist die einzige Klasse, welche eine static Methode enthält. In der Starter-Klasse wird ein Objekt der DiceGUI-Klasse erstellt.
#### DiceGUI
Die Aufgabe der DiceGUI-Klasse ist die Bereitstellung der grafischen Benutzeroberfläche (GUI). Das DiceGUI greift zur grafischen Darstellung der Spielrunden auf eine weitere Klasse, die RoundPanel-Klasse, zurück. Das GUI zeigt mithilfe eines grünen Balkens an, welcher Spieler aktuell am Zug ist. Mithilfe der actionPerformed-Methode werden die Methoden der Hauptfachklasse “Game” aufgerufen. 
#### RoundPanel
In der RoundPanel-Klasse wird jeweils eine Spielrunde abgebildet. Mithilfe der setValue-Methode können die Werte der JLabels innerhalb des RoundPanels verändert werden.
#### Game
Die Game-Klasse ist die Hauptfachklasse der Applikation. In der Methode rollDice wird mithilfe eines Zufallsgenerators “der Würfel gewürfelt”. Mit der Methode savePoints wird die aktuelle Runde des aktuellen Spielers vorzeitig beendet. In der Game Klasse wird erfasst auf dem wievielten Label der aktuellen Runde gewürfelt wird. Ausserdem wird erfasst welcher Spieler momentan an der Reihe ist.
Alle Werte, welche das GUI zur Darstellung des Spielverlaufs benötigt, werden in einem Objekt der Klasse Player hinterlegt. Das Player-Objekt wird als Rückgabewert der Methoden rollDice und savePoints an das GUI zurückgegeben. Die Game-Klasse ermittelt auch, ob ein Spieler bereits alle Züge gespielt hat. In diesem Fall wird der Spieler nicht mehr nach jedem Zug gewechselt. Wenn beide Spieler fertig sind erhält das GUI die Information, wer das Spiel gewonnen hat. Es besteht die Möglichkeit über eine Methode alle Werte in den Anfangszustand zu versetzen.
#### Player
Die Player-Klasse dient hauptsächlich als “Behälter” mit dem alle Werte, welches das GUI zur Darstellung des Spielverlaufs benötigt, an das GUI übermittelt werden können. Die Werte können mit der Methode setValues in diesem “Behälter” gespeichert werden.
Des Weiteren werden in der Player-Klasse die Zwischen- und Gesamtpunkte jedes Spielers. Die Information in welcher Runde sich der jeweilige Spieler befindet wird ebenfalls in der Player-Klasse verwaltet. Es besteht die Möglichkeit über eine Methode alle Werte in den Anfangszustand zu versetzen.
## English
### Functional description
2 players, who can enter their name themselves, must score as many points as possible in 6 rounds by rolling a digital dice. Each player may roll the dice a maximum of 5 times per round. However, as soon as a player rolls an odd number, he loses all points of the round. After each roll of the dice, the player is changed. It is possible to stop the round early to save the points already scored. The player who scores the most points after 6 rounds wins the game.
The game can be played several times in a row. To restart the game, just press the "START GAME" button again. 
### Class description
#### Starter
The Starter class is used to start the application. It is the only class that contains a static method. In the Starter class an object of the DiceGUI class is created.
#### DiceGUI
The task of the DiceGUI class is to provide the graphical user interface (GUI). The DiceGUI uses another class, the RoundPanel class, for the graphical representation of the game rounds. The GUI uses a green bar to indicate which player's turn it is. The actionPerformed method is used to call the methods of the main "Game" class. 
#### RoundPanel
The RoundPanel class represents one game round at a time. The setValue method can be used to change the values of the JLabels within the RoundPanel.
#### Game
The Game class is the main logic class of the application. In the rollDice method, a random number generator is used to "roll the dice". With the method savePoints the current round of the current player is ended prematurely. In the Game class the number of the current round is recorded. It also records which player's turn it is at the moment.
All values, which the GUI needs for the representation of the play process, are deposited in an object of the class Player. The Player object is returned to the GUI as the return value of the rollDice and savePoints methods. The Game class also determines whether a player has already played all moves. In this case, the player is no longer changed after each move. When both players are finished the GUI gets the information who has won the game. It is possible to set all values to the initial state via a method.
#### Player
The player class serves mainly as a "container" with which all values, which the GUI needs for the representation of the game process, can be transmitted to the GUI. The values can be stored in this "container" with the method setValues.
Furthermore the intermediate and total points of each player are stored in the player class. The information in which round the respective player is is also managed in the player class. It is possible to set all values to the initial state via a method.
