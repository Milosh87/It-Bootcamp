package sedmiDomaci;

import java.util.Scanner;

public class PetakAlkotest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int id, pol, kp, zabrana;
		double tezina, bac, ml, suma = 0;
		System.out.println("Dobrodosli u alko aproksimator 9000!");
		do {
			System.out.print("Unesite vasu tezinu (kg)");
			tezina = sc.nextDouble();
		} while (tezina <= 0);
		do {
			System.out.print("Unesite vas pol (ako ste musko unesite 1, ako ste zensko unesite 0): ");
			pol = sc.nextInt();
		} while (pol != 0 && pol != 1);
		do {
			System.out.print("Unesite id pica koje ste pili ili -1 ako ste vec uneli sva pica koje ste pili: ");
			id = sc.nextInt();
			switch (id) {
			case 1:
				ml = ml();
				suma += ml * 0.50;
				break;
			case 2:
				ml = ml();
				suma += ml * 0.40;
				break;
			case 3:
				ml = ml();
				suma += ml * 0.047;
				break;
			case 4:
				ml = ml();
				suma += ml * 0.11;
				break;
			}

		} while (id != -1);
		System.out.println("----------------------------------------");
		if (pol == 1) { // racunanje BAC
			bac = (suma / (tezina * 0.55)); // muski pol
		} else {
			bac = (suma / (tezina * 0.68)); // zenski pol
		}
		if (bac > 2.0) {
			bacIspis(bac, "Potpuna alkoholisanost", "30-60 dana zatvora", "15", "9");
		} else if (bac >= 1.61 && bac <= 2.0) {
			bacIspis(bac, "Veoma teska alkoholisanost", "100.000 - 120.000", "14", "8");
		} else if (bac >= 1.21 && bac <= 1.6) {
			bacIspis(bac, "Teska alkoholisanost", "100.000-120.000", "9", "8");
		} else if (bac >= 0.81 && bac <= 1.2) {
			bacIspis(bac, "Visoka alkoholisanost", "20.000-40.000", "8", "4");
		} else if (bac >= 0.51 && bac <= 0.8) {
			bacIspis(bac, "Srednja alkoholisanost", "10.000-20.000", "6", "3");
		} else if (bac >= 0.21 && bac <= 0.5) {
			bacIspis(bac, "Umerena alkoholisanost", "10.000", "0", "0");
		} else {
			bacIspis(bac, "Dozvoljena alkoholisanost", "Bez kazne", "0", "0");
		}
	}

	static double ml() { // unos za mililitre alkohola
		Scanner sc = new Scanner(System.in);
		double m1;
		do {
			System.out.print("Unesite koliko mililitara(ml) tog pica ste popili: ");
			m1 = sc.nextDouble();
		} while (m1 < 0);
		return m1;
	}

	static void bacIspis(double bac, String alko, String kazna, String poeni, String mesec) { // ispis alko testa
		System.out.printf("BAC: %.2f - %s\n", bac, alko);
		System.out.println("----------------------------------------");
		System.out.printf("Kazna: %s\n", kazna);
		System.out.printf("Kazneni poeni: %s\n", poeni);
		System.out.printf("Zabrana voznje: %s meseci", mesec);
	}

}
