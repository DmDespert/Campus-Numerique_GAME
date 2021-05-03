package menu;

//Import chars
import characters.Characters;
import characters.Sorcerer;
import characters.Warrior;
import stuff.Stuff;

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
	
	//Constructor
	public MenuChar() {
		
		this.playerChar = null;
		this.weapon = null;
		this.shield = null;
		this.spell = null;
		this.filter = null;
		this.potion = null;
	
	}
	
	//Commons functions
	public void start() {
		
		//Globals
		Scanner entries = new Scanner( System.in );
		
		//Game Start
		System.out.println( "*** Dungeons & Dragons ***" );
	        
		//Name choice
        System.out.println( "Please, choose a  name : " );
        String playerName = entries.nextLine();

		//Starting game menu
		int playerClass = 0;

		while(playerClass != 1 && playerClass != 2) {

			//Class choice
			System.out.println( "Please, choose a class : (1)Warrior (2)Sorcerer : " );
			playerClass = entries.nextInt();
			entries.nextLine();

			switch (playerClass) {
				case 1:
					this.playerChar = new Warrior(playerName, weapon, shield, potion);
					this.weapon = null;
					this.shield = null;
					this.potion = null;
					System.out.println("Welcome warrior " + playerChar.getName() + ". Ready to go ?");
					System.out.println("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
					break;
				case 2:
					this.playerChar = new Sorcerer(playerName, spell, filter, potion);
					this.spell = null;
					this.filter = null;
					this.potion = null;
					System.out.println("Welcome sorcerer " + playerChar.getName() + ". Ready to go ?");
					System.out.println("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
					break;
				default:
					System.out.println("Invalid class");
					break;
			}

		}

        //Starting
        System.out.println("Good luck, hero.");
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