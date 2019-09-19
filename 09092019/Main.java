package domaciKlase;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj objekata");
		int brojObjekata = sc.nextInt();
		sc.nextLine();
		Osoba [] grupaOsoba =  new Osoba [brojObjekata];
		for(int i=0; i<grupaOsoba.length; i++) {			
				System.out.println("Unesite ime: ");
				String ime = sc.nextLine();
				System.out.println("Unesite prezime: ");
				String prezime = sc.nextLine();
				System.out.println("Unesite adresu: ");
				String adresa = sc.nextLine();
				int n;
				do {
				System.out.println("Unesite 1 ako znate datum rodjenja, 2 ako znate JMBG");
				n = sc.nextInt();
				sc.nextLine();
				} while (n != 2 && n != 1);				
				switch(n) {
				case 1:
					boolean provera=false;
					String datum;
					do {
					System.out.println("Unesite datum u formatu dd.mm.gggg.");
					datum = sc.nextLine();
					provera = proveraDatuma(datum);
					if(!provera) {
						System.out.println("Ukucali ste datum u losem formatu, pokusajte opet");
					}
					} while(!provera);
					Datum d = new Datum(Integer.parseInt(datum.substring(0, 2)), Integer.parseInt(datum.substring(3, 5)), Integer.parseInt(datum.substring(6, 10)));
					grupaOsoba[i] = new OsobaD(ime,prezime,adresa, d);
					break;
				case 2:
					boolean proverajmbg;
					String jmbg;
					do {
						do {
					System.out.println("Unesite jmbg: ");
					jmbg = sc.nextLine();
					if(jmbg.length()!=13) {
						System.out.println("Jmbg mora sadrzati 13 cifara");
					}
						}while(jmbg.length()!=13);
					String jmbgDatum = jmbg.substring(0,2) + "." + jmbg.substring(2, 4) + ".1" + jmbg.substring(4, 7)+".";
					proverajmbg = proveraDatuma(jmbgDatum);
					if(!proverajmbg) {
						System.out.println("Ukucali ste JMBG u losem formatu, pokusajte opet");
					}				
				}while(!proverajmbg);
					grupaOsoba[i] = new OsobaJMBG(ime, prezime, adresa, jmbg);
					break;
			}

	}
		String danasnjiDatum;
		boolean provera;
		do {
			System.out.println("Unesite danasnji datum(format dd.mm.gggg.): ");
			danasnjiDatum = sc.nextLine();
			provera = proveraDatuma(danasnjiDatum);			
		} while(!provera);
		Datum danas = new Datum(Integer.parseInt(danasnjiDatum.substring(0, 2)), Integer.parseInt(danasnjiDatum.substring(3, 5)), Integer.parseInt(danasnjiDatum.substring(6, 10)));
		for(int i=0; i<grupaOsoba.length; i++) {
			System.out.print(grupaOsoba[i] + " Numeroloski broj: " + grupaOsoba[i].numeroloskiBroj());
			if (grupaOsoba[i].numeroloskiBroj() != 7 && !danasnjiDatum.contains("0")) {
				System.out.print(" trouglici: " + grupaOsoba[i].metabolizam(danas));
			}
			System.out.println();
		}
		
	}
	public static boolean proveraDatuma(String datum) {
		if(datum.length() != 11) {
			return false;
		}
		if(datum.charAt(2) != '.' || datum.charAt(5) != '.'|| datum.charAt(10) != '.') {
			return false;
		}
		int brojevi=0;
		for (int i =0; i<datum.length(); i++) {
			if(datum.charAt(i) >='0' && datum.charAt(i) <='9') {
				brojevi++;
			}
		}
		if(brojevi!=8) {
			return false;
		}
		int dan = Integer.parseInt(datum.substring(0, 2));
		int mesec = Integer.parseInt(datum.substring(3, 5));
		int godina = Integer.parseInt(datum.substring(6, 10));
		if (dan <=0 || dan >=32) {
			return false;
		}
		if (mesec <=0 || mesec >=13) {
			return false;
		}
		if (godina <0) {
			return false;
		}
		boolean prestupna = false;
		if(godina % 400 == 0) {
			prestupna = true;
		}
		else if (godina % 100 != 0 && godina % 4 == 0) {
			prestupna = true;
		} 
		else {
			prestupna =  false;
		}
		switch(mesec) {
		case 2:
			if(prestupna) {
				if(dan>29) {
					return false;
				}
			}
			else {
				if(dan > 28) {
					return false;
				}
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(dan >30) {
				return false;
			}
			break;
		}
		return true;
		
		
	}

}
