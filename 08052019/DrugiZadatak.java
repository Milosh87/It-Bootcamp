package devetiDomaci;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Velicina niza: ");
		int n = sc.nextInt();
		int [] a = new int [n];
		napraviNiz(a);
		minMax(a);
		int [] minMax = minMax(a);
		System.out.printf("%d , %d", minMax[0], minMax[1]);
	}
	static void napraviNiz(int [] niz) {			// funkcija za kreiranje niza
		Scanner sc = new Scanner(System.in);
		for (int i =0; i < niz.length; i++) {
			System.out.printf("Upisite %d. element niza: \n", i+1);
			niz[i] = sc.nextInt();
		}
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
