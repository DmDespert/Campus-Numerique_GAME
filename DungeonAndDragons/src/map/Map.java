package map;

//Imports
import stuff.*;
import utils.Utils;
import enemies.*;

import java.util.ArrayList;
import java.util.List;

public class Map extends Slot {

    //Attributes
    private List<Slot> generatedMap;
    private int maxBox;

    Utils utl;

    //Constructor
    public Map() {

        this.generatedMap = new ArrayList<Slot>();
        this.utl = new Utils();
        this.maxBox = 65;

    }

    //Commons & Overrides
    public void generateRandomCase(String currentCharType) {
        for(int i=1; i<maxBox; i++) {
            int randomCase = utl.random();
            switch(randomCase) {
                case 1:
                    generatedMap.add(new Goblins());
                    break;
                case 2:
                    generatedMap.add(new Goblins());
                    break;
                case 3:
                    generatedMap.add(new Goblins());
                    break;
                case 4:
                    generatedMap.add(new Sorcerers());
                    break;
                case 5:
                    generatedMap.add(new Sorcerers());
                    break;
                case 6:
                    generatedMap.add(new Dragons());
                    break;
                case 7:
                    generatedMap.add(new SmallPotion());
                    break;
                case 8:
                    generatedMap.add(new GreatPotion());
                    break;
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
        generatedMap.add(new Brozock());
    }

    //Getters & Setters
    public int getMaxBox() {
        return maxBox;
    }

    public List<Slot> getGeneratedMap() {
        return generatedMap;
    }

}
