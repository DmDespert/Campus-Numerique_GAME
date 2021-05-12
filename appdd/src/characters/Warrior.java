package characters;
import stuff.Stuff;

/**Warrior characters class**/
public class Warrior extends Characters {

	Stuff weapon;
	Stuff shield;
	Stuff potion;
	
	/**Constructor**/
	public Warrior(String name, Stuff weapon, Stuff shield, Stuff potion) {
		super(name, "Warrior", 5, 14, 5, 10);
		this.weapon = weapon;
		this.shield = shield;
		this.potion = potion;
	}

	/**Commons & Overrides**/

	@Override
	/**Specific class attack**/
	public int attack(int weapon) {
		int attackAmount = weapon + getMinAP();
		return attackAmount;
	}

	/**Getters & Setters**/
	public Stuff getWeapon() { return weapon; }
	public void setWeapon(Stuff weapon) { this.weapon = weapon; }
	public Stuff getShield() { return shield; }
	public void setShield(Stuff shield) { this.shield = shield; }
	public Stuff getPotion() { return potion; }
	public void setPotion(Stuff potion) { this.potion = potion; }

}