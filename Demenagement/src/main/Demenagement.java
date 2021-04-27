package main;

public class Demenagement {
	public static void main (String [] args) {
		int capaciteCamion = 9;
		int cartonsCamion = 0;
		int ancienLocal = 34;
		int nouveauLocal = 0;
		 
		 while (ancienLocal > 0) {
			 if (capaciteCamion > cartonsCamion && ancienLocal > 8) {
				 cartonsCamion = capaciteCamion;
				 System.out.println("Un voyage de " + cartonsCamion + " cartons a été effectué");
			 }
			 else {
				 cartonsCamion = ancienLocal;
				 System.out.println("Un voyage de " + cartonsCamion + " cartons a été effectué");
			 }
			 ancienLocal = ancienLocal - cartonsCamion;
			 nouveauLocal = nouveauLocal + cartonsCamion;
			 cartonsCamion = 0;
			 
			 System.out.println("Il reste " + ancienLocal + " cartons dans l'ancien local");
		 }
		 System.out.println("Il y a " + nouveauLocal + " cartons dans le nouveau local");
	}
}