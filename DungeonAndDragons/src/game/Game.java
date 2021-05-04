package game;

//Imports
import menu.Menu;
import utils.Utils;

//Stuffs warrior
import stuff.Mace;
import stuff.Sword;

//Stuffs sorcerer
import stuff.Tunderbold;
import stuff.Fireball;

//Stuffs for all
import stuff.GreatPotion;
import stuff.SmallPotion;
import sun.lwawt.macosx.CSystemTray;

import java.util.Scanner;

public class Game {

	//Attributes
	Menu menu;
	Dice dice;
	Utils utl;

	//Constructor
	public Game() {

		this.menu = new Menu();
		this.dice = new Dice();
		this.utl = new Utils();

	}

	public void introduction() {

		//Menu launcher
		menu.startMenu();

		//Game Introduce
		try{
		    Thread.sleep(1000);
			utl.print("-----------INTRODUCTION-----------");
			utl.print("You appear in a step, at night * * *, near the sea and see a dungeon.");
			Thread.sleep(1000);
			utl.print("You walk slowly to it, inside the darkness.");
			Thread.sleep(1000);
		}
		catch(InterruptedException ex){
			System.out.println(ex);
		}

	}

	//All the game's running here
	public void gameRunning() {

		//Usefull attributes
		String isName = menu.getMenuChar().getPlayerChar().getName();
		String isClass = menu.getMenuChar().getPlayerChar().getClassType();
		int isAP = menu.getMenuChar().getPlayerChar().getMinAP();
		int isHP = menu.getMenuChar().getPlayerChar().getHealth();

		//First stage
		int map = 64;
		int playerPosition = 1;

		switch(utl.intQuestion("Now, near a door to enter the dungeon you ask yourself : what should i do ? (1) Enter (2) Run away like a wimp.")) {

			case 1:

				try {
					utl.print("---------------STAGE---------------");
					Thread.sleep(2000);
					utl.print("The door screw while you open it, and a long dark cave appear behind you. It's time to go, hero.");
				}
				catch(InterruptedException ex) {
					System.out.println(ex);
				}

				//Everything happen here !
				while(map > playerPosition) {
					//All events and new map() object
					menu.runMenu();
				}
				break;

			case 2:
				utl.print( "You runned out like a wimp... Zero." );
				System.exit(0);
				break;

			default :
				utl.print( "You stayed here, undecide, for 38 years, near a door... And died at 72 years old alone and poor." );
				new Menu();
				break;
		}
	}
}