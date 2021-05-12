package map;

//Imports
import java.util.ArrayList;
import java.util.List;
import characters.Characters;

/**Abstract class used to generate slots in Map child.**/
abstract public class Slot {

    List<Slot> generatedMap = new ArrayList<>();
    public abstract void action(Characters playerChar);

}
