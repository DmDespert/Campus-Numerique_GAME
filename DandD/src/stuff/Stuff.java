package stuff;

import characters.Characters;
import characters.Coconut;
import characters.Sorcerer;
import characters.Warrior;
import map.Slot;
import utils.Utils;
import game.Game;

abstract public class Stuff extends Slot {
	
	private String name;
	private int amount;

	private Utils utl;
	
	public Stuff(String name, int amount) {
		this.name = name;
		this.amount = amount;
		this.utl = new Utils();
	}

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

	//Stuff drop events
	public void action(Characters playerChar) {
		utl.print("You found " + this.getName());
		stuffEvent(playerChar);
	}

	public void stuffEvent(Characters playerChar) {

		utl.print("Provided : " + getAmount());
		if(equipStuff(playerChar) == 1 && getName() == "Small life potion" || getName() == "Great life potion") {
			playerChar.setHealth(playerChar.getHealth() + getAmount());
			if(playerChar.getHealth() > playerChar.getMaxHealth()) {
				playerChar.setHealth(playerChar.getMaxHealth());
			}
		}

	}

	public int equipStuff(Characters playerChar) {
		int playerChoice = utl.intQuestion("(1) Equip (2) Don't equip");

		switch(playerChoice) {
			case 1:
				if(getName() == "Mace" || getName() == "Sword") {
					((Warrior) playerChar).setWeapon(this);
				}
				else if(getName() == "Tunderbolt" || getName() == "Fireball") {
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
}
