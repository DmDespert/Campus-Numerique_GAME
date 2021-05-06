package characters;

//Imports
import stuff.Stuff;

public class Coconut extends Characters {

    private Stuff coconutWeapon;
    private Stuff coconutSkin;
    private Stuff potion;

    //Constructor
    public Coconut(String name, Stuff coconutWeapon, Stuff coconutSkin, Stuff potion) {
        super(name, "Coconut", 40, 40, 2, 4);
        this.coconutWeapon = coconutWeapon;
        this.coconutSkin = coconutSkin;
        this.potion = potion;
    }

    //Commons & Overrides
    @Override
    public int attack(int spell) {
        int attackAmount = getMinAP();
        return attackAmount;
    }

    //Getters & Setters
    public Stuff getCoconutWeapon() {
        return coconutWeapon;
    }

    public void setCoconutWeapon(Stuff coconutWeapon) {
        this.coconutWeapon = coconutWeapon;
    }

    public Stuff getCoconutSkin() {
        return coconutSkin;
    }

    public void setCoconutSkin(Stuff coconutSkin) {
        this.coconutSkin = coconutSkin;
    }

    public Stuff getPotion() {
        return potion;
    }

    public void setPotion(Stuff potion) {
        this.potion = potion;
    }
}