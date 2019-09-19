package sedmiDomaci;

import java.util.Scanner;

public class CetvrtakPicerija {

	public static void main(String[] args) {
		String unos;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Dobrodošli u Braško++ pametnu kasu!");
			System.out.println("Koji je danas dan (pon/uto/sre/cet/pet/sub/ned)");
			unos = sc.nextLine();
			switch (unos) {
			case "pon":
			case "sre":
			case "pet":
				kupovina(unos);
				break;
			case "uto":
				kupovina(unos);
				break;
			case "cet":
				kupovina(unos);
				break;
			case "sub":
			case "ned":
				kupovina(unos);
				break;
			default:
				System.out.println("Greska u unosu. Pokusajte ponovo: ");
			}
		} while (!unos.equals("pon") && !unos.equals("uto") && !unos.equals("sre") && !unos.equals("cet")
				&& !unos.equals("pet") && !unos.equals("sub") && !unos.equals("ned"));

	}

	static void kupovina(String unos) {
		System.out.println(unos);
		int ostali, m = 0, capricosa = 0, vesuvio = 0, popust15 = 0, ukupno = 0, pizza = 0;
		String racunIspis = " ";
		Scanner sc = new Scanner(System.in);
		while (true) {
			m++;			// counter za broj musterije
			System.out.print("Mušterija id#" + m + ": ");
			int n = sc.nextInt();
			if (n == -1) {				// izlazak iz programa na kada upisemo -1
				break;
			}
			ukupno = 0;						// resetujemo iznos i countere za popuste pre svake nove musterije
			popust15 = 0;
			vesuvio = 0;
			capricosa = 0;
			racunIspis += "- Raèun za mušteriju id#" + m + "-\n";
			for (int i = 1; i <= n; i++) {
				do {
					ostali = sc.nextInt();
				} while ((ostali < 2 || ostali > 5) || (ostali == 4));
					pizza++;			// posle svake kupljene pizze counter za pizze+1, zbog svake 7me besplatne
					if (i % 4 == 0 && ostali == 5) { // provera da li je 4ta pizza
						racunIspis += "AKCIJA 3+1 Vesuvio 0\n";
					} else if (i % 4 == 0 && ostali == 3) {
						racunIspis += "AKCIJA 3+1 Pepperoni 0\n";
					} else if (i % 4 == 0 && ostali == 2) {
						racunIspis += "AKCIJA 3+1 Capricciosa 0\n";
					} else if (pizza % 7 == 0 && ostali == 5) { // provera da li je sedma pizza
						racunIspis += "AKCIJA #7 Vesuvio 0\n";
					} else if (pizza % 7 == 0 && ostali == 3) {
						racunIspis += "AKCIJA #7 Pepperoni 0\n";
					} else if (pizza % 7 == 0 && ostali == 2) {
						racunIspis += "AKCIJA #7 Capricciosa 0\n";
					} else if ((unos.equals("sub") || unos.equals("ned")) && ostali == 2) { // subota i nedelja 15 % popusta																					
						popust15++;
						ukupno += 320;
						racunIspis += "Pizza Capricciosa 320\n";
					} else if ((unos.equals("sub") || unos.equals("ned")) && ostali == 3) {
						popust15++;
						ukupno += 290;
						racunIspis += "Pizza Pepperoni 290\n";
					} else if ((unos.equals("sub") || unos.equals("ned")) && ostali == 5) {
						popust15++;
						ukupno += 310;
						racunIspis += "Pizza Vesuvio 310\n";
					} else if (ostali == 5 && unos.equals("uto")) { // utorak popust
						ukupno += 310;
						vesuvio++;
						racunIspis += "Pizza Vesuvio 310\n";
					} else if (ostali == 2 && unos.equals("cet")) { // cetvrtak popust
						capricosa++;
						ukupno += 320;
						racunIspis += "Pizza Capricciosa 320\n";
					} else if (ostali == 2) { 					// pizze bez popusta
						ukupno += 320;
						racunIspis += "Pizza Capricciosa 320\n";
					} else if (ostali == 3) {
						ukupno += 290;
						racunIspis += "Pizza Pepperoni 290\n";

					} else if (ostali == 5) {
						ukupno += 310;
						racunIspis += "Pizza Vesuvio 310\n";
					}

				
			}

			racunIspis += "\t ukupno: " + ukupno + "\n";
			if (vesuvio > 0) {							// u slucaju da postoje popusti , racunanje popusta i ukupne cene umanjene za popust
				racunIspis += "DNEVNA 10% Vesuvio -" + vesuvio * 310 * 0.10 + "\n";				
				ukupno -= vesuvio * 310 * 0.10;
				racunIspis += "\t ukupno: " + ukupno + "\n";
			} else if (capricosa > 0) {
				racunIspis += "DNEVNA 10% Cappriciosa -" + capricosa * 320 * 0.10 + "\n";
				ukupno -= capricosa * 320 * 0.10;
				racunIspis += "\t ukupno: " + ukupno + "\n";
			} else if (popust15 > 0) {
				racunIspis += "DNEVNA 15% SVE -" + (int)(ukupno * 0.15) + "\n";
				ukupno -= (int) (ukupno * 0.15);
				racunIspis += "\t ukupno: " + ukupno + "\n";
			}
			racunIspis += "----------------------------\n";
		}
		System.out.println(racunIspis);
	}
}
