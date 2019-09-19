package domaci;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, c, avg;
		System.out.println("Unesite prvi broj: ");
		a = sc.nextDouble();
		System.out.println("Unesite drugi broj: ");
		b = sc.nextDouble();
		System.out.println("Unesite treci broj: ");
		c = sc.nextDouble();
		avg = (a + b + c) / 3;
		System.out.printf("Srednja vrednost unetih brojeva je: %f", avg);

	}

}
