package utils;

//Imports
import java.util.Scanner;

public class Utils {

    //Attributes
    private Scanner entries;

    //Constructor
    public Utils() {
        this.entries = new Scanner( System.in );
    }

    //Common functions
    public int intQuestion(String question) {
        int answer;
        while(true) {
            try {
                System.out.println(question);
                answer = Integer.parseInt(entries.nextLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.print("He's dead, jim. Try again : ");
            }
        }
        return answer;
    }

    public void print(String question) {
        System.out.println(question);
    }

    public int random() {
        int min = 1;
        int max = 10;
        int range = max - min +1;
        int rand = (int) (Math.random() * range) + min;

        return rand;
    }

}
