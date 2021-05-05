package game;

//Imports
import characters.Characters;
import characters.Sorcerer;
import characters.Warrior;
import enemies.Enemies;
import menu.Menu;
import utils.Utils;
import stuff.Stuff;
import map.Map;

public class Game {

	//Attributes
	private Characters playerChar;
	Menu menu;
	Dice dice;
	Utils utl;
	Map map;

	//Constructor
	public Game() {

		this.playerChar = null;
		this.menu = new Menu();
		this.dice = new Dice();
		this.utl = new Utils();
		this.map = new Map();

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

	public void generateMap() {
		map.generateRandomCase(menu.getMenuChar().getPlayerChar().getClassType());
	}

	//All the game's running here
	public void gameRunning() {

		//First stage

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
				while(map.getMaxBox() > menu.getMenuChar().getPlayerChar().getCharPosition()) {
					//All events
					menu.runMenu();
					try{
						if(menu.getMenuChar().getPlayerChar().getCharPosition() < map.getMaxBox()) {

							String event = map.getGeneratedMap().get(menu.getMenuChar().getPlayerChar().getCharPosition()).toString();
							Thread.sleep(150);
							utl.print("You go to the box number " + menu.getMenuChar().getPlayerChar().getCharPosition());
							utl.print(event);

							if (map.getGeneratedMap().get(menu.getMenuChar().getPlayerChar().getCharPosition()) instanceof Enemies) {
								utl.print("Enemies");
								//fightEvent(map.getGeneratedMap().get(menu.getMenuChar().getPlayerChar().getCharPosition()));
							}
							else if (map.getGeneratedMap().get(menu.getMenuChar().getPlayerChar().getCharPosition()) instanceof Stuff) {
								utl.print("Stuff");
							}

						}
						else {
							utl.print("The end : you runned to fast, splashed your ass on a wall and died stupidly.");
							menu.startMenu();
						}
					} catch (InterruptedException ex) {
						System.out.println(ex);
					}

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

	public void fightEvent(Enemies enemies) {
		utl.print("You fight versus " + enemies.getName());
		utl.print("Enemie HP(s) : " + enemies.getHealth());
		utl.print("Enemie AP : " + enemies.getEnemyAP());

		while(enemies.getHealth() > 0) {
			utl.print("Fight");
			enemies.setHealth(enemies.getHealth()-1);
		}
	}

}