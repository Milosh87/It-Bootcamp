package drugiDan;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		int x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ukucajte godinu: ");
		x = sc.nextInt();
		if (x % 4 == 0 && (x % 100 != 0 || x % 400 == 0)) {
			System.out.printf("%d. jeste prestupna godina", x);
		} else {
			System.out.printf("%d. nije prestupna godina", x);
		}

	}

}
