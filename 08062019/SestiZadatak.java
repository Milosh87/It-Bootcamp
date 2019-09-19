package desetiPaket;

import java.util.Scanner;

public class SestiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj elemenata prvog niza: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		napraviNiz(a);
		int m = sc.nextInt();
		int[] b = new int[m];
		napraviNiz(b);
		int brojDuplih = brojDuplih(a, b);
		int [] unija = unija(a,b, brojDuplih);
		sortirajNiz(unija);
		ispisiNiz(a, "Niz a: ");
		ispisiNiz(b, "Niz b: ");
		ispisiNiz(unija, "Sortirana unija a i b bez duplih elemenata: ");						
	}
	static void napraviNiz(int[] a) {									// funkcija za pravljenje niza
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			System.out.printf("Upisite %d element niza: ", i + 1);
			a[i] = sc.nextInt();
		}
	}
	
	static int [] unija(int[] a, int [] b, int broj) {					// funkcija za uniju 2 niza
		int [] ab = new int [a.length + b.length];
		int [] krajnji = new int [a.length + b.length - broj];
		int k =0;
		for (int i=0; i<a.length; i++) {
			ab[k] = a[i];
			k++;
		}

		for (int i =0; i<b.length; i++) {
			ab[k] = b[i];
			k++;
		}
		k =0;
		boolean dupli = false;
		for (int i =0,  h =0; i < ab.length; i++) {			
			for (int j= i+1; j<ab.length; j++) {
				if (ab[i] == ab[j]) {
					dupli = true;
				} 
			}
			if (!dupli) {
				krajnji[h] = ab[i];
				h++;
			}
			dupli = false;
		}

		
		return krajnji;
	}
	static int brojDuplih(int[] a, int [] b) {						// funkcija koja broji duple elemente u dva niza
		int [] ab = new int [a.length + b.length];
		int k =0;
		int brojDuplih=0;
		for (int i=0; i<a.length; i++) {
			ab[k] = a[i];
			k++;
		}

		for (int i =0; i<b.length; i++) {
			ab[k] = b[i];
			k++;
		}
		for (int i =0; i < ab.length-1; i++) {			
			for (int j= i+1; j<ab.length; j++) {
				if (ab[i] == ab[j]) {
					brojDuplih++;
					break;
				} 
			}

		}
		return brojDuplih;
	}
	static void sortirajNiz(int [] a) {								// funkcija za sortiranje niza
		for (int i =0; i<a.length-1; i++) {
			for (int j = i+1; j<a.length; j++) {
				if (a[i] > a[j]) {
					int zamena = a[i];
					a[i] = a[j];
					a[j] = zamena;
				}
			}
		}
	}
	static void ispisiNiz(int [] a, String text) {					// ispis niza
		System.out.print(text);
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
}
