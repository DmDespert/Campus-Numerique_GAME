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
			
			switch(playerChoice) {
				
				case 1:
					menuChar.start();
					break;
				case 2:
					System.out.println("Are you sure ? (1) Yes (2) No");
					playerChoice = entries.nextInt();
					if(playerChoice == 1) {
						System.out.println( "Game over" );
						System.exit(0);
					}
					else {
						break;
					}
				default : 
					System.out.println( "Wimp" );
					break;
					
			}

		}
		
	}

	public MenuChar getMenuChar() {
		return menuChar;
	}

	public void setMenuChar(MenuChar menuChar) {
		this.menuChar = menuChar;
	}
}