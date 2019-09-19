package cetvtidan;

import java.util.Scanner;

public class PrviZadatakDva {

	public static void main(String[] args) {
		double x, sum = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Unesite " + (i + 1) + ". broj");
			x = sc.nextDouble();
			if (x < 0) {
				continue;
			} else {
				sum += x;
			}
		}
		System.out.printf("Suma unetih pozitivnih brojeva je: %f", sum);

	}

}
