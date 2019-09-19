package cetrneastipaket;

import java.util.Scanner;

public class CetvrtiZadatakBoljaVerzija {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Velicina niza: ");
		int n = sc.nextInt();
		String [] a = new String [n];
		napraviNiz(a);
		System.out.print("Zajednicka slova za reci: \n");
		ispisiNiz(a);
		String [] zajednickiKarakteri = zajednickiKarakteri(a);
		System.out.println();
		ispisiNiz(zajednickiKarakteri);

	}
	
	static void ispisiNiz(String [] a) {
		for (int i =0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	
	static void napraviNiz(String [] a ) {			// funkcija za pravljenje niza
		Scanner sc = new Scanner(System.in);
		for (int i =0; i<a.length; i++) {
			a[i] = sc.next();
		}
	}

	static String []  zajednickiKarakteri(String [] a) {				// funkcija koja vraca niz zajednickih slova iz niza reci
		int brojKaraktera = 0;
		boolean flag = true;
		int counter = 0;
		String zajednicke = "";
		int index2;
		for (int i =0; i<a[0].length(); i++) {
			// slova od prve reci
			flag = true;
			String slovo = a[0].substring(i, i+1);
			for (int j =1; j<a.length; j++) {
				// reci u nizu
				if (flag) {
					flag = false;
				} else {
					break;
				}
				for (int k =0; k<a[j].length(); k++) {
					// slova u j-toj reci
					String slovo2 = a[j].substring(k, k+1);
					counter = 0;
					if (slovo.equals(slovo2)) {
						flag = true;						
						break;
					}
					
				}
			
				
			}
			if (flag) {
				zajednicke += slovo;
				for (int j =1; j<a.length; j++) {
					for (int k =0; k<a[j].length(); k++) {
						String slovo2 = a[j].substring(k, k+1);
						if (slovo.equals(slovo2)) {
							String replace = a[j].substring(0, k) + a[j].substring(k+1);
							a[j] = (a[j].substring(0, k) + a[j].substring(k+1));
							break;
						}
						
					}
				}

			}
		}
		String [] nizSlova = new String [zajednicke.length()];
		for (int i=0; i<zajednicke.length(); i++) {
			nizSlova[i] = zajednicke.substring(i, i+1);
		}
		return nizSlova;
	}
}
