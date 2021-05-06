package menu;

//Import chars
import characters.Characters;
import characters.Sorcerer;
import characters.Warrior;
import stuff.Stuff;
import stuff.Default;
import utils.Utils;

//Import scanner
import java.util.Scanner;

public class MenuChar {
	
	//Attributes
	private Characters playerChar;
	private Stuff weapon;
	private Stuff shield;

	private Stuff spell;
	private Stuff filter;

	private Stuff potion;

	Utils utl;
	
	//Constructor
	public MenuChar() {
		
		this.playerChar = null;
		this.weapon = new Default();
		this.shield = new Default();
		this.spell = new Default();
		this.filter = new Default();
		this.potion = new Default();
		this.utl = new Utils();
	
	}
	
	//Commons functions
	public void start() {
		
		//Globals
		Scanner entries = new Scanner( System.in );
		
		//Game Start
		utl.print( "*** Dungeons & Dragons ***" );
	        
		//Name choice
        utl.print( "Please, choose a  name : " );
        String playerName = entries.nextLine();

		//Starting game menu
		int playerClass = 0;

		while(playerClass != 1 && playerClass != 2) {

			//Class choice
			playerClass = utl.intQuestion("Please, choose a class : (1)Warrior (2)Sorcerer : ");

			switch (playerClass) {
				case 1:
					this.playerChar = new Warrior(playerName, weapon, shield, potion);
					utl.print("Welcome warrior " + playerChar.getName() + ". Ready to go ?");
					utl.print("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
					break;
				case 2:
					this.playerChar = new Sorcerer(playerName, spell, filter, potion);
					utl.print("Welcome sorcerer " + playerChar.getName() + ". Ready to go ?");
					utl.print("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
					break;
				default:
					utl.print("Invalid class, you became a coconut.");
					break;
			}

		}

        //Starting
        utl.print("Good luck, hero.");
	}

	public Characters getPlayerChar() {
		return playerChar;
	}

	public void setPlayerChar(Characters playerChar) {
		this.playerChar = playerChar;
	}

	public Stuff getWeapon() {
		return weapon;
	}

	public void setWeapon(Stuff weapon) {
		this.weapon = weapon;
	}

	public Stuff getShield() {
		return shield;
	}

	public void setShield(Stuff shield) {
		this.shield = shield;
	}

	public Stuff getSpell() {
		return spell;
	}

	public void setSpell(Stuff spell) {
		this.spell = spell;
	}

	public Stuff getFilter() {
		return filter;
	}

	public void setFilter(Stuff filter) {
		this.filter = filter;
	}

	public Stuff getPotion() {
		return potion;
	}

	public void setPotion(Stuff potion) {
		this.potion = potion;
	}
}