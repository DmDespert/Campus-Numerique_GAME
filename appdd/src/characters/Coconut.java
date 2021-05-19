package characters;

//Imports
import stuff.Stuff;

/**Coconut characters class**/
public class Coconut extends Characters {

    private Stuff coconutWeapon;
    private Stuff coconutSkin;
    private Stuff potion;

    /**
     * Coconut Constructor
     * @param name
     * @param coconutWeapon
     * @param coconutSkin
     * @param potion
     */
    public Coconut(String name, Stuff coconutWeapon, Stuff coconutSkin, Stuff potion) {
        super(name, "Coconut", 40, 40, 2, 4);
        this.coconutWeapon = coconutWeapon;
        this.coconutSkin = coconutSkin;
        this.potion = potion;
    }

    @Override
    /**
     * Specific class attack
     */
    public int attack(int spell) {
        int attackAmount = getMinAP() + spell;
        return attackAmount;
    }

    public Stuff getCoconutWeapon() { return coconutWeapon; }
    public void setCoconutWeapon(Stuff coconutWeapon) { this.coconutWeapon = coconutWeapon; }
    public Stuff getCoconutSkin() { return coconutSkin; }
    public void setCoconutSkin(Stuff coconutSkin) { this.coconutSkin = coconutSkin; }
    public Stuff getPotion() { return potion; }
    public void setPotion(Stuff potion) { this.potion = potion; }

}