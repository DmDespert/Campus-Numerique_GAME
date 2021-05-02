package game;

public class Dice {
	
	private int dice;
	
	public Dice() {
		
		this.dice = dice;
		
	}
	
	public void rollingDice() {
		
		int min = 1;
		int max = 6;
		int rand = min + (int)(Math.random() * ((max - min) + 1));
		
		dice = rand;
		
		System.out.println(dice);
		
	}
	
}