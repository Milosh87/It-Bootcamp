package petiDomaci;

import java.util.Scanner;

public class Zadatak2 {

	public static void main(String[] args) { // ni sam ne znam kako sam uradio ovo, trial / error uglavnom
		int x, height;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		height = x;
		for (int i = 0; i < height; i++) { 			
			for (int j = 0; j < x - 1; j++) {	
				System.out.print(" ");
			}
			for (int k = 0; k < i * 2 + 1; k++) {		
				System.out.print("*");
			}
			x--;
			System.out.println("");
		}
		for (int i = height - 1; i > 0; i--) {
			for (int j = 0; j < x + 1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i * 2 - 1; k++) {
				System.out.print("*");
			}
			x++;
			System.out.println("");
		}

	}
}