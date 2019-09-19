package cetrneastipaket;

import java.util.Scanner;

public class CetvrtiZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Velicina niza: ");
		int n = sc.nextInt();
		String [] a = new String [n];
		napraviNiz(a);
		String [] zajednickiKarakteri = zajednickiKarakteri(a);
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
	static String bezDuplih(String rec) {		// funkcija koja vraca string bez duplih karaktera 
		boolean dupli = false;
		String konacni = "";
		for (int i =0; i<rec.length(); i++) {
			dupli = false;
			for (int j=i+1; j<rec.length(); j++) {
				if (rec.charAt(i) == rec.charAt(j)) {
					dupli = true;
					break;
				}
			}
			if (!dupli) {
				konacni += rec.charAt(i);
			}
		}
		return konacni;
	}
	static String []  zajednickiKarakteri(String [] a) {				// funkcija koja vraca niz zajednickih slova iz niza reci
		int brojKaraktera = 0;
		boolean flag = true;
		int counter = 0;
		String zajednicke = "";
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
					if (slovo.equals(slovo2)) {
						flag = true;
						break;
					}
					
				}
			
				
			}
			if (flag) {
				zajednicke += slovo;
			}
		}
		String konacni = bezDuplih(zajednicke);
		String [] nizSlova = new String [konacni.length()];
		for (int i=0; i<konacni.length(); i++) {
			nizSlova[i] = konacni.substring(i, i+1);
		}
		return nizSlova;
	}
}
