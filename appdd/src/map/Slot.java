package map;

import characters.Characters;

/**Abstract class used to generate slots in Map child.**/
abstract public class Slot {

    /**
     * React on player walk
     * @param playerChar
     */
    public abstract void action(Characters playerChar);

}
