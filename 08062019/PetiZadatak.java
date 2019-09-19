package desetiPaket;

import java.util.Scanner;

public class PetiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		napraviNiz(a);
		int uzastopni = ukupnoUzastopnih(a);
		int[] parniNiz = podnizParnih(a, uzastopni);		
		ispisiNiz(parniNiz);
	}

	static void napraviNiz(int[] a) { // funkcija za pravljenje niza
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("Upisite %d. element niza: ", i + 1);
			a[i] = sc.nextInt();
		}
	}

	static int ukupnoUzastopnih(int[] a) { // funkcija koja vraca najveci broj uzastopnih parnih brojeva
		int ukupnoParnih = 0;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			ukupnoParnih = 0; // broj parnih za redom se stalno resetuje na 0 na pocetku
			if (a[i] % 2 != 0) {
				continue; // ukoliko nije parni idemo odmah na sledecu iteraciju
			} else {
				ukupnoParnih++;
			}
			if (ukupnoParnih > max) {
				max = ukupnoParnih;
			}
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] % 2 != 0) {
					break;
				} else {
					ukupnoParnih++;
				}
				if (ukupnoParnih > max) {
					max = ukupnoParnih;
				}

			}
		}
		return max;
	}

	static void ispisiNiz(int[] a) { // funkcija za printovanje elemenata niza
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static int[] podnizParnih(int[] a, int max) {	//kreiranje podniza najveceg podniza parnih brojeva, i returnovanje tog podniza u main
		int ukupnoParnih = 0;
		boolean izlaz = false;
		int[] parniNiz = new int[max];
		for (int i = 0; i < a.length; i++) {
			ukupnoParnih = 0;
			if (a[i] % 2 != 0) {
				continue;
			} else {
				ukupnoParnih++;
			}
			if (ukupnoParnih > max) {
				max = ukupnoParnih;
			}
			if (izlaz) {
				break;
			}
			if (ukupnoParnih == max) {
				int r = i;
				for (int k = max - 1; k >= 0; k--) {
					parniNiz[k] = a[r];
					r--;
					izlaz = true;
				}
				if (izlaz) {
					break;
				}
			}
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] % 2 != 0) {
					break;
				} else {
					ukupnoParnih++;
				}
				if (ukupnoParnih == max) {
					int r = j;
					for (int k = max - 1; k >= 0; k--) {
						parniNiz[k] = a[r];
						r--;
						izlaz = true;
					}
					if (izlaz) {
						break;
					}
				}

			}
		}
		return parniNiz;
	}

}
