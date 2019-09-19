package sestiDomaci;

import java.util.Scanner;

public class DomaciZadatak1 {

	public static void main(String[] args) {
		int x, y, z;
		Scanner sc = new Scanner(System.in);
		unosTekst(1);
		x = sc.nextInt();
		unosTekst(2);
		y = sc.nextInt();
		unosTekst(3);
		z = sc.nextInt();
		System.out.println(minimum(x, y, z));
	}

	static int minimum(int a, int b, int c) {
		int min;
		if (a >= b && c >= b) {
			min = b;
		} else if (b >= a && c >= a) {
			min = a;
		} else {
			min = c;

		}
		return min;
	}

	static void unosTekst(int i) {
		System.out.printf("Unesite %d. broj: ", i);
	}
}