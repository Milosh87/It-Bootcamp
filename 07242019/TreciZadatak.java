package drugiDan;

import java.util.Scanner;

public class TreciZadatak {

	// Zadatak resen koristeci switch

	public static void main(String[] args) {
		String figura;
		double x, y, r, p, o;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ukucajte ime figure(kvadrat, pravougaonik, krug): ");
		figura = sc.nextLine();
		switch (figura) {
		case "kvadrat":
			System.out.println("Unesite duzinu stranice: ");
			x = sc.nextDouble();
			p = x * x;
			o = 4 * x;
			System.out.printf("Povrsine figure je %f, a obim je %f", p, o);
			break;
		case "pravougaonik":
			System.out.println("Unesite duzinu jedne stranice: ");
			x = sc.nextDouble();
			System.out.println("Unesite duzinu druge stranice: ");
			y = sc.nextDouble();
			p = x * y;
			o = 2 * (x + y);
			System.out.printf("Povrsine figure je %f, a obim je %f", p, o);
			break;
		case "krug":
			System.out.println("Unesite poluprecnik kruga: ");
			r = sc.nextDouble();
			p = r * r * Math.PI;
			o = 2 * r * Math.PI;
			System.out.printf("Povrsine figure je %f, a obim je %f", p, o);
			break;
		default:
			System.out.println("Pogresan unos");
		}

	}

}
