package map;

//Imports
import characters.Characters;
import stuff.*;
import utils.Utils;
import enemies.*;

import java.util.ArrayList;
import java.util.List;

public class Map extends Slot {

    //Attributes
    private List<Slot> generatedMap;
    private int maxBox;

    //Utils
    Utils utl;

    //Constructor
    public Map() {

        this.utl = new Utils();

        this.generatedMap = new ArrayList<Slot>();
        this.maxBox = 64;

    }

    public int random() {
        int min = 1;
        int max = 7;
        int range = max - min +1;
        int rand = (int) (Math.random() * range) + min;

        return rand;
    }

    public int getMaxBox() {
        return maxBox;
    }

    public void setMaxBox(int maxBox) {
        this.maxBox = maxBox;
    }

    public List<Slot> getGeneratedMap() {
        return generatedMap;
    }

    public void setGeneratedMap(List<Slot> generatedMap) {
        this.generatedMap = generatedMap;
    }

    public void generateRandomCase(String currentCharType) {
        for(int i=0; i<maxBox; i++) {
            int randomCase = random();
            switch(randomCase) {
                case 1:
                    generatedMap.add(new Goblins());
                    break;
                case 2:
                    generatedMap.add(new Sorcerers());
                    break;
                case 3:
                    generatedMap.add(new Dragons());
                    break;
                case 4:
                    generatedMap.add(new SmallPotion());
                    break;
                case 5:
                    generatedMap.add(new GreatPotion());
                    break;
                case 6:
                    if(currentCharType == "Sorcerer") {
                        generatedMap.add(new Tunderbold());
                    }
                    else {
                        generatedMap.add(new Mace());
                    }
                    break;
                case 7:
                    if(currentCharType == "Sorcerer") {
                        generatedMap.add(new Fireball());
                    }
                    else {
                        generatedMap.add(new Sword());
                    }
                    break;
                case 8:
                    utl.print("Nothing happen.");
                    break;
            }
        }
    }


    public void fightEvent(Enemies enemies) {
        utl.print("You fight versus " + enemies.getName());
        utl.print("Enemie HP(s) : " + enemies.getHealth());
        utl.print("Enemie AP : " + enemies.getEnemyAP());

        while(enemies.getHealth() > 0) {
            utl.print("Fight");
            enemies.setHealth(enemies.getHealth()-1);
        }
    }

}
