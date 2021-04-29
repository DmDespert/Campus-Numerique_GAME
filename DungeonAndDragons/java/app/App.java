package app;

//Imports
import menu.Gaming;
import java.util.Scanner;

public class App {
	
	public static void main(String [] args) {
		
		//Globals
		Scanner entries = new Scanner( System.in );
		
		//Starting game menu
		System.out.println( "(1) New Game (2) Exit Game" );
		int playerChoice = entries.nextInt();
		
		switch(playerChoice) {
		case 1:
			new Gaming();
			break;
		case 2:
			//ExitGame ExitGame = new ExitGame();
			System.out.println( "Game over" );
			System.exit(0);
			break;
		default : 
			System.out.println( "Wimp" );
		}
	}
	
}