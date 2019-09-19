package drugiDan;

import java.util.Scanner;

public class CetvrtiZadatak {

	public static void main(String[] args) {
		int x, prva, druga, treca, armCompare;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ukucajte trocifreni broj: ");
		x = sc.nextInt();
		
		// Odredjivanje prve druge i trece cifre:
		
		prva = (x/100);
		druga = (x/10)%10;
		treca = x % 10;			
					
		armCompare = prva*prva*prva + druga*druga*druga + treca*treca*treca;  // sa ovim poredimo x, da vidimo dal je armstrongov broj
		
		if (x < 100 || x > 999) {								// proveravamo da li je broj trocifren
			System.out.println("Broj nije trocifren!");
		}
		else {													// ako jeste proveravamo da li je armstrongov broj
			if (x == armCompare) {
				System.out.printf("Broj %d jeste Armstrongov.", x);
			} else {
				System.out.printf("Broj %d nije Armstrongov.", x);
			} 
		}
		
	}

}
