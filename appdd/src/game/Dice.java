package game;

/**
 * Dice class used in game to generate a dice, random result return of min & max.
 */
public class Dice {

	private int dice;

	public Dice() {
		
		this.dice = dice;
		
	}

	/**
	 * Random dice score return function (int)
	 * @return
	 */
	public int rollingDice() {

		//Change min & max to review the dice scores.
		int min = 1;
		int max = 6;
		int rand = min + (int)(Math.random() * ((max - min) + 1));
		
		dice = rand;
		return dice;
		
	}

	public int getDice() { return dice; }
	public void setDice(int dice) { this.dice = dice; }

}