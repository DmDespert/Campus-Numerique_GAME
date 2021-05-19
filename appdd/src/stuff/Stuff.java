/**
 * All related to stuffs (weapons, defenses items, potions...)
 */
package stuff;

import characters.*;
import map.Slot;
import utils.Utils;

/**
 * Abstract class for all stuffs
 */
abstract public class Stuff extends Slot {

	private String weaponName;
	private int weaponAmount;

	private Utils utl;

	/**
	 * Constructors of Stuff
	 * @param name
	 * @param amount
	 */
	public Stuff(String name, int amount) {
		this.weaponName = name;
		this.weaponAmount = amount;
		this.utl = new Utils();
	}

	/**
	 * Catch the stuff slot to interact & launch stuffEvent()
	 * @param playerChar
	 */
	public void action(Characters playerChar) {
		utl.print("You found " + this.getWeaponName());
		stuffEvent(playerChar);
	}

	/**
	 * On slot stuff interaction - call the method to let the player choose to equip or not.
	 * @param playerChar
	 */
	public void stuffEvent(Characters playerChar) {
		utl.print("\u2B06\uFE0F Provided : " + getWeaponAmount());
		if(equipStuff(playerChar) == 1 && getWeaponName() == "\uD83D\uDD3A Small life potion" || getWeaponName() == "\uD83D\uDD34 Great life potion") {
			playerChar.setHealth(playerChar.getHealth() + getWeaponAmount());
			if(playerChar.getHealth() > playerChar.getMaxHealth()) {
				playerChar.setHealth(playerChar.getMaxHealth());
			}
		}

	}

	/**
	 * Method to equip or not the stuff.
	 * @param playerChar
	 * @return
	 */
	public int equipStuff(Characters playerChar) {
		int playerChoice = utl.intQuestion("(1) Equip (2) Don't equip");

		switch(playerChoice) {
			case 1:
				if(getWeaponName() == "Mace" || getWeaponName() == "Sword") {
					((Warrior) playerChar).setWeapon(this);
				}
				else if(getWeaponName() == "Tunderbolt" || getWeaponName() == "Fireball") {
					((Sorcerer) playerChar).setSpell(this);
				}
				else if (getWeaponName() == "Coconuts invasion") {
					((Coconut) playerChar).setCoconutWeapon(this);
				}
				break;
			case 2:
				break;
		}

		return playerChoice;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getWeaponAmount() {
		return weaponAmount;
	}

	public void setWeaponAmount(int weaponAmount) {
		this.weaponAmount = weaponAmount;
	}
}
