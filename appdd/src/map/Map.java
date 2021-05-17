/**
 * Contain all related to map
 */
package map;

//Imports
import characters.Characters;
import stuff.*;
import utils.Utils;
import enemies.*;

import java.util.ArrayList;
import java.util.List;

/**Contain all the map functions & attributes to generate map**/
public class Map extends Slot {

    //Attributes of Map
    private List<Slot> generatedMap;
    private int maxMapSlot;

    Utils utl;

    //Constructors of Map
    public Map() {

        this.generatedMap = new ArrayList<Slot>();
        this.utl = new Utils();

        //Change this to make the map bigger
        this.maxMapSlot = 65;

    }

    /**Commons functions of Map**/

    /**Function called to generate randomly the wall map : based on selected class for stuffs.**/
    public void generateRandomSlot(String currentCharType) {
        for(int i=1; i<maxMapSlot; i++) {
            int randomCase = utl.random();
            switch(randomCase) {
                //Goblins generate chance
                case 1:
                case 2:
                case 3:
                    generatedMap.add(new Goblins());
                    break;
                //Sorcerers generate chance
                case 4:
                case 5:
                    generatedMap.add(new Sorcerers());
                    break;
                //Dragons generate chance
                case 6:
                    generatedMap.add(new Dragons());
                    break;
                //Potions generate chance
                case 7:
                    generatedMap.add(new SmallPotion());
                    break;
                case 8:
                    generatedMap.add(new GreatPotion());
                    break;
                //Weapons generate chance (based on class selected)
                case 9:
                    if(currentCharType == "Sorcerer") {
                        generatedMap.add(new Tunderbolt());
                        break;
                    }
                    if(currentCharType == "Warrior") {
                        generatedMap.add(new Mace());
                        break;
                    }
                    else {
                        generatedMap.add(new SmallPotion());
                    }
                    break;
                case 10:
                    if(currentCharType == "Sorcerer") {
                        generatedMap.add(new Fireball());
                        break;
                    }
                    else if(currentCharType == "Warrior") {
                        generatedMap.add(new Sword());
                        break;
                    }
                    else if(currentCharType == "Coconut") {
                        generatedMap.add(new CoconutFriends());
                        break;
                    }
            }
        }
        //Boss generator
        generatedMap.add(new Brozock());
    }

    @Override
    public void action(Characters playerChar) {}

    /**Getters & Setters**/
    public int getMaxBox() {
        return maxMapSlot;
    }
    public List<Slot> getGeneratedMap() {
        return generatedMap;
    }


}
