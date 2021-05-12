/**
 * Contain attributes & methods of all player class
 */
package characters;

import utils.Utils;

abstract public class Characters {
	
	/**Char name**/
	private String name;
	
	/**Char Class**/
	private String classType;
	
	/**Char default HP**/
	private int health;
	
	/**Max char HP**/
	private int maxHealth;
	
	/**Char start attack power**/
	private int minAP;
	
	/**Char max attack power**/
	private int maxAP;

	private int charPosition = 1;

	Utils utl;

	/**Constructors of Characters**/
	public Characters(String name, String classType, int health, int maxHealth, int minAP, int maxAP) {
		this.name = name;
		this.classType = classType;
		this.health = health;
		this.maxHealth = maxHealth;
		this.minAP = minAP;
		this.maxAP = maxAP;

		this.utl = new Utils();
	}

	/**Commons functions**/

	/**Player char walk on map action, based on dice score**/
	public int walk(int dice) {
		this.charPosition = this.charPosition + dice;
		return charPosition;
	}

	/**Player char defense function**/
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
		utl.print("Dice score for defense " + dice);
		utl.print("You defended your ass for " + defenseAmount + " damages");
		return defenseAmount;
	}

	/**Abstract method of attack, based on weapon**/
	public abstract int attack(int weapon);

	/**Getters & Setters**/
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