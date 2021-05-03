package game;

//Imports
import menu.Menu;

//Stuffs warrior
import stuff.Mace;
import stuff.Sword;

//Stuffs sorcerer
import stuff.Tunderbold;
import stuff.Fireball;

//Stuffs for all
import stuff.GreatPotion;
import stuff.SmallPotion;

import java.util.Scanner;

public class Game {

	Menu menu;
	Dice dice;

	public Game() {

		this.menu = new Menu();
		this.dice = new Dice();

	}

	public void introduction() {

		//Menu launcher
		menu.startMenu();

		//Introduction
		try{
		    Thread.sleep(1000);
		    System.out.println("-----------------------");
			System.out.println("You appear in a step, at night, near the sea and see a dungeon.");
		}
		catch(InterruptedException ex){
			System.out.println(ex);
		}

		try{
		    Thread.sleep(1000);
		    System.out.println("You walk slowly to it, inside the darkness.");
		}
		catch(InterruptedException ex){
			System.out.println(ex);
		}

		try{
		    Thread.sleep(1000);
			System.out.println("Now, near a door to enter the dungeon you ask yourself : what should i do ? (1) Enter (2) Run away like a wimp.");

		}
		catch(InterruptedException ex){
			System.out.println(ex);
		}
	}

	public void gameRunning() {

		//Usefull attributes
		String isName = menu.getMenuChar().getPlayerChar().getName();
		String isClass = menu.getMenuChar().getPlayerChar().getClassType();
		int isAP = menu.getMenuChar().getPlayerChar().getMinAP();
		int isHP = menu.getMenuChar().getPlayerChar().getHealth();


		//First stage
		Scanner entries = new Scanner( System.in );
		int playerStart = entries.nextInt();
		entries.nextLine();

		int map = 64;
		int playerPosition = 1;

		switch(playerStart) {

			case 1:
				while(map > playerPosition) {

					//Everything appends here !
					try{
						System.out.println("(1) Roll Dice -- (2) See char stats -- (3)  Exit -- (4) Equip new weapon");
						int playerChoice = entries.nextInt();

						switch (playerChoice) {
							case 1:
								dice.rollingDice();
								System.out.println("Dice score : " + dice.getDice());

								playerPosition = playerPosition + dice.getDice();

								if(playerPosition < 64) {
									Thread.sleep(150);
									System.out.println("And go up to the case number " + playerPosition);
								}
								else {
									System.out.println("The end : you runned to fast, splashed your ass on a wall and died stupidly.");
								}
								break;
							case 2 :
								System.out.println("Name : " + isName);
								System.out.println("Class : " + isClass);
								System.out.println("AP : " + isAP);
								System.out.println("HP(s) : " + isHP);
								if(menu.getMenuChar().getWeapon() != null && isClass == "Warrior") {
									System.out.println("Weapon : " + menu.getMenuChar().getWeapon().getName());
									System.out.println("Weapon damage : " + menu.getMenuChar().getWeapon().getAmount());
								}
								else if(menu.getMenuChar().getWeapon() != null && isClass == "Sorcerer") {
									System.out.println("Spell : " + menu.getMenuChar().getWeapon().getName());
									System.out.println("Spell damage : " + menu.getMenuChar().getWeapon().getAmount());
								}
								else {
									if(isClass == "Warrior") {
										System.out.println("Weapon : empty");
									}
									else {
										System.out.println("Spell : unknown");
									}
								}
								break;
							case 3 :
								System.out.println("Are you sure ? (1) Yes (2) No");
								playerChoice = entries.nextInt();
								if(playerChoice == 1) {
									menu.startMenu();
									break;
								}
								else {
									break;
								}
							case 4 :
								if(isClass == "Warrior") {
									menu.getMenuChar().setWeapon(new Mace());
								}
								if(isClass == "Sorcerer") {
									menu.getMenuChar().setWeapon(new Fireball());
								}
						}

					}
					catch(InterruptedException ex){
						System.out.println(ex);
					}

				}
				break;

			case 2:
				System.out.println( "You runned out like a wimp... Zero." );
				System.exit(0);
				break;

			default :
				System.out.println( "You stayed here, undecide, for 38 years, near a door... And died at 72 years old alone and poor." );
				new Menu();
				break;

		}
	}

}