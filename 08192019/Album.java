package muzickaNumera;

import java.util.Date;

public class Album {
	private String naziv;
	private String izvodjac;
	private Date datum;
	private MuzickaNumera[] nizPesama;
	private int brojPesamaVelicina;

	public Album(String naziv, String izvodjac, Date datum) {
		super();
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
		nizPesama = new MuzickaNumera[5];
		brojPesamaVelicina = 5;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public void dodaj(MuzickaNumera x) {					// metoda za dodavane muzicke numere
		int brojacNull = 0;							// brojac koji proverava da li ima elemenata koji su null u nizu
		for (int i = 0; i < nizPesama.length; i++) {
			if (nizPesama[i] == null) {
				nizPesama[i] = x;
				brojacNull++;
				break;
			}
		}
		if (brojacNull == 0) {			// ako nema elemenata koji su null, niz je pun, pa ga povecavamo 2x
			brojPesamaVelicina *= 2;	
			MuzickaNumera[] nizPesamaNovi = new MuzickaNumera[brojPesamaVelicina];			// pravimo novi niz velicine 2x starog niza, u koji dodajemo elemente starog niza
			for (int i = 0, j = 0; i < nizPesama.length; i++, j++) {
				nizPesamaNovi[j] = nizPesama[i];
			}
			nizPesama = nizPesamaNovi;		// postavljamo referencu starog niza da pokazuje na novi
			nizPesama[brojPesamaVelicina / 2] = x;
		}
	}

	public void dodaj(String name, String trajanje) {
		MuzickaNumera x = new MuzickaNumera(name, this.izvodjac, trajanje);
		this.dodaj(x);
	}

	public String getTrajanje() {			// metoda kojom racunamo ukupno trajanje i vracamo kao string
		int minuti = 0;
		int sekunde = 0;
		int sati = 0;
		for (int i = 0; i < nizPesama.length; i++) {
			if (nizPesama[i] == null) {
				continue;
			}
			String split = "";
			String[] niz = nizPesama[i].getTrajanje().split(":");
			minuti += Integer.parseInt(niz[0]);
			sekunde += Integer.parseInt(niz[1]);

		}

		while (sekunde >= 60) {
			minuti++;
			sekunde -= 60;
		}
		while (minuti >= 60) {
			sati++;
			minuti -= 60;
		}
		if (sati > 0) {
			if(sati<10&&minuti<10&&sekunde<10) {					// returnovanje stringa u formatu xx:xx:xx
				return "0" + Integer.toString(sati) + ":0" + Integer.toString(minuti) + ":0" +Integer.toString(sekunde);
			}
			else if (sati<10&&minuti<10) {
				return "0" + Integer.toString(sati) + ":0" + Integer.toString(minuti) + ":" + Integer.toString(sekunde);
			}
			else if (sati<10&&sekunde<10) {
				return "0" + Integer.toString(sati) + Integer.toString(minuti) +Integer.toString(sekunde);
			}
			else if (minuti<10&&sekunde<10) {
				return Integer.toString(sati) + ":0" + Integer.toString(minuti) + ":0" + Integer.toString(sekunde);
			} else if (sati<10) {
				return "0" + Integer.toString(sati) + ":" + Integer.toString(minuti) + ":" +Integer.toString(sekunde);
			}			
			else {
			return Integer.toString(sati) + ":" + Integer.toString(minuti) + ":" + Integer.toString(sekunde);
			}
		} else if (minuti > 0) {
			if (minuti <10 && sekunde <10) {
				return "0" + Integer.toString(minuti) + ":0" +Integer.toString(sekunde);
			} else if (minuti<10) {
				return "0" + Integer.toString(minuti) + ":" + Integer.toString(sekunde);
			} else if (sekunde<10) {
				return Integer.toString(minuti) + ":0" + Integer.toString(sekunde);
			}
			return Integer.toString(minuti) + ":" + Integer.toString(sekunde);
		} else if (sekunde > 0) {
			if (sekunde<10) {
				return "0" + Integer.toString(sekunde);
			}
			return Integer.toString(sekunde);
		} else
			return "00:00:00";
	}

	public Date getDatum() {
		return datum;
	}

	public MuzickaNumera getMuzickaNumera(int index) {
		if (index >= 0 && index < nizPesama.length) {
			return nizPesama[index];
		} else
			return null;
	}

	public MuzickaNumera getMuzickaNumera(String ime) {			
		for (int i = 0; i < nizPesama.length; i++) {
			if (nizPesama[i] == null) {
				continue;
			}
			else if (ime.equals(nizPesama[i].getNaziv())) {
				return nizPesama[i];
			}
		}
		return null;
	}

	public String toString() {
		String ispis = "";
		ispis += this.getIzvodjac() + "-" + this.getNaziv() + "(" + this.getDatum().getYear() + ")" + ":" + "[" + "\n";
		for (int i = 0; i < nizPesama.length; i++) {
			if (nizPesama[i] != null) {
				ispis += nizPesama[i].toString() + "\n";
			}
		}
		ispis += "]: " + this.getTrajanje();
		return ispis;
	}
}
