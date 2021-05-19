/**
 * Contain attributes & methods of all player class
 */
package characters;

import utils.Utils;

abstract public class Characters {

	private String name;
	private String classType;
	private int health;
	private int maxHealth;
	private int minAP;
	private int maxAP;
	private int charPosition = 1;

	private Utils utl;

	/**
	 * Constructors of Characters
	 * @param name
	 * @param classType
	 * @param health
	 * @param maxHealth
	 * @param minAP
	 * @param maxAP
	 */
	public Characters(String name, String classType, int health, int maxHealth, int minAP, int maxAP) {
		this.name = name;
		this.classType = classType;
		this.health = health;
		this.maxHealth = maxHealth;
		this.minAP = minAP;
		this.maxAP = maxAP;

		this.utl = new Utils();
	}

	/**
	 * Player char walk on map action, based on dice score
	 * @param dice
	 * @return
	 */
	public int walk(int dice) {
		this.charPosition = this.charPosition + dice;
		return charPosition;
	}

	/**
	 * Player char defense function
	 * @param dice
	 * @return
	 */
	public int defense(int dice) {
		int defenseAmount = 0;
		switch(dice) {
			case 6:
				defenseAmount = 4;
				break;
			case 5:
				defenseAmount = 3;
				break;
			case 4:
				defenseAmount = 2;
				break;
			default :
				defenseAmount = 0;
		}
		utl.print("\uD83C\uDFB2 Dice score for defense " + dice);
		utl.print("You defended your ass for " + defenseAmount + " damages");
		return defenseAmount;
	}

	/**
	 * Abstract method of attack, based on weapon
	 * @param weapon
	 * @return
	 */
	public abstract int attack(int weapon);

	public int getCharPosition() { return charPosition; }
	public void setCharPosition(int charPosition) { this.charPosition = charPosition; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getClassType() { return classType; }
	public void setClassType(String classType) { this.classType = classType; }
	public int getHealth() { return health; }
	public void setHealth(int health) { this.health = health; }
	public int getMaxHealth() { return maxHealth; }
	public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
	public int getMinAP() { return minAP; }
	public void setMinAP(int minAP) { this.minAP = minAP; }
	public int getMaxAP() { return maxAP; }
	public void setMaxAP(int maxAP) { this.maxAP = maxAP; }

}