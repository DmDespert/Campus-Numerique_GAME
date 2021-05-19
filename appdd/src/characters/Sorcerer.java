package characters;

//Imports
import stuff.Stuff;

/**
 * Sorcerer characters class
 */
public class Sorcerer extends Characters {

	private Stuff spell;
	private Stuff filter;
	private Stuff potion;

	/**
	 * Sorcerer Construction
	 * @param name
	 * @param spell
	 * @param filter
	 * @param potion
	 */
	public Sorcerer(String name, Stuff spell, Stuff filter, Stuff potion) {
		super(name, "Sorcerer", 3, 6, 8, 15);
		this.spell = spell;
		this.filter = filter;
		this.potion = potion;
	}

	@Override
	/**
	 * Specific class attack
	 */
	public int attack(int spell) {
		int attackAmount = spell + getMinAP();
		return attackAmount;
	}

	public Stuff getSpell() { return spell; }
	public void setSpell(Stuff spell) { this.spell = spell; }
	public Stuff getFilter() { return filter; }
	public void setFilter(Stuff filter) { this.filter = filter; }
	public Stuff getPotion() { return potion; }
	public void setPotion(Stuff potion) { this.potion = potion; }

}