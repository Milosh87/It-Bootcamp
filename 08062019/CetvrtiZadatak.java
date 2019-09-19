package desetiPaket;

import java.util.Scanner;

public class CetvrtiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza n: ");
		int n = sc.nextInt();
		int [] niz = new int [n];
		napraviNiz(niz);
		boolean duplikat = duplikat(niz);
		if (duplikat) {
			System.out.println("Ima duplih elemenata u nizu");
		} else {
			System.out.println("Nema duplih elemenata u nizu");
		}

	}
	static void napraviNiz(int [] niz) {					// funkcija za pravljenje niza
		Scanner sc = new Scanner(System.in);
		for (int i =0; i < niz.length; i++) {
			System.out.printf("Upisite %d element niza: \n", i+1);
			niz[i] = sc.nextInt();
		}
	}
	static boolean duplikat(int [] niz) {					// provera da li ima duplih elemenata
		for (int i =0; i < niz.length-1; i++) {
			for (int j= i+1; j<niz.length; j++) {
				if (niz[i] == niz[j]) {
					return true;
				}
			}
		}
		return false;
	}

}
