package cetvtidan;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		double x, sum = 0;
		boolean negative = false;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Unesite " + (i + 1) + ". broj");
			x = sc.nextDouble();
			if (x < 0) {
				negative = true;
				break;
			} else {
				sum += x;
			}
		}
		System.out.printf("Suma unetih pozitivnih brojeva je: %f\n", sum);
		if (negative) {
			System.out.println("");
			System.out.println("Process ended with code 0");
		}

	}

}
