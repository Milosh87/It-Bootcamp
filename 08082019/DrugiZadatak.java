package jedanestidomaci;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		int[][] a = { 
				{ 1, 2, 8, 9 }, 
				{ 21, 2, 1, -105, 6 }, 
				{ 3, 3, 89, 2, 142 },
				{4, 12, 16}
			};
		n = kojiRed(a);
		int suma = sumaReda(a, n);
		ispisReda(a, n);
		System.out.printf("Suma %d reda je: %d",n, suma);
	}
	
	static int sumaReda(int [][] a, int n) {			// funkcija koja racuna sumu n-tog reda niza
		int suma = 0;
		for (int i =n; i<=n; i++) {
			for (int j=0; j<a[i].length; j++) {
				suma += a[i][j];
			}
		}
		return suma;
	}
	
	static int kojiRed(int a[][]) {				// funkcija za biranje broja reda, i provera da li je uneta cifra dobra
		int n;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Zelite sumu reda n: ");
			n = sc.nextInt();
			if (n > a.length-1 || n<0) {
				System.out.printf("Izaberite broj izmedju 0 i %d\n", a.length-1);
			}
			} while (n > a.length-1 || n<0);
		return n;
	}
	
	static void ispisReda (int [][] a, int n) {				// funkcija za ispis n-tog reda niza
		System.out.printf("Red %d:\n", n);
		System.out.print("[");
		for (int i=n; i<=n; i++) {
			for(int j =0; j<a[i].length;j++) {
				if (j == a[i].length-1) {
					System.out.print(a[i][j]);
				} else {
				System.out.print(a[i][j] + ", ");
				}
			}
			System.out.print("]\n");
		}
	}
}
