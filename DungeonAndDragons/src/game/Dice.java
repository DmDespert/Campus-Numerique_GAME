package game;

public class Dice {
	
	private int dice;
	
	public Dice() {
		
		this.dice = dice;
		
	}
	
	public int rollingDice() {
		
		int min = 1;
		int max = 6;
		int rand = min + (int)(Math.random() * ((max - min) + 1));
		
		dice = rand;
		return dice;
		
	}

	public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}
}