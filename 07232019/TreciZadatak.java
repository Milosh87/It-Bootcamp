package domaci;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, jed, dec, sto, zbir;
		System.out.println("Unesite trocifren broj");
		x = sc.nextInt();
		jed = x % 10;
		dec = (x / 10) % 10;
		sto = (x / 100) % 10;
		zbir = jed + dec + sto;
		System.out.printf("Zbir cifara unetog trocifrenog broja je: %d", zbir);
	}

}
