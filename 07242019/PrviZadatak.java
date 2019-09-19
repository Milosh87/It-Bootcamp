package drugiDan;

import java.util.Scanner;

public class PrviZadatak {

	// Zadatak uradjen koristeci if / else if / else

	public static void main(String[] args) {
		int broj, ostaloDana;
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesti broj dana(1-7): ");
		broj = sc.nextInt();
		ostaloDana = 6 - broj; // broj dana do vikenda
		if (broj == 1) {
			System.out.printf("Ponedeljak, do vikenda je ostalo cak %d dana :(", ostaloDana);
		} else if (broj == 2) {
			System.out.printf("Utorak, do vikenda je ostalo cak %d dana :(", ostaloDana);
		} else if (broj == 3) {
			System.out.printf("Sreda, do vikenda je ostalo cak %d dana :(", ostaloDana);
		} else if (broj == 4) {
			System.out.printf("Cetvrtak, do vikenda je ostalo jos samo %d dana!", ostaloDana);
		} else if (broj == 5) {
			System.out.printf("Petak, do vikenda je ostao jos samo %d dan!", ostaloDana);
		} else if (broj == 6) {
			System.out.printf("Subota");
		} else if (broj == 7) {
			System.out.printf("Nedelja");
		} else {
			System.out.println("Pogresan unos");
		}

	}

}
