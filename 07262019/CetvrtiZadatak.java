package cetvtidan;

import java.util.Scanner;

public class CetvrtiZadatak {

	public static void main(String[] args) {
		int x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite stranicu kvadrata: ");
		x = sc.nextInt();
		while (x <= 0) { 
			System.out.println("Unesite stranicu kvadrata: ");
			x = sc.nextInt();
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

}
