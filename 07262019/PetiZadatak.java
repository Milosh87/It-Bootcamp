package cetvtidan;

import java.util.Scanner;

public class PetiZadatak {

	public static void main(String[] args) {
		int n, treci = 0, prvi = 1, drugi = 1, i = 2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite koji Fibonacijev broj zelite: ");
		n = sc.nextInt();
		while (n <= 0) { // u slucaju da je broj negativan ili nula, opet trazimo broj
			System.out.println("Unesite koji Fibonacijev broj zelite: ");
			n = sc.nextInt();
		}
		while (i < n) { // racunamo trecu cifru, i onda menjamo mesta ciframa
			treci = prvi + drugi;
			prvi = drugi;
			drugi = treci;
			i++;
		}
		if (n == 1) { // brojevi 1 i 2 ne prolaze kroz while loop, pa su u if / else if kao izuzeci, a sve ostalo prodje kroz loop u else
			System.out.printf("%d. Fibonacijev broj je: %d", n, prvi);
		} else if (n == 2) {
			System.out.printf("%d. Fibonacijev broj je: %d", n, drugi);
		} else {
			System.out.printf("%d. Fibonacijev broj je: %d", n, treci);
		}
	}

}
