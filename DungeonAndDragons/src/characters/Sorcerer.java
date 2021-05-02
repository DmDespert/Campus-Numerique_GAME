package characters;

//Imports
import stuff.Fireball;
import stuff.Tunderbold;

public class Sorcerer extends Characters {
	
	String spellName;
	int spellDamage;
	
	String filter;
	int filterDefense;
	
	//Constructor
	public Sorcerer(String name) {
		super(name, "Sorcerer", 3, 6, 8, 15);
		this.spellDamage = 0;
		this.filterDefense = 0;
	}
	
	public void basicAttack() {
		
	}
	
	public void spellAttack(String spellName, int spellDamage) {
		this.spellName = spellName;
		this.spellDamage = spellDamage;
		
		System.out.println("You attack with " + spellName + " spell and do " + spellDamage + " damages");
	}
	
	public void defense(int filterDefense) {
		this.filter = "Filter";
		this.filterDefense = filterDefense;
		
		System.out.println("Filter saved you for " + filterDefense + " damges");
	}
	
	public void SorcererStuff() {
		
	}
	
}