package main;

public class Demenagement {
	public static void main (String [] args) {
		 int i = 34;
		 
		 while (i > 0) {
			 if (i > 8) {
				 System.out.print("Un voyage de 9 cartons a �t� effectu� \n");
				 
				 i = i - 9; 
			 }
			 else {
				 System.out.print("Un voyage de " + i + " cartons a �t� effectu� \n");
				 i = i - i;
			 }
		 }
	}
}