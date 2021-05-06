package utils;

//Imports
import java.util.Scanner;

public class Utils {

    //Attributes
    public Scanner entries;

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

}
