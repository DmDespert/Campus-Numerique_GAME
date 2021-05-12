/**
 * Contain all enemies
 */
package enemies;

import characters.Coconut;
import characters.Sorcerer;
import characters.Warrior;
import map.Slot;
import characters.Characters;
import utils.Utils;
import game.Game;
import game.Dice;

/**Abstract class used to construct all enemies, commons function related to fight are here**/
public class Enemies extends Slot {

    /**Enemy name**/
    private String name;

    /**Enemy default HP**/
    private int health;

    /**Enemy AP**/
    private int enemyAP;

    private Utils utl;

    /**Constructors**/
    public Enemies(String name, int health, int enemyAP) {
        this.name = name;
        this.health = health;
        this.enemyAP = enemyAP;
        this.utl = new Utils();
    }

    /**Commons functions**/

    /**Catch the enemies slot to interact & launch fightMenu()**/
    public void action(Characters playerChar) {
        utl.print("----------------------------------\n" +
                ">> FIGHT\n" +
                "----------------------------------\n" +
                "You fight versus " + this.getName() + "\n" +
                "Enemie AP : " + this.getEnemyAP());
        duringFight(playerChar);
    }

    /**Encounter enemies events - allow the player to escape or fight.**/
    public int fightMenu() {
        int playerChoice = utl.intQuestion("===========================================\n" +
                "(1) Attack\n" +
                "(2) Run away\n" +
                "===========================================");

        switch (playerChoice) {
            case 1:
                utl.print("Attacking");
                break;
            case 2:
                utl.print("You run away");
                break;
        }

        return playerChoice;
    }

    /**Encounter enemies events - All the fight is here (attack, defense and healths sets of char & enemies)**/
    public void duringFight(Characters playerChar) {
        int playerChoice = 0;

        while (this.getHealth() > 0 && playerChar.getHealth() >= 1 && playerChoice != 2) {

            utl.print("Enemie HP(s) : " + this.getHealth());

            //If fightMenu() return 1 (player went to attack)
            switch (fightMenu()) {
                case 1:
                    if (playerChar.getClassType() == "Warrior") {
                        this.setHealth(this.getHealth() - playerChar.attack(((Warrior) playerChar).getWeapon().getAmount()));
                        utl.print(this.getName() + " lost " + playerChar.attack(((Warrior) playerChar).getWeapon().getAmount()) + " HP's");
                    }
                    if (playerChar.getClassType() == "Sorcerer") {
                        this.setHealth(this.getHealth() - playerChar.attack(((Sorcerer) playerChar).getSpell().getAmount()));
                        utl.print(this.getName() + " lost " + playerChar.attack(((Sorcerer) playerChar).getSpell().getAmount()) + " HP's");
                    }
                    if (playerChar.getClassType() == "Coconut") {
                        this.setHealth(this.getHealth() - playerChar.attack(((Coconut) playerChar).getCoconutWeapon().getAmount()));
                        utl.print(this.getName() + " lost " + playerChar.attack(((Coconut) playerChar).getCoconutWeapon().getAmount()) + " HP's");
                    }
                    if (this.getHealth() > 0) {
                        utl.print(this.getName() + " is still alive, and hit you for " + this.getEnemyAP() + " damages");
                        int defense = playerChar.defense(Game.getDice().rollingDice());
                        int finalHit = this.getEnemyAP() - defense;
                        if (finalHit < 0) {
                            finalHit = 0;
                        }
                        playerChar.setHealth(playerChar.getHealth() - finalHit);
                        utl.print("You lost : " + finalHit + " HP's \n" +
                                "Your HP's : " + playerChar.getHealth());


                    } else {
                        utl.print(this.getName() + " died, in blood and scream.");
                    }
                    playerChoice = 1;
                    break;
                //fightMenu() return 2, player went to escape.
                case 2:
                    Dice dice = Game.getDice();
                    //You cannot escape the boss.
                    if (this.getName() == "Brozock") {
                        utl.print("\uD83D\uDCAC Aaahh, no ! You cannot run away");
                        playerChoice = 1;
                        break;
                    }
                    playerChar.setCharPosition(playerChar.getCharPosition() - dice.rollingDice());
                    utl.print("Dice score : " + dice.getDice());
                    if (playerChar.getCharPosition() <= 0) {
                        playerChar.setCharPosition(0);
                    }
                    utl.print("You gone back for " + dice.getDice() + " slots.");
                    playerChoice = 2;
                    break;
            }

        }
    }

    /**Setters & Getters**/
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public int getEnemyAP() { return enemyAP; }
    public void setEnemyAP(int enemyAP) { this.enemyAP = enemyAP; }

}