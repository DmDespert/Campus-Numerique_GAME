package characters;
import stuff.Stuff;

public class Warrior extends Characters {

	Stuff weapon;
	Stuff shield;
	Stuff potion;
	
	//Constructor
	public Warrior(String name, Stuff weapon, Stuff shield, Stuff potion) {
		super(name, "Warrior", 5, 10, 5, 10);
		this.weapon = weapon;
		this.shield = shield;
		this.potion = potion;
	}

}