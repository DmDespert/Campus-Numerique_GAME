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
        System.out.println(question);
        return entries.nextInt();
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
