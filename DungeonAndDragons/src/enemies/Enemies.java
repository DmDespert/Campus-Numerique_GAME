package enemies;

import map.Slot;

public class Enemies extends Slot {
	
	//Enemy name
	private String name;
	
	//Enemy default HP
	private int health;
	
	//Enemy AP
	private int enemyAP;
	
	//Constructor
	public Enemies(String name, int health, int enemyAP) {
		this.name = name;
		this.health = health;
		this.enemyAP = enemyAP;
	}

	//Setters & Getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getEnemyAP() {
		return enemyAP;
	}

	public void setEnemyAP(int enemyAP) {
		this.enemyAP = enemyAP;
	}

}