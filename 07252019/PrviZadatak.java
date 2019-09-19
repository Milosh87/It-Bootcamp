package treciDan;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		int x, c, obrnuto = 0, pocetni;
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj: ");
		x = sc.nextInt();
		pocetni = x;

		while (x > 0) {					// menjamo redosled upisanih cifara, i stavljamo u variablu obrnuto
			c = x % 10;
			obrnuto *= 10;
			obrnuto += c;
			x /= 10;
		}
		if (obrnuto == pocetni) {										// poredimo obrnuti redosled sa pocetnom cifrom
			System.out.println("Uneti broj jeste palindrom");
		} else {
			System.out.println("Uneti broj nije palindrom");
		}

	}

}
