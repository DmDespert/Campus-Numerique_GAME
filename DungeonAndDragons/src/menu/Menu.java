package menu;

//Imports
import java.util.Scanner;

public class Menu {
	
	//Attributes
	MenuChar menuChar;
	
	//Constructor
	public Menu() {
		
		this.menuChar = new MenuChar();

	}
	
	//Commons functions
	public void startMenu() {
		
		Scanner entries = new Scanner( System.in );
		
		//Starting game menu
		int playerChoice = 0;
		
		while(playerChoice != 1 && playerChoice != 2) {
			
			System.out.println( "(1) New Game (2) Exit game" );
			
			playerChoice = entries.nextInt();
			entries.nextLine();
			
			System.out.println(playerChoice);
			
			switch(playerChoice) {
				
				case 1:
					menuChar.start();
					break;
				case 2:
					//ExitGame ExitGame = new ExitGame();
					System.out.println( "Game over" );
					System.exit(0);
					break;
				default : 
					System.out.println( "Wimp" );
					break;
					
			}

		}
		
	}
	
	public void gameMenu() {
		
		
	}
	
}