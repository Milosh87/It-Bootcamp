package desetiPaket;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza: ");
		int n = sc.nextInt();
		int[] niz = new int[n];
		napraviNiz(niz);
		double srednjaVrednost = srednjaVrednost(niz);
		veciOdSrednje(niz, srednjaVrednost);
		int najblizi = najbliziSrednjoj(niz, srednjaVrednost);
		System.out.printf("Broj najblizi srednjoj vrednosti %f, je broj %d\n", srednjaVrednost, najblizi);

	}

	static void napraviNiz(int[] niz) { // funkcija za pravljenje niza
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < niz.length; i++) {
			System.out.printf("Unesite %d. element niza: ", i + 1);
			niz[i] = sc.nextInt();
		}
	}

	static double srednjaVrednost(int[] niz) { // funkcija za racunanje srednje vrednosti
		int suma = 0;
		double srednjaVrednost;
		for (int i = 0; i < niz.length; i++) {
			suma += niz[i];
		}
		srednjaVrednost = suma / niz.length;
		return srednjaVrednost;
	}

	static void veciOdSrednje(int[] niz, double srednja) { // funkcija koja ispisuje sve brojeve vece od srednje
															// vrednosti
		System.out.printf("Brojevi veci od srednje vrednosti %f: ", srednja);
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] > srednja) {
				System.out.print(niz[i] + " ");
			}
		}
		System.out.println("");
	}

	static int najbliziSrednjoj(int[] niz, double srednja) { // funkcija koja vraca element najblizi srednjoj vrednosti niza
		double razlika = Math.abs(niz[0] - srednja);
		int najblizi = niz[0];
		for (int i = 1; i < niz.length; i++) {
			if (Math.abs(niz[i] - srednja) < razlika) {
				razlika = Math.abs(niz[i] - srednja);
				najblizi = niz[i];
			}
		}
		return najblizi;
	}
}
