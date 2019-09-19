package jedanestidomaci;

import java.util.Scanner;

public class PetiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Napisite neku rec: ");
		String rec = sc.nextLine().toLowerCase(); // stavljamo sva slova u lowercase
		int[] slova = brojSlova(rec);
		ispisNiza(slova);
		ispisSlova();
	}

	static int[] brojSlova(String s) { // funkcija za pravljenje niza koji broji koliko se puta razlicita slova
										// pojavljuju u reci
		int[] slova = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char slovo = s.charAt(i);
			if (slovo >= 'a' && slovo <= 'z') {
				slova[slovo - 97]++; // -97 jer po ascii tabeli mala slova idu od 97 do 122, pa da bi ih ubacili u indexe 0-25 u arrayu
			}
		}
		return slova;
	}

	static void ispisNiza(int[] niz) { // funkcija koja ispisuje niz
		for (int i = 0; i < niz.length; i++) {
			if (i == niz.length - 1) {
				System.out.print(niz[i]);
			} else
				System.out.print(niz[i] + ",");
		}
		System.out.println();
	}

	static void ispisSlova() { // funkcija za ispis svih slova od a-z
		for (int i = 0; i <= 25; i++) {
			if (i != 25) {
				System.out.print((char) (i + 97) + ",");
			} else {
				System.out.print((char) (i + 97));
			}
		}
	}
}
