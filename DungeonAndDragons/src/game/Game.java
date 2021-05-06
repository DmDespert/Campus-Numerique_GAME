package game;

//Imports
import utils.Utils;
import characters.*;
import stuff.*;
import menu.Menu;
import map.Map;
import enemies.Enemies;

public class Game {

    //Attributes
    private Characters playerChar;
    private Map map;

    Utils utl;
    Menu menu;
    Dice dice;

    //Constructor
    public Game() {

        this.playerChar = null;

        this.utl = new Utils();
        this.menu = new Menu();
        this.dice = new Dice();

    }

    //Game introduction
    public void introduction() {
        try {
            Thread.sleep(1000);
            utl.print("-----------INTRODUCTION-----------");
            utl.print("You appear in a step, at night * * *, near the sea and see a dungeon.");
            Thread.sleep(1000);
            utl.print("You walk slowly to it, inside the darkness.");
            Thread.sleep(1000);
            if (menu.startMenu() == 1) {
                this.playerChar = menu.createChar(playerChar);
                generateMap();
                gameRun();
            }
            else {
                utl.print("Nope");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    //Map random generator
    public void generateMap() {
        this.map = new Map();
        map.generateRandomCase(playerChar.getClassType());
        //Supprimer ligne utl.print pour éviter l'affichage du plateau total
        utl.print(map.getGeneratedMap().toString());
    }

    //Game core
    public void gameRun() {

        switch (utl.intQuestion("After a long walk, you reach a door to enter the dungeon and ask yourself : what should i do ? (1) Enter (2) Run away like a wimp.")) {

            case 1:

                try {
                    utl.print("-------------DUNGEON-------------");
                    Thread.sleep(2000);
                    utl.print("The door screw while you open it, and a long dark corridor appear behind you. It's time to go, hero.");
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }

                //Everything happen here !
                while (map.getMaxBox() > playerChar.getCharPosition()) {

                    switch(menu.runMenu(playerChar)) {
                        case 1:
                            playerChar.walk(dice.rollingDice());
                            utl.print("Dice score : " + dice.getDice());

                            try {
                                if (playerChar.getCharPosition() < map.getMaxBox()) {

                                    Thread.sleep(150);
                                    utl.print("You go to the box number " + playerChar.getCharPosition());

                                    if (map.getGeneratedMap().get(playerChar.getCharPosition()) instanceof Enemies) {
                                        utl.print("A " + map.getGeneratedMap().get(playerChar.getCharPosition()) + " is attacking you");
                                        fightEvent((Enemies) map.getGeneratedMap().get(playerChar.getCharPosition()));
                                    } else if (map.getGeneratedMap().get(playerChar.getCharPosition()) instanceof Stuff) {
                                        utl.print("You found " + map.getGeneratedMap().get(playerChar.getCharPosition()));
                                        stuffEvent((Stuff) map.getGeneratedMap().get(playerChar.getCharPosition()));
                                    }

                                } else {
                                    try {
                                        playerChar.setCharPosition(65);
                                        utl.print("You reach the light ! It's near ! The exit, finally.");
                                        Thread.sleep(1500);
                                        utl.print("*** bm... ***");
                                        Thread.sleep(1500);
                                        utl.print("*** Bom... ***");
                                        Thread.sleep(1500);
                                        utl.print("*** BOOM... ***");
                                        Thread.sleep(1500);
                                        utl.print("What the hell ?? A fucking big monster crashed the wall and he's near you now");
                                        Thread.sleep(3000);
                                        utl.print("You cannot run away !!");
                                        fightEvent((Enemies) map.getGeneratedMap().get(playerChar.getCharPosition()));
                                        Thread.sleep(1500);
                                        utl.print("Euuurhgggg.... blrlblppp... Gah.");
                                        Thread.sleep(3000);
                                        utl.print("The end : The boss is dead, and you won : became rich and full of honor.");
                                        if(menu.startMenu() == 1) {
                                            introduction();
                                        }
                                        break;
                                    }
                                    catch(InterruptedException ex) {
                                        System.out.print(ex);
                                    }

                                }
                            } catch (InterruptedException ex) {
                                System.out.println(ex);
                            }
                            break;
                        case 2:
                            playerChar.setCharPosition(90);
                            introduction();
                            break;
                    }

                }
                break;

            case 2:
                utl.print("You runned out like a wimp... Zero.");
                System.exit(0);
                break;

            default:
                utl.print("You stayed here, undecide, for 38 years, near a door... And died at 72 years old alone and poor.");
                if(menu.startMenu() == 1) {
                    introduction();
                }
                break;
        }

    }

    //Encounter enemies events
    public void fightEvent(Enemies enemies) {

        int playerChoice = 0;

        utl.print("You fight versus " + enemies.getName());
        utl.print("Enemie AP : " + enemies.getEnemyAP());

        while(enemies.getHealth() > 0 && playerChar.getHealth() >= 1 && playerChoice != 2) {

            utl.print("Enemie HP(s) : " + enemies.getHealth());

            switch(menu.fightMenu()) {
                case 1:
                    if(playerChar.getClassType() == "Warrior") {
                        enemies.setHealth(enemies.getHealth() - playerChar.attack(menu.getWeapon().getAmount()));
                        utl.print("Enemie lost " + playerChar.attack(menu.getWeapon().getAmount()) + " HP's");
                    }
                    else {
                        enemies.setHealth(enemies.getHealth() - playerChar.attack(menu.getSpell().getAmount()));
                        utl.print("Enemie lost " + playerChar.attack(menu.getSpell().getAmount()) + " HP's");
                    }
                    if(enemies.getHealth() > 0) {
                        utl.print("Enemie still alive, and hit you for " + enemies.getEnemyAP() + " damages");
                        int defense = playerChar.defense();
                        utl.print("You defended yourself for " + defense + " damages");
                        int finalHit = enemies.getEnemyAP() - defense;
                        if(finalHit < 0) {
                            finalHit = 0;
                        }
                        playerChar.setHealth(playerChar.getHealth() - finalHit);
                        utl.print("You lost : " + finalHit + " HP's");
                        utl.print("Your HP's : " + playerChar.getHealth());

                        if(playerChar.getHealth() <= 0 ) {
                            utl.print("You died.");
                            if(menu.startMenu() == 1) {
                                introduction();
                            }
                        }
                    }
                    playerChoice = 1;
                    break;
                case 2:
                    playerChar.setCharPosition(playerChar.getCharPosition() - dice.rollingDice());
                    utl.print("Dice score : " + dice.getDice());
                    if(playerChar.getCharPosition() <= 0) {
                        playerChar.setCharPosition(0);
                    }
                    utl.print("You gone back for " + dice.getDice() + " slots.");
                    playerChoice = 2;
                    break;
            }

        }
    }

    //Stuff drop events
    public void stuffEvent(Stuff stuff) {

        utl.print("You found a " + stuff.getName());
        utl.print("Provided : " + stuff.getAmount());
        if(menu.equipStuff(stuff) == 1 && stuff.getName() == "Small life potion" || stuff.getName() == "Great life potion") {
            playerChar.setHealth(playerChar.getHealth() + stuff.getAmount());
            if(playerChar.getHealth() > playerChar.getMaxHealth()) {
                playerChar.setHealth(playerChar.getMaxHealth());
            }
        }

    }
}