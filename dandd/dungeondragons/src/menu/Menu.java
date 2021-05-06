package menu;

//Imports
import stuff.Fireball;
import stuff.Mace;
import utils.Utils;
import game.Dice;

public class Menu {

    //Attributes
    MenuChar menuChar;
    Utils utl;
    Dice dice;

    //Constructor
    public Menu() {
        this.menuChar = new MenuChar();
        this.utl = new Utils();
        this.dice = new Dice();
    }

    //Commons functions
    public void startMenu() {

        //Starting game menu
        int playerChoice = 0;

        while (playerChoice != 1 && playerChoice != 2) {

            playerChoice = utl.intQuestion("(1) New Game (2) Exit game");

            switch (playerChoice) {

                case 1:
                    menuChar.start();
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

    }

    public void runMenu() {

        String isName = getMenuChar().getPlayerChar().getName();
        String isClass = getMenuChar().getPlayerChar().getClassType();
        int isAP = getMenuChar().getPlayerChar().getMinAP();
        int isHP = getMenuChar().getPlayerChar().getHealth();

        switch (utl.intQuestion("(1) Roll Dice -- (2) See char stats -- (3)  Exit -- (4) Equip new weapon -- (5) Attack")) {
            case 1:
                getMenuChar().getPlayerChar().walk(dice.rollingDice());
                utl.print("Dice score : " + dice.getDice());
                break;
            case 2:
                utl.print("Name : " + isName);
                utl.print("Class : " + isClass);
                utl.print("AP : " + isAP);
                utl.print("HP(s) : " + isHP);
                utl.print("Map position : " + getMenuChar().getPlayerChar().getCharPosition());
                if (getMenuChar().getWeapon() != null && isClass == "Warrior") {
                    utl.print("Weapon : " + getMenuChar().getWeapon().getName());
                    utl.print("Weapon damage : " + getMenuChar().getWeapon().getAmount());
                } else if (getMenuChar().getWeapon() != null && isClass == "Sorcerer") {
                    utl.print("Spell : " + getMenuChar().getWeapon().getName());
                    utl.print("Spell damage : " + getMenuChar().getWeapon().getAmount());
                }
                break;
            case 3:
                if (utl.intQuestion("Are you sure ? (1) Yes (2) No") == 1) {
                    startMenu();
                    break;
                } else {
                    break;
                }
            case 4:
                if (isClass == "Warrior") {
                    getMenuChar().setWeapon(new Mace());
                    break;
                }
                if (isClass == "Sorcerer") {
                    getMenuChar().setWeapon(new Fireball());
                    break;
                }
            case 5:
                utl.print("You hit for : " + getMenuChar().getPlayerChar().attack(getMenuChar().getWeapon().getAmount()) + " damages.");
                break;
        }

    }

    public MenuChar getMenuChar() {
        return menuChar;
    }

    public void setMenuChar(MenuChar menuChar) {
        this.menuChar = menuChar;
    }
}