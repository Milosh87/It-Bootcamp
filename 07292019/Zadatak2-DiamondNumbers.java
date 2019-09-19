package petiDomaci;

import java.util.Scanner;

public class DiamondNumbers {

	public static void main(String[] args) {
		int x, height;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		height = x;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < x - 1; j++) {
				System.out.print(" ");
			}
			boolean raste = false;
			int n = i + 1;
			for (int k = 0; k < i * 2 + 1; k++) {
				System.out.print(n);
				if (!raste) {
					n--;
				}
				if (n == 0) {
					raste = true;
					n++;
				}
				if (raste) {
					n++;
				}
			}
			x--;
			System.out.println("");
		}
		for (int i = height - 1; i > 0; i--) {
			for (int j = 0; j < x + 1; j++) {
				System.out.print(" ");
			}
			boolean raste = false;
			int n = i;
			for (int k = 0; k < i * 2 - 1; k++) {
				System.out.print(n);
				if (!raste) {
					n--;
				}
				if (n == 0) {
					raste = true;
					n++;
				}
				if (raste) {
					n++;
				}
			}
			x++;
			System.out.println("");
		}

	}

}
