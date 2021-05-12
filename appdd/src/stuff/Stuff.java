/**
 * All related to stuffs (weapons, defenses items, potions...)
 */
package stuff;

//Imports in Stuff
import characters.Characters;
import characters.Coconut;
import characters.Sorcerer;
import characters.Warrior;
import map.Slot;
import utils.Utils;

/**Abstract class for all stuffs**/
abstract public class Stuff extends Slot {

	/**Attributes of Stuff**/
	private String name;
	private int amount;

	private Utils utl;

	/**Constructors of Stuff**/
	public Stuff(String name, int amount) {
		this.name = name;
		this.amount = amount;
		this.utl = new Utils();
	}

	/**Commons functions of Stuff**/

	/**Catch the stuff slot to interact & launch stuffEvent()**/
	public void action(Characters playerChar) {
		utl.print("You found " + this.getName());
		stuffEvent(playerChar);
	}

	/**On slot stuff interaction - call the method to let the player choose to equip or not.**/
	public void stuffEvent(Characters playerChar) {
		utl.print("Provided : " + getAmount());
		if(equipStuff(playerChar) == 1 && getName() == "\uD83D\uDD3A Small life potion" || getName() == "\uD83D\uDD34 Great life potion") {
			playerChar.setHealth(playerChar.getHealth() + getAmount());
			if(playerChar.getHealth() > playerChar.getMaxHealth()) {
				playerChar.setHealth(playerChar.getMaxHealth());
			}
		}

	}

	/**Method to equip or not the stuff.**/
	public int equipStuff(Characters playerChar) {
		int playerChoice = utl.intQuestion("(1) Equip (2) Don't equip");

		switch(playerChoice) {
			case 1:
				if(getName() == "\uD83D\uDD28 Mace" || getName() == "\uD83D\uDDE1\uFE0F Sword") {
					((Warrior) playerChar).setWeapon(this);
				}
				else if(getName() == "\u26A1 Tunderbolt" || getName() == "\uD83D\uDD25 Fireball") {
					((Sorcerer) playerChar).setSpell(this);
				}
				else if (getName() == "Coconuts invasion") {
					((Coconut) playerChar).setCoconutWeapon(this);
				}
				break;
			case 2:
				break;
		}

		return playerChoice;
	}

	/**Getters & Setters**/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
