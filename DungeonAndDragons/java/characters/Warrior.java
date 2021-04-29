package characters;

public class Warrior {
	
	//Char name
	private String name;
	
	//Char default HP
	private int health;
	
	//Max char HP (6)
	private int maxHealth;
	
	//Char min attack power (8)
	private int minAP;
	
	//Char max attack power (15)
	private int maxAP;
	
	public Warrior() {
		name = null;
		health = 5;
		minAP = 5;
	}
	
	public Warrior(String name, int health, int minAP) {
		name = this.name;
		health = this.health;
		minAP = this.minAP;
	}
	
	public String toString() {
		return name;
	}
	
}