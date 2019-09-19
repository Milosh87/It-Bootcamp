package treciDan;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		int x, i = 2;					// brojac na 2 jer nema potrebe da krece od 0 ili 1
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj: ");
		x = sc.nextInt();
		while (i < x) {
			if (x % i == 0) {							
				System.out.println("Uneti broj nije prost");
				break;
			}
			i += 1;
		}
		if (i == x-1 || i == x) {							// uslov u slucaju da je loop zavrsen sa break, ili ako je i == x(u slucaju da je x = 2)
			System.out.println("Broj je prost");
		}
	}
}
