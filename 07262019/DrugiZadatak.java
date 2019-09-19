package cetvtidan;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, c, broj, max = 0;
		System.out.println("Unesite broj N: ");
		x = sc.nextInt();
		broj = x;
		while (x > 0) {					//  loop u kojem poredimo pojedinacne cifre sa maksimumom, dok ne dodjemo do 9 ili poslednje cifre u broju
			c = x%10;					
			if (c == 9) {				// ako je 9, izlazimo iz loopa jer je 9 maksimum
				max = c;
				break;
			} else if (c > max) {
				max = c;
			}
			x /=10;
		}
		System.out.printf("Najveca cifra broja %d je: %d", broj, max);

	}

}
