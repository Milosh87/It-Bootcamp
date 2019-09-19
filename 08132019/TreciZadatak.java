package cetrneastipaket;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Velicina niza: ");
		int n = sc.nextInt();
		int [] a = new int [n];
		System.out.println("Unesite niz: ");
		napraviNiz(a);
		sortirajPoParnosti(a);
		ispisiNiz(a);
	}
	static void napraviNiz(int [] a) {
		Scanner sc = new Scanner(System.in);
		for (int i =0; i<a.length; i++) {
			a[i]= sc.nextInt();
		}
	}
	static void ispisiNiz(int [] a) {
		for (int  i =0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	static void sortirajPoParnosti(int [] a) {
		for (int i =0; i<a.length-1; i++) {
			if (a[i] % 2 == 0) {
				continue;
			}
			for (int j=i+1; j<a.length; j++) {
				if (a[i] % 2 != 0 && a[j] % 2 == 0) {
					int zamena = a[i];
					a[i] = a[j];
					a[j] = zamena;
					break;
				}
			}
		}
	}

}
