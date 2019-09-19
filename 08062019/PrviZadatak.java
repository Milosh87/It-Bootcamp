package desetiPaket;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza: ");
		n = sc.nextInt();
		int[] a = new int[n];
		napraviNiz(a);
		System.out.println("Provera da li broj postoji u nizu: ");
		int broj = sc.nextInt();
		boolean postoji = postojiUNizu(a, broj);
		if (postoji) {
			System.out.printf("Broj %d postoji u nizu.", broj);
		} else {
			System.out.printf("Broj %d ne postoji u nizu.", broj);
		}

	}

	static void napraviNiz(int[] niz) { // funkcija za pravljenje niza
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < niz.length; i++) {
			System.out.printf("Unesite %d. element niza: ", i + 1);
			niz[i] = sc.nextInt();
		}
	}

	static boolean postojiUNizu(int[] niz, int broj) { // funkcija koja proverava da li element postoji u nizu
		for (int i = 0; i < niz.length; i++) {
			if (broj == niz[i]) {
				return true;
			}
		}
		return false;
	}

}
