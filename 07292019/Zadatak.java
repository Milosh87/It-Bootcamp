package petiDomaci;

import java.util.Scanner;

public class Zadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double cena, kolicina, ukupnaCena = 0;
		int sum = 0, kusur, i = 1, novac, kov20 = 0, kov10 = 0, kov5 = 0, kov2 = 0, kov1 = 0;
		String pitanje;
		boolean penzioner = false;
		do {
			System.out.println("Da li ste penzioner?(da-ne)");
			pitanje = sc.nextLine();
		} while (!pitanje.equals("da") && !pitanje.equals("ne"));
		if (pitanje.equals("da")) {
			penzioner = true;
		}
		do {
			System.out.printf("Unesite cenu %d. proizvoda: \n", i);
			cena = sc.nextDouble();
		} while (cena <= 0);
		do {
			System.out.printf("Unesite kolicinu %d. proizvoda: \n", i);
			kolicina = sc.nextDouble();
		} while (kolicina <= 0);
		if (kolicina > 3 && penzioner == true) {
			ukupnaCena += cena * kolicina - cena * kolicina * 0.20;
		} else if (kolicina < 3 && penzioner == false) {
			ukupnaCena += cena * kolicina;
		} else {
			ukupnaCena += cena * kolicina - cena * kolicina * 0.10;
		}
		while (true) {
			i++;
			do {
				System.out.printf("Unesite cenu %d. proizvoda ili (-1) ako nema vise proizvoda: \n", i);
				cena = sc.nextDouble();
			} while (cena < -1 || (cena > -1 && cena <= 0));
			if (cena == -1) {
				break;
			}
			do {
				System.out.printf("Unesite kolicinu %d. proizvoda: \n", i);
				kolicina = sc.nextDouble();
				if (kolicina > 3 && penzioner == true) {
					ukupnaCena += cena * kolicina - cena * kolicina * 0.20;
				} else if (kolicina < 3 && penzioner == false) {
					ukupnaCena += cena * kolicina;
				} else {
					ukupnaCena += cena * kolicina - cena * kolicina * 0.10;
				}
			} while (kolicina <= 0);
		}
		ukupnaCena = Math.round(ukupnaCena);
		System.out.printf("Ukupna cena proizvoda je: %f\n", ukupnaCena);
		System.out.println("Koliko vam je novca dao kupac?");
		novac = sc.nextInt();
		if (novac > ukupnaCena) {
			kusur = (novac - (int) ukupnaCena);
			System.out.println("Kusur: " + kusur);
			System.out.println("Da biste vratili najmanji broj kovanica potrebno je: ");
			while (kusur / 20 != 0) {
				kusur -= 20;
				kov20++;

			}
			while (kusur / 10 != 0) {
				kusur -= 10;
				kov10++;

			}
			while (kusur / 5 != 0) {
				kusur -= 5;
				kov5++;

			}
			while (kusur / 2 != 0) {
				kusur -= 2;
				kov2++;

			}
			while (kusur / 1 != 0) {
				kusur -= 1;
				kov1++;

			}
			System.out.printf("%d od 20din\n", kov20);
			System.out.printf("%d od 10din\n", kov10);
			System.out.printf("%d od 5din\n", kov5);
			System.out.printf("%d od 2din\n", kov2);
			System.out.printf("%d od 1din\n", kov1);

		} else if (ukupnaCena > novac) {
			System.out.printf("Nemate dovoljno novca, fali vam %d", ((int) ukupnaCena - novac));
		} else {
			System.out.println("Dali ste tacno novca kolko treba da platite, nemate kusur");
		}

	}
}