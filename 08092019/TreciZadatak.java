package dvanestidomaci;

import java.util.Scanner;

public class TreciZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite rec: ");
		String rec = sc.nextLine();
		String kompresovan = kompresuj(rec);
		System.out.println(kompresovan);
	}

	static String kompresuj(String rec) {		// funkcija za kompresovanje stringa
		String kompresovan = "";
		if (rec.length() == 1) {			// u slucaju da je rec samo jedno slovo, vracamo to isto slovo
			System.out.println(rec);
		}
		for (int i = 0; i < rec.length() - 1; i++) {
			int zaRedom = 1;
			for (int j = i + 1; j < rec.length(); j++) {	
				if (rec.charAt(i) != rec.charAt(j)) { // kada i i j nisu jednaki
					if (zaRedom <= 3) { // u slucaju da imamo manje od 3 za redom
						kompresovan += rec.substring(i, i + zaRedom);
						i = j - 1;
						if (i == rec.length() - 2) {
							kompresovan += rec.charAt(rec.length() - 1);
						}
						break;
					} else { // kada imamo vise od 3 za redom
						kompresovan += rec.charAt(i) + "(" + (zaRedom) + ")";
						i = j - 1;
						if (i == rec.length() - 2) {
							kompresovan += rec.charAt(rec.length() - 1);
						}
						break;
					}
				} else { // kad su i i j jednaki
					zaRedom++;
					if (j == rec.length() - 1) { // izuzteak kad se stigne do kraja
						if (zaRedom <= 3) {
							kompresovan += rec.substring(i, i + zaRedom);
							i = j - 1;
							break;
						} else {
							kompresovan += rec.charAt(i) + "(" + (zaRedom) + ")";
							i = j - 1;
							break;
						}
					}
				}

			}

		}
		return kompresovan;
	}
}
