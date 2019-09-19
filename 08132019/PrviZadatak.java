package cetrneastipaket;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		do {
		System.out.println("Fibonacijev broj n: ");
		n = sc.nextInt();
		} while(n < 0 || n > 37);
		System.out.println(fibonaci(n));

	}
	static int fibonaci(int n) {
		if (n ==0) {
			return 0;
		} else if (n ==1 || n ==2) {
			return 1;
		}
		return (fibonaci(n-1) + fibonaci(n-2) + fibonaci(n-3));
	}
}
