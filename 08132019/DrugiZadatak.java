package cetrneastipaket;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Velicina niza 1:");
		int n = sc.nextInt();
		int[] a = new int[n];
		napraviNiz(a, "A");
		System.out.println("Velicina niza 2:");
		int m = sc.nextInt();
		int[] b = new int[m];
		napraviNiz(b, "B");
		sortiraj(a);
		sortiraj(b);
		boolean podskup = podskup(a, b);
		if (podskup)
			System.out.println("Niz A jeste podskup niza B");
		else
			System.out.println("Niz A nije podskup niza B");
	}

	static void napraviNiz(int[] a, String name) {				// pravljenje niza
		Scanner sc = new Scanner(System.in);
		System.out.printf("Unesite niz %s: \n", name);
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
	}
   static void sortiraj(int [] a) {							// sortiranje niza
	   for (int i =0; i<a.length-1; i++) {
		   for (int j =i+1; j<a.length; j++) {
			   if (a[i] > a[j]) {
				   int zamena = a[i];
				   a[i] = a[j];
				   a[j] = zamena;
			   }
		   }
	   }
   }
   static void ispisiNiz(int [] a) {
	   for (int i =0; i<a.length; i++) {
		   System.out.print(a[i] + " ");
	   }
   }

	static boolean podskup(int[] a, int[] b) {
		int dupli;
		int counter;
		boolean podskup = false;
		for (int i = 0; i < a.length; i++) {
			dupli = 1;
			podskup = false;
			for (int j=i+1; j<a.length; j++) {				// prvo brojimo duple elemente u prvom nizu
				if (a[i] == a[j]) {
					dupli++;
				}
			}
			
			counter = dupli;
			for (int j = 0; j < b.length; j++) {// gledamo koliko ima tih elemenata u drugom nizu, ako ima isto ili vise true, ako ne false
				if (a[i] == b[j]) {
					dupli--;
				}
				
			}
			if (dupli <1) {
				podskup = true;
				i += counter-1;
			}
			if (!podskup) {
				return false;
			}
		}
		return true;
	}
}
