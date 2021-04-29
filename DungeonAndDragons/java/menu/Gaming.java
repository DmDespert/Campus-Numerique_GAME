package menu;

import menu.NewGame;

public class Gaming {
	NewGame NewGame = new NewGame();
	
	public Gaming() {
		
		int map = 64;
		int playerPosition = 0;
		
		System.out.println("Welcome warrior " + playerChar.getName() + ". Ready to go ?");
		
		while(map > playerPosition) {
			
			//Everything appends here !
			System.out.println("Go go go");
			
			playerPosition = playerPosition +1;
			
			if(playerPosition == 64) {
				System.out.println("The end");
			}
			
		}
	}

}