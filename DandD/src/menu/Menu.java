package menu;

//Imports
import characters.*;
import stuff.*;
import utils.Utils;
import java.util.Scanner;

public class Menu {

    private Utils utl;

    //Constructor
    public Menu() {

        this.utl = new Utils();

    }

    //Commons functions
    public int startMenu() {

        //Starting game menu
        int playerChoice = 0;

        while (playerChoice != 1 && playerChoice != 2) {

            playerChoice = utl.intQuestion("(1) New Game (2) Exit game");

            switch (playerChoice) {

                case 1:
                    playerChoice = 1;
                    break;
                case 2:
                    if (utl.intQuestion("Are you sure ? (1) Yes (2) No") == 1) {
                        utl.print("---------------------------------------GAME OVER--------------------------------------");
                        System.exit(0);
                    } else {
                        break;
                    }
                default:
                    utl.print("Wimp");
                    break;

            }
        }
        return playerChoice;

    }

    public Characters createChar(Characters playerChar) {

        playerChar = null;

        //Globals
        Scanner entries = new Scanner( System.in );

        //Game Start
        utl.print( "*** This is the ***" );
        utl.print( "*** DUNGEONS & DRAGONS ***" );
        utl.print( "*** GAME ***" );

        //Name choice
        utl.print("-----------------------------------CREATE NEW CHAR----------------------------------");
        utl.print( "SELECT A NAME: " );
        String playerName = entries.nextLine();

        //Starting game menu
        int playerClass = 0;

        while(playerClass != 1 && playerClass != 2 && playerClass != 3) {

            //Class choice
            utl.print("SELECT A CLASS: ");
            playerClass = utl.intQuestion("(1) Warrior -- (2) Sorcerer");

            switch (playerClass) {
                case 1:
                    playerChar = new Warrior(playerName, new Default(), new Shield(), new Default());
                    utl.print("Welcome warrior " + playerChar.getName() + ". Ready to go ?");
                    utl.print("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
                    break;
                case 2:
                    playerChar = new Sorcerer(playerName, new Default(), new Filter(), new Default());
                    utl.print("Welcome sorcerer " + playerChar.getName() + ". Ready to go ?");
                    utl.print("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
                    break;
                default:
                    utl.print("Invalid class, you became a coconut.");
                    playerChar = new Coconut(playerName, new Default(), new CoconutSkin(), new Default());
                    playerClass = 3;
                    break;
            }

        }

        //Starting
        utl.print("Good luck, hero.");
        return playerChar;
    }

    public int runMenu(Characters playerChar) {

        int playerChoice = 0;

        String isName = playerChar.getName();
        String isClass = playerChar.getClassType();
        int isAP = playerChar.getMinAP();
        int isHP = playerChar.getHealth();

        switch (utl.intQuestion("(1) Go on -- (2) See char stats -- (3) Exit")) {
            case 1:
                playerChoice = 1;
                break;
            case 2:
                utl.print("Name : " + isName);
                utl.print("Class : " + isClass);
                utl.print("AP : " + isAP);
                utl.print("HP(s) : " + isHP);
                utl.print("Map position : " + playerChar.getCharPosition());

                if (playerChar != null && playerChar instanceof Warrior && ((Warrior) playerChar).getWeapon() != null) {
                    utl.print("Weapon : " + ((Warrior) playerChar).getWeapon().getName());
                    utl.print("Weapon damage : " + ((Warrior) playerChar).getWeapon().getAmount());
                    utl.print("Shield defense : " + ((Warrior) playerChar).getShield().getAmount());
                } else if (playerChar != null && playerChar instanceof Sorcerer && ((Sorcerer) playerChar).getSpell() != null) {
                    utl.print("Spell : " + ((Sorcerer) playerChar).getSpell().getName());
                    utl.print("Spell damage : " + ((Sorcerer) playerChar).getSpell().getAmount());
                    utl.print("Filter defense : " + ((Sorcerer) playerChar).getFilter().getAmount());
                } else {
                    utl.print("Coconut capacity: " + ((Coconut) playerChar).getCoconutWeapon().getName());
                    utl.print("Coconut friends : " + ((Coconut) playerChar).getCoconutWeapon().getAmount());
                    utl.print("Coconut defense : " + ((Coconut) playerChar).getCoconutSkin().getAmount());
                }

                break;
            case 3:
                if (utl.intQuestion("Are you sure ? (1) Yes (2) No") == 1) {
                    playerChoice = 2;
                    break;
                } else {
                    break;
                }
        }

        return playerChoice;

    }
}