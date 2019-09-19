package sestiDomaci;

import java.util.Scanner;

public class DomaciZadatak2 {
	public static void main(String[] args) {
		double k, n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Upisite N: ");
		k = sc.nextInt();
		System.out.println("Upisite K: ");
		n = sc.nextInt();
		System.out.println(weirdSum(k, n));

	}

	static double weirdSum(double n, double k) {
		double sum = 0;
		for (int i = 1; i <= n + 1; i++) {
			sum += i / k;
			k++;
		}
		return sum;
	}
}
