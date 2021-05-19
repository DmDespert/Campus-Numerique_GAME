/**
 * Game class contain all the stuff needed to make the game work
 */
package game;

import utils.Utils;
import characters.*;
import menu.Menu;
import map.Map;
import map.Slot;

import java.sql.SQLException;

/**
*Game class contain all the stuff needed to make the game work, like :<br/>
*- Player character (will interact with the game).<br/>
*- Dice launch to resolve fights.<br/>
*- Generated map that will interact with the player character moves.<br/>
 */
public class Game {

    private Characters playerChar;
    private Map map;
    private Utils utl;
    private Menu menu;
    private Connexion conn;

    private static Dice dice = new Dice();

    /**
     * Game constructors
     */
    public Game() {

        this.playerChar = null;

        this.utl = new Utils();
        this.menu = new Menu();
        this.conn = new Connexion();

    }

    /**
     * Game introduction function, also use to restart menu when exiting or dying.
     */
    public void introduction() {
        try {
            Thread.sleep(1000);
            utl.print("-------------------------------------------\n" +
                    ">> \uD83C\uDF0B INTRODUCTION \uD83C\uDF0B \n" +
                    "-------------------------------------------\n" +
                    "\uD83D\uDCAC You appear in a step, at night * * *, near the sea and see a dungeon.");
            Thread.sleep(3000);
            utl.print("\uD83D\uDCAC You walk slowly to it, inside the darkness.");
            Thread.sleep(3000);
            switch (menu.startMenu()) {
                case 1:
                    this.playerChar = menu.createChar(playerChar);
                    generateMap();
                    gameRun();
                    break;
                case 2:
                    conn.Connexion();
                    playerChar = conn.loadChar(playerChar);
                    generateMap();
                    utl.print("Loading " + playerChar.getName() + " character. Ready " + playerChar.getClassType() + " ?");
                    gameRun();
                    break;
                default :
                    utl.print("\uD83D\uDCAC Nope");
            }
        } catch (InterruptedException | SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Map random generator function, will generate the full map before start but after char creation.
     **/
    public void generateMap() {
        this.map = new Map();
        map.generateRandomSlot(playerChar.getClassType());
    }

    /**
     * Game core playing function, threads sleep are used here for immersion, contain map slots events reactions
     **/
    public void gameRun() {

        try {

            Thread.sleep(3000);
            utl.print("...........................................\n" +
                    "*** This is the ***");
            Thread.sleep(1500);
            utl.print("*** DUNGEONS & DRAGONS ***");
            Thread.sleep(1500);
            utl.print("*** GAME ***\n" +
                    "...........................................\n");
            Thread.sleep(1500);
            utl.print("\uD83D\uDCAC After a long walk, you reach a door to enter the dungeon and ask yourself : \n" +
                    "\uD83D\uDCAC What should i do ?");
            Thread.sleep(2500);
            switch (utl.intQuestion("===========================================\n" +
                    "(1) Enter\n" +
                    "(2) Run away like a wimp.\n" +
                    "===========================================")) {

                //Case entering the dungeon.
                case 1:

                    try {
                        utl.print("-------------------------------------------\n" +
                                ">> \uD83C\uDFF0 DUNGEON \uD83C\uDFF0 \n" +
                                "-------------------------------------------");
                        Thread.sleep(3000);
                        utl.print("\uD83D\uDCAC The door screw while you open it, and a long dark corridor appear behind you. \n" +
                                "\uD83D\uDCAC It's time to go, hero.");
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }

                    //Everything happen here !
                    while (gameProcess()) {

                        switch (menu.runMenu(playerChar)) {
                            case 1:
                                playerChar.walk(dice.rollingDice());
                                utl.print("\uD83C\uDFB2 Dice score : " + dice.getDice());

                                try {
                                    if (playerChar.getCharPosition() >= map.getMaxBox()) {
                                        playerChar.setCharPosition(map.getMaxBox() - 1);
                                    }
                                    Thread.sleep(150);
                                    utl.print("You go to the slot number " + playerChar.getCharPosition());

                                    Slot currentSlot = map.getGeneratedMap().get(playerChar.getCharPosition());
                                    currentSlot.action(playerChar);

                                    if (playerChar.getHealth() <= 0) {
                                        utl.print("\uD83D\uDC80 You died. \n" +
                                                "-------------------------------------------\n" +
                                                "GAME OVER\n" +
                                                "-------------------------------------------");
                                        if (menu.startMenu() == 1) {
                                            introduction();
                                        }
                                    }

                                    if (playerChar.getCharPosition() == map.getMaxBox() - 1 && playerChar.getHealth() > 0) {
                                        utl.print("\uD83D\uDCAC Euuuurghgghgh....blbllb....");
                                        Thread.sleep(1500);
                                        utl.print("\uD83D\uDCAC bl...... .");
                                        Thread.sleep(1500);
                                        utl.print("\uD83D\uDCAC Brozock is dead, you won hero.");
                                        Thread.sleep(1500);
                                        utl.print("\uD83D\uDCAC You became strong and rich, full of honor as a great " + playerChar.getClassType() + " named " + playerChar.getName());
                                        Thread.sleep(3000);
                                        utl.print("Producted by : Me, and it cost me a lot");
                                        Thread.sleep(2000);
                                        utl.print("Music by DmDespert (listen this silence, i worked hard)");
                                        Thread.sleep(2000);
                                        utl.print("Main role by " + playerChar.getName());
                                        Thread.sleep(2000);
                                        utl.print("Thanks to " + playerChar.getName());
                                        Thread.sleep(2000);
                                        utl.print("And Brad Pitt, but i don't know why...");
                                        Thread.sleep(2000);
                                        utl.print("Credit : DmDespert @Github");
                                        Thread.sleep(3000);
                                        utl.print("\uD83C\uDFC6 The end \uD83C\uDFC6");
                                        introduction();
                                    }

                                } catch (InterruptedException ex) {
                                    System.out.println(ex);
                                }
                                break;
                            case 2:
                                introduction();
                                break;
                        }

                    }
                    break;

                //Case running out the dungeon.
                case 2:
                    utl.print("\uD83D\uDCAC You runned out like a wimp... Zero.");
                    introduction();
                    break;

                //Case any other scanner entries.
                default:
                    utl.print("\uD83D\uDCAC You stayed here, undecided, for 38 years, near a door... \n" +
                            "\uD83D\uDCAC And died at 72 years old alone and poor.");
                    introduction();
                    break;
            }

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

    }

    public boolean gameProcess() {
        return map.getMaxBox() > playerChar.getCharPosition(); /* && playerChar.getHealth() > 0;*/
    }

    public static Dice getDice() { return dice; }

}