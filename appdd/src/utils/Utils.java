/**
 * Utilities package - used to code fastly or call redundant functions
 */
package utils;

//Imports in Utils
import java.util.Scanner;

/**Utilities Class, add here generals function that you need everywhere or code shortcuts.**/
public class Utils {

    private static Scanner entries;

    public Utils() {
        this.entries = new Scanner( System.in );
    }

    /**Common functions**/

    /**This function is usefull in switch/ cases, type utl.intQuestion("Your question"); - return int.**/
    public static int intQuestion(String question) {
        int answer;
        while(true) {
            try {
                System.out.println(question);
                answer = Integer.parseInt(entries.nextLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.print("Nope, only number ! : \n");
            }
        }
        return answer;
    }

    /**Basic print function, type utl.print("your text");**/
    public void print(String question) {
        System.out.println(question);
    }

    /**Random int return for map generator, or fights luck. Use this if you need an random int in function**/
    public int random() {
        int min = 1;
        int max = 10;
        int range = max - min +1;
        int rand = (int) (Math.random() * range) + min;

        return rand;
    }

}
