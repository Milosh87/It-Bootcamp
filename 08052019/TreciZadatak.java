package devetiDomaci;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		double aritmetickaSredina, medijana;
		while (true) {
			System.out.println("Koje velicine niz zelite (-1 ako zelite da ugasite program): ");
			n = sc.nextInt();
			if (n == -1) {
				break;
			}
			int[] niz = new int[n];
			napraviNiz(niz);
			sortiraj(niz);
			aritmetickaSredina = aritmetickaSredina(niz);
			medijana = medijana(niz);
			ispisRez("Aritmeticka sredina: ", aritmetickaSredina);
			ispisRez("Medijana: " , medijana);
		}
	}

	static void napraviNiz(int[] niz) {						// funkcija za pravljenje niza
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < niz.length; i++) {
			System.out.printf("Upisite %d. element niza: \n", i+1);
			niz[i] = sc.nextInt();
		}
	}

	static double aritmetickaSredina(int[] niz) {			// funkcija za racunanje aritmeticke sredine
		double suma = 0;
		for (int i = 0; i < niz.length; i++) {
			suma += niz[i];
		}
		return suma / niz.length;
	}

	static void sortiraj(int[] niz) {						// funkcija za soritranje niza
		for (int i = 0; i < niz.length - 1; i++) {
			for (int j = i+1; j < niz.length; j++) {
				if (niz[i] > niz[j]) {
					int zamena = niz[i];
					niz[i] = niz[j];
					niz[j] = zamena;
				}
			}
		}
	}
	static double medijana(int [] niz) {					// funkcija za racunanje medijane niza
		int polovina = niz.length/2;
		if (niz.length%2 ==0) {
			return (double)(niz[polovina-1] + niz[polovina])/2;
			
		} else {
			return niz[(polovina)];
		}
	}
	static void ispisRez(String text, double broj) {		// funkcija za ispisivanje rezultata
		System.out.println(text + broj);
	}

}
