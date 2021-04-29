package menu;

//Import chars
import characters.Characters;
import characters.Sorcerer;
import characters.Warrior;

//Import Enemies
import enemies.Enemies;
import enemies.Goblins;
import enemies.Sorcerers;
import enemies.Dragons;

//Import scanner
import java.util.Scanner;


public class NewGame {
	
	Characters playerChar;
	
	public NewGame() {
		
		//Globals
		Scanner entries = new Scanner( System.in );
		
		//Game Start
		System.out.println( "*** Dungeons & Dragons ***" );
	        
		//Name choice
        System.out.println( "Please, choose a  name : " );
        String playerName = entries.nextLine();
        
        //Class choice
        System.out.println( "Please, choose a class : (1)Warrior (2)Sorcerer : " );
        int playerClass = entries.nextInt();

        switch(playerClass) {
        	case 1:
            	this.playerChar = new Warrior(playerName);
            	System.out.println("Welcome warrior " + playerChar.getName() + ". Ready to go ?");
            	System.out.println("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
            	break;
        	case 2:
        		this.playerChar = new Sorcerer(playerName);
            	System.out.println("Welcome sorcerer " + playerChar.getName() + ". Ready to go ?");
            	System.out.println("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
            	break;
            default :
            	System.out.println("Invalid class");
        }

        //Starting
        System.out.println("Good luck, hero.");
	
	}
	
}