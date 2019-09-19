package treciDan;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		int m, n, c, sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite m: ");
		m = sc.nextInt();
		System.out.println("Unesite n: ");
		n = sc.nextInt();
		if (n < m) {				// u slucaju da je drugi broj manji od drugog, zamenjujemo varijable u kojima se nalaze
			c = m;
			m = n;
			n = c;
		}
		System.out.printf("Parni brojevi izmedju %d i %d su:\n", m, n);
		while (m <= n) {
			if (m % 2 ==0) {
				System.out.print(m + " ");
				sum+=m;
			} 
			m += 1;
		}
		System.out.println("");
		System.out.printf("Zbir unetih brojeva je: %d", sum);
		

	}

}
