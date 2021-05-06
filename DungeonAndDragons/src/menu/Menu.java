package menu;

//Imports
import characters.*;
import stuff.*;
import utils.Utils;
import java.util.Scanner;

public class Menu {

    Utils utl;
    Stuff weapon;
    Stuff spell;

    Stuff shield;
    Stuff filter;

    Stuff potion;

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
                        utl.print("Game over");
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
        utl.print( "      *** THIS IS ***" );
        utl.print( "*** Dungeons & Dragons ***" );
        utl.print( "       *** GAME ***" );

        //Name choice
        utl.print("---------NEW CHAR---------");
        utl.print( "Please, choose a  name : " );
        String playerName = entries.nextLine();

        //Starting game menu
        int playerClass = 0;

        while(playerClass != 1 && playerClass != 2) {

            //Class choice
            playerClass = utl.intQuestion("Please, choose a class : (1)Warrior (2)Sorcerer : ");

            switch (playerClass) {
                case 1:
                    playerChar = new Warrior(playerName, weapon = new Default(), shield = new Shield(), potion = new Default());
                    utl.print("Welcome warrior " + playerChar.getName() + ". Ready to go ?");
                    utl.print("Here's your stats : " + playerChar.getHealth() + " health points (HP) / " + playerChar.getMinAP() + " attack power(AP).");
                    break;
                case 2:
                    playerChar = new Sorcerer(playerName, spell = new Default(), filter = new Filter(), potion = new Default());
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

                if (weapon != null && isClass == "Warrior") {
                    utl.print("Weapon : " + getWeapon().getName());
                    utl.print("Weapon damage : " + getWeapon().getAmount());
                    utl.print("Shield defense : " + getShield().getAmount());
                } else if (getSpell() != null && isClass == "Sorcerer") {
                    utl.print("Spell : " + getSpell().getName());
                    utl.print("Spell damage : " + getSpell().getAmount());
                    utl.print("Filter defense : " + getFilter().getAmount());
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

    public int fightMenu() {
        int playerChoice = utl.intQuestion("(1) Attack (2) Run away");

        switch(playerChoice) {
            case 1:
                utl.print("Attacking");
                break;
            case 2:
                utl.print("You run away");
                break;
        }

        return playerChoice;
    }

    public int equipStuff(Stuff stuff) {
        int playerChoice = utl.intQuestion("(1) Equip (2) Don't equip");

        switch(playerChoice) {
            case 1:
                if(stuff.getName() == "Mace" || stuff.getName() == "Sword") {
                    setWeapon(stuff);
                }
                else if(stuff.getName() == "Tunderbolt" || stuff.getName() == "Fireball") {
                    setSpell(stuff);
                }
                break;
            case 2:
                break;
        }

        return playerChoice;
    }

    public Stuff getWeapon() {
        return weapon;
    }

    public void setWeapon(Stuff weapon) {
        this.weapon = weapon;
    }

    public Stuff getSpell() {
        return spell;
    }

    public void setSpell(Stuff spell) {
        this.spell = spell;
    }

    public Stuff getShield() {
        return shield;
    }

    public void setShield(Stuff shield) {
        this.shield = shield;
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