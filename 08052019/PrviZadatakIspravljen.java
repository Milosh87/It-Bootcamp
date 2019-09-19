package devetiDomaci;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		int n, m, v;
		Scanner sc = new Scanner(System.in);
		System.out.println("Duzina niza: ");	
		v = sc.nextInt();		
		int[] a = new int[v-1];
		napraviNiz(a);
		int [] minMax = minMax(a);
		n = minMax[0];
		m = minMax[1];
		int suma = suma(n, m);
		int nedostaje = nedostaje(a, suma);
		System.out.println(nedostaje);
		
	}
	static void napraviNiz(int [] niz) {				// funkcija za upisivanje brojeva u niz
		Scanner sc = new Scanner(System.in);
		for (int i =0; i < niz.length; i++) {
		System.out.println("Upisite element: ");
		niz[i] = sc.nextInt();
		}
	}
	static int suma(int n, int m) {						// funkcija sume brojeva od n do m
		int suma = 0;
		for (int i = n; i <= m; i++) {
			suma += i;
		}
		return suma;
	}
	static int nedostaje(int [] niz, int suma) {		// funkcija koja pronalazi broj koji fali u nizu od n - m
		int sumaNiz = 0;
		for (int i =0; i<niz.length; i++) {
			sumaNiz += niz[i];
		}
		return suma - sumaNiz;
	}
	static int[] minMax(int [] niz) {				// funkcija za pronalazenje minimalnog i maksimalnog broja u unetom nizu, i vracanje u formatu [min, max]
		int min = niz[0];
		int max = niz[0];
		for (int i =1; i < niz.length; i++) {
			if (min > niz[i]) {
				min = niz[i];
			}
			if (max < niz[i]) {
				max = niz[i];
			}
		}
		int [] minMax = new int [2];
		minMax[0] = min;
		minMax[1] = max;
		return minMax;
	}
}
