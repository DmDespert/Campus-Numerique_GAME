import game.Game;

/**
 * <strong>JAVADOC APP DUNGEONS & DRAGONS</strong><br/>
 *Main App class, the entrance point of the application, creating here a new game object.<br/>
 *On all the app your can load utils package to activate the shorter code release like :<br/>
 *- utl.print for System.out.print<br/>
 *- utl.intQuestion that will return an int after scanner the user answer. Use this to make the game roaming different ways.<br/>
 *<br/>
 *<strong>Introduce :</strong><br/>
 *- Attributes : contain class basics attributes.<br/>
 *- Constructors : used to construct objects by using class.<br/>
 *- Commons function : Methods used for the object <br/>
 *- Getters & Setters : used to get/set private attributes.<br/>
 *<br/>
 *<strong>All packages :</strong><br/>
 *characters : related to player char attributes & class<br/>
 *enemies : contain all encountered enemies<br/>
 *game : contain dice & game which import all the game elements<br/>
 *map : related to map generating with slots which will contain encounters & droppable stuffs<br/>
 *menu : related to player choice (new game, exit, fight or escape, etc...)<br/>
 *stuff : contain all droppable stuffs<br/>
 *utils : utilities<br/>
 *<br/>
 *<strong>How it work :</strong><br/>
 *(1) Main core : App < Game < Map & Dice & Characters & Menu<br/>
 *(2) Map : Slot(abstract) > Map < Stuff & Enemies<br/>
 *(3) Characters : Characters(abstract) > Coconut & Sorcerer & Warrior<br/>
 *(4) Enemies : Enemies(abstract) > Brozock(Boss) & Dragons & Sorcerers & Goblins<br/>
 *(5) Stuff : Stuff(abstract) > All stuffs droppable in the game<br/>
 *(6) Menu : Only choices functions here, called in game or during fights in Enemies<br/>
 *(7) Utils : Only utils used to code shortcuts and utilities.<br/>
 **/
public class App {
	
	/**Main entry of app (launcher)**/
	public static void main(String [] args) {

		Game game = new Game();
		game.introduction();

	}
	
}