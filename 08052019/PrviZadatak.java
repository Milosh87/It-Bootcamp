package devetiDomaci;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Niz od n: ");	
		 n = sc.nextInt();
		System.out.println("Do m: ");
		 m = sc.nextInt();
		} while (n > m);			
		int[] a = new int[m-n];
		napraviNiz(a);
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
}
