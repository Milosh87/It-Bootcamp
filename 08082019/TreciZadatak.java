package jedanestidomaci;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int brojKaraktera;
		System.out.println("Ukucajte neku rec: ");
		String rec = sc.nextLine();
		System.out.println("Ukucajte slovo: ");
		char slovo = sc.next().charAt(0);
		brojKaraktera = brojKaraktera(rec, slovo);
		System.out.printf("Slovo %c se u reci %s pojavljuje %d puta", slovo, rec, brojKaraktera);

	}

	static int brojKaraktera(String s, char c) { // funkcija koja vraca broj slova u reci
		int brojKaraktera = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				brojKaraktera++;
			}
		}
		return brojKaraktera;
	}

}
