package desetiPaket;

import java.util.Random;
import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza: ");
		int n = sc.nextInt();
		int[] niz = new int[n];
		System.out.println("Gornja granica brojeva niza: ");
		int gornjaGranica = sc.nextInt();
		nizRandomBrojevi(niz, gornjaGranica);
		System.out.println("Provera da li broj postoji u nizu: ");	
		int b = sc.nextInt();
		boolean postoji = postojiUNizu(niz, b);
		if (postoji) {
			System.out.printf("Broj %d postoji u nizu.\n", b);
		} else {
			System.out.printf("Broj %d ne postoji u nizu.\n", b);
		}
		ispisiNiz(niz);
	}

	static void nizRandomBrojevi(int[] a, int b) {	// funkcija za pravljenje niza sa random brojevima
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(b) + 1;

		}
	}

	static boolean postojiUNizu(int[] a, int b) {    // funkcija za proveru postojanja broja u nizu
		for (int i = 0; i < a.length; i++) {
			if (b == a[i]) {
				return true;
			}
		}
		return false;
	}
	static void ispisiNiz(int [] a) {				// funkcija za ispisivanje niza
		System.out.print("Niz: ");
		for (int i =0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
}
