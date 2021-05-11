package game;

//Imports

import utils.Utils;
import characters.*;
import menu.Menu;
import map.Map;
import map.Slot;

public class Game {

    //Attributes
    private Characters playerChar;
    private Map map;
    private Utils utl;
    private Menu menu;
    private static Dice dice;

    //Constructor
    public Game() {

        this.playerChar = null;

        this.utl = new Utils();
        this.menu = new Menu();
        this.dice = new Dice();

    }

    public static Dice getDice() {
        return dice;
    }

    //Game introduction
    public void introduction() {
        try {
            Thread.sleep(1000);
            utl.print("-------------------------------------INTRODUCTION-------------------------------------\n" +
                    "You appear in a step, at night * * *, near the sea and see a dungeon.");
            Thread.sleep(3000);
            utl.print("You walk slowly to it, inside the darkness.");
            Thread.sleep(3000);
            if (menu.startMenu() == 1) {
                this.playerChar = menu.createChar(playerChar);
                generateMap();
                gameRun();
            } else {
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
    }

    //Game core
    public void gameRun() {

        try {

            Thread.sleep(3000);
            utl.print("After a long walk, you reach a door to enter the dungeon and ask yourself : \n" +
                    "What should i do ?");
            switch (utl.intQuestion("(1) Enter -- (2) Run away like a wimp.")) {

                case 1:

                    try {
                        utl.print("----------------------------------------DUNGEON----------------------------------------");
                        Thread.sleep(3000);
                        utl.print("The door screw while you open it, and a long dark corridor appear behind you. \n" +
                                "It's time to go, hero.");
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }

                    //Everything happen here !
                    while (map.getMaxBox() > playerChar.getCharPosition()) {

                        switch (menu.runMenu(playerChar)) {
                            case 1:
                                playerChar.walk(dice.rollingDice());
                                utl.print("Dice score : " + dice.getDice());

                                try {
                                    if (playerChar.getCharPosition() >= map.getMaxBox()) {
                                        playerChar.setCharPosition(map.getMaxBox() - 1);
                                    }
                                    Thread.sleep(150);
                                    utl.print("You go to the slot number " + playerChar.getCharPosition());

                                    Slot currentSlot = map.getGeneratedMap().get(playerChar.getCharPosition());
                                    currentSlot.action(playerChar);

                                    if (playerChar.getHealth() <= 0) {
                                        utl.print("You died. \n---------------------------------------GAME OVER---------------------------------------");
                                        if (menu.startMenu() == 1) {
                                            introduction();
                                        }
                                    }

                                    if (playerChar.getCharPosition() == map.getMaxBox() - 1 && playerChar.getHealth() > 0) {
                                        utl.print("Euuuurghgghgh....blbllb....");
                                        Thread.sleep(1500);
                                        utl.print("bl...... .");
                                        Thread.sleep(1500);
                                        utl.print("Brozock is dead, you won hero.");
                                        Thread.sleep(1500);
                                        utl.print("You became strong and rich, full of honor as a great " + playerChar.getClassType() + " named " + playerChar.getName());
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
                                        utl.print("The end");
                                        introduction();
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
                    utl.print("You stayed here, undecided, for 38 years, near a door... \n" +
                            "And died at 72 years old alone and poor.");

                    if (menu.startMenu() == 1) {
                        introduction();
                    }
                    break;
            }

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

    }
}