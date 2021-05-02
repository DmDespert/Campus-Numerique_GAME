package game;

//Imports
import menu.Menu;
import java.util.Scanner;

public class Game {
	
	Menu menu;
	
	public Game() {
		
		this.menu = new Menu();

	}
	
	public void introduction() {
		
		//Menu launcher
		menu.startMenu();
		
		//Introduction
		try{
		    Thread.sleep(4000);
		    System.out.println("-----------------------");
			System.out.println("You appear in a step, at night, near the sea and see a dungeon.");
		}
		catch(InterruptedException ex){
			System.out.println(ex);	
		}
		
		try{
		    Thread.sleep(4000);
		    System.out.println("You walk slowly to it, inside the darkness.");
		}
		catch(InterruptedException ex){
			System.out.println(ex);
		}
		
		try{
		    Thread.sleep(3000);
			System.out.println("Now, near a door to enter the dungeon you ask yourself : what should i do ? (1) Enter (2) Run away like a wimp.");
			
		}
		catch(InterruptedException ex){
			System.out.println(ex);
		}
	}
	
	public void stage1() {
		
		//First stage
		Scanner entries = new Scanner( System.in );
		int playerStart = entries.nextInt();
		
		int map = 64;
		int playerPosition = 0;
		
		switch(playerStart) {
		
			case 1:
				while(map > playerPosition) {
					
					//Everything appends here !
					try{
					    Thread.sleep(150);
					    System.out.println("You go up for " + playerPosition + " case");
					    
						playerPosition = playerPosition +1;
						
						if(playerPosition == 64) {
							System.out.println("The end : you runned to fast, splashed your ass on a wall and died stupidly.");
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
				System.out.println( "You stayed here, undecide,  for 38 years, near a door... And died at 72 years old alone and poor." );
				new Menu();
				break;
			
		}
	}

}