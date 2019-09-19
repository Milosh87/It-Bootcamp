package jedanestidomaci;

import java.util.Scanner;

public class CetvrtiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = { 
				{ 1, 2, 8, 9 }, 
				{ 21, 2, 1, -105, 6 }, 
				{ 3, 3, 89, 2, 142 },
				{ 4, 12, 16},
				{ 3, 3, 89, 2, 142,105,1080}
			};
		int brojKolona = brojKolona(a);
		int n;
		do {					// ako trazimo zbir kolona koje ne postoje
		System.out.println("Suma n-te kolone niza: ");
		n = sc.nextInt();
		if (n > brojKolona || n < 0) {
			System.out.printf("Kolone su od 0 do %d\n", brojKolona);
		}
		} while (n > brojKolona || n < 0);
		int sumaKolone = sumaKolone(a, n);
		ispisKolone(a, n);
		System.out.printf("Suma kolone %d je: %d", n, sumaKolone);
	}
	
	static int brojKolona(int [][] a) {				// funkcija za maks broj kolona
		int maxBrojKolona = 0;
		for (int i =0; i<a.length; i++) {
			if (a[i].length > maxBrojKolona) {
				maxBrojKolona = a[i].length;
			}
 		}
		return maxBrojKolona-1;
	}
	
	static int sumaKolone(int [][] a, int n) {		// funkcija za sumu n-te kolone
		int sumaKolone = 0;
		for (int i=0; i<a.length; i++) {
			if (n < a[i].length) {
				sumaKolone += a[i][n];
			}
		}
		return sumaKolone;
	}
	
	static void ispisKolone(int [][] a, int b) {			// funkcija za ispis n-te kolone
		for (int i=0; i<a.length; i++) {
			if (a[i].length > b) {
			System.out.printf("[%d]\n",a[i][b]);
			}
		}
	}
	
}
