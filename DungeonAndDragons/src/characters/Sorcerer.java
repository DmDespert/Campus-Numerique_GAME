package characters;

//Imports
import stuff.Stuff;

public class Sorcerer extends Characters {

	Stuff spell;
	Stuff filter;
	Stuff potion;
	
	//Constructor
	public Sorcerer(String name, Stuff spell, Stuff filter, Stuff potion) {
		super(name, "Sorcerer", 3, 6, 8, 15);
		this.spell = spell;
		this.filter = filter;
		this.potion = potion;
	}

}