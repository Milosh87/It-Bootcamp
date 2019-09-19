package dvanestidomaci;

import java.util.Scanner;

public class DrugiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite string: ");
		String rec = sc.nextLine();
		nizSamoglasnika(rec);
	}

	static void nizSamoglasnika(String rec) {			// funkcija koja ispisuje niz vezanih samoglasnika
		int max = 0;
		int indexMax = 0;
		for (int i = 0; i < rec.length() - 1; i++) {
			int lokalMax = 0;
			char iSlovo = rec.charAt(i);
			if (iSlovo == 'a' || iSlovo == 'e' || iSlovo == 'i' || iSlovo == 'o' || iSlovo == 'u' || iSlovo == 'A'
					|| iSlovo == 'E' || iSlovo == 'I' || iSlovo == 'O' || iSlovo == 'U') {
				lokalMax++;
				if (lokalMax > max) {
					max = lokalMax;
					indexMax = i;
				}
			} else {
				continue;
			}

			for (int j = i + 1; j < rec.length(); j++) {
				char jSlovo = rec.charAt(j);
				if (jSlovo == 'a' || jSlovo == 'e' || jSlovo == 'i' || jSlovo == 'o' || jSlovo == 'u' || jSlovo == 'A'
						|| jSlovo == 'E' || jSlovo == 'I' || jSlovo == 'O' || jSlovo == 'U') {
					lokalMax++;
					if (lokalMax > max) {
						max = lokalMax;
						indexMax = j;
					}
				} else {
					break;
				}
			}

		}
		System.out.println(rec.substring(indexMax - max + 1, indexMax + 1));
	}
}
