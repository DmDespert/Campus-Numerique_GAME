/**
 * All related to player interaction (start menu, exit, char creation, etc...)
 */
package menu;

import characters.*;
import stuff.*;
import utils.Utils;

import java.util.Scanner;

/**
 * Contain all interaction function with the player
 */
public class Menu {

    private Utils utl;

    public Menu() {
        this.utl = new Utils();
    }

    /**
     * New game or exit game menu
     * @return
     */
    public int startMenu() {

        //Starting game menu
        int playerChoice = 0;

        while (playerChoice != 1 && playerChoice != 2 && playerChoice != 3) {

            playerChoice = utl.intQuestion("===========================================\n" +
                    "(1) New Game\n" +
                    "(2) Load game\n" +
                    "(3) Exit game\n" +
                    "===========================================");

            switch (playerChoice) {

                case 1:
                    playerChoice = 1;
                    break;
                case 2:
                    playerChoice = 2;
                    break;
                case 3:
                    if (utl.intQuestion("===========================================\n" +
                            "Are you sure ?\n" +
                            "(1) Yes\n" +
                            "(2) No\n" +
                            "===========================================") == 1) {
                        utl.print("-------------------------------------------\n" +
                                ">> GAME OVER\n" +
                                "-------------------------------------------");
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

    /**
     * Create char menu
     * @param playerChar
     * @return
     */
    public Characters createChar(Characters playerChar) {

        playerChar = null;

        //Globals
        Scanner entries = new Scanner(System.in);

        //Game Start
        utl.print("\uD83D\uDCAC Make the good choice, hero.");

        //Name choice
        utl.print("-------------------------------------------\n" +
                ">> CREATE NEW CHAR\n" +
                "-------------------------------------------\n" +
                "ENTER YOUR NAME: ");
        String playerName = entries.nextLine();

        //Starting game menu
        int playerClass = 0;

        while (playerClass != 1 && playerClass != 2 && playerClass != 3) {

            //Class choice
            utl.print("SELECT A CLASS: ");
            playerClass = utl.intQuestion("===========================================\n" +
                    "(1) Warrior - Strength = 5 / Health = 5\n" +
                    "(2) Sorcerer - Magic power = 8 / Health = 3\n" +
                    "===========================================");

            switch (playerClass) {
                case 1:
                    playerChar = new Warrior(playerName, new Default(), new Shield(), new Default());
                    break;
                case 2:
                    playerChar = new Sorcerer(playerName, new Default(), new Filter(), new Default());
                    break;
                default:
                    utl.print("Invalid class, you became a coconut.");
                    playerChar = new Coconut(playerName, new Default(), new CoconutSkin(), new Default());
                    playerClass = 3;
                    break;
            }
            utl.print("\uD83D\uDCAC Welcome " + playerChar.getClassType() + " " + playerChar.getName() + ". Ready to go ?" + "\n" +
                    "Here's your stats : " + playerChar.getHealth() + " health points (HP) / " +
                    playerChar.getMinAP() + " attack power(AP).");

        }

        //Starting
        utl.print("\uD83D\uDCAC Good luck, " + playerChar.getClassType() + ".");
        return playerChar;
    }

    /**
     * Menu displaying while playing, call the walk method, allow to see char stats, or exit the game
     * @param playerChar
     * @return
     */
    public int runMenu(Characters playerChar) {

        int playerChoice = 0;

        String isName = playerChar.getName();
        String isClass = playerChar.getClassType();
        int isAP = playerChar.getMinAP();
        int isHP = playerChar.getHealth();

        switch (utl.intQuestion("===========================================\n" +
                "(1) Go on\n" +
                "(2) See char stats\n" +
                "(3) Save char\n" +
                "(4) Exit\n" +
                "===========================================")) {
            case 1:
                playerChoice = 1;
                break;
            case 2:
                utl.print("===========================================\n" +
                        "STATS :\n" +
                        "Name : " + isName + "\n" +
                        "Class : " + isClass + "\n" +
                        "AP : " + isAP + "\n" +
                        "HP(s) : " + isHP + "\n" +
                        "Map position : " + playerChar.getCharPosition());

                if (playerChar != null && playerChar instanceof Warrior && ((Warrior) playerChar).getWeapon() != null) {
                    utl.print("Weapon : " + ((Warrior) playerChar).getWeapon().getWeaponName() + "\n" +
                            "Weapon damage : " + ((Warrior) playerChar).getWeapon().getWeaponAmount() + "\n" +
                            "Shield defense : " + ((Warrior) playerChar).getShield().getWeaponAmount());
                } else if (playerChar != null && playerChar instanceof Sorcerer && ((Sorcerer) playerChar).getSpell() != null) {
                    utl.print("Spell : " + ((Sorcerer) playerChar).getSpell().getWeaponName() + "\n" +
                            "Spell damage : " + ((Sorcerer) playerChar).getSpell().getWeaponAmount() + "\n" +
                            "Filter defense : " + ((Sorcerer) playerChar).getFilter().getWeaponAmount());
                } else {
                    utl.print("Coconut capacity: " + ((Coconut) playerChar).getCoconutWeapon().getWeaponName() + "\n" +
                            "Capacity damage : " + ((Coconut) playerChar).getCoconutWeapon().getWeaponAmount() + "\n" +
                            "Coconut defense : " + ((Coconut) playerChar).getCoconutSkin().getWeaponAmount());
                }

                break;
            case 3:
                playerChoice = 3;
                break;
            case 4:
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