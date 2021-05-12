package enemies;

import characters.Characters;
import utils.Utils;

/**Brozock big boss - end of the map**/
public class Brozock extends Enemies {

    private Utils utl;

    public Brozock() {

        super("Brozock", 32, 4);

        this.utl = new Utils();

    }

    /**Load specific story when brozock is coming**/
    public void action(Characters playerChar) {
        try {
            utl.print("You reach the light ! It's near ! The exit, finally.\nWooohoo !!");
            Thread.sleep(4500);
            utl.print("*** bm... ***");
            Thread.sleep(2300);
            utl.print("*** Bom... ***");
            Thread.sleep(2300);
            utl.print("*** BOOM... ***");
            Thread.sleep(2300);
            utl.print("GGGRRRRROOOOOOAAAAAARRRRRGHHHHHHHHHH.... Skwig.\n" +
                    "What the hell ?? A fucking big monster crashed the wall and he's near you now.");
            Thread.sleep(2300);
            utl.print("You cannot run away !!");
            Thread.sleep(1500);
            utl.print("-------------------------------------------\n" +
                    ">> BOSS\n" +
                    "-------------------------------------------");
            duringFight(playerChar);
        }
        catch(InterruptedException ex) {
            System.out.print(ex);
        }
    }

}
