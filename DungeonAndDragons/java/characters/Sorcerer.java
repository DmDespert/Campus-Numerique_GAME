package characters;

public class Sorcerer {
	
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
	
	public Sorcerer() {
		name = null;
		health = 3;
		minAP = 8;
	}
	
	public Sorcerer(String name, int health, int minAP) {
		name = this.name;
		health = this.health;
		minAP = this.minAP;
	}
	
}