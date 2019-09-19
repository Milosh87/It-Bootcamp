package jmbg;

public class Student {
	private String potpis;
	private String jmbg;
	Ocena[] upisaneOcene;

	public Student(String potpis, String jmbg, Ocena [] upisaneOcene) {

		this.potpis = potpis;
		this.jmbg = jmbg;
		this.upisaneOcene = upisaneOcene;


	}

	public void dodajOcenu(Ocena x) {				// ova metoda nije bila potrebna al sam dodao da vezbam / testiram zadatak
		if (x == null) {
			return;
		}
		int duzinaNiza = upisaneOcene.length;
		boolean punNiz = true;
		for (int i = 0; i < duzinaNiza; i++) {
			if (upisaneOcene[i] == null) {
				upisaneOcene[i] = x;
				punNiz = false;
				break;
			}
		}
		if (punNiz) {
			Ocena[] upisaneOceneNovi = new Ocena[duzinaNiza * 2];
			for (int i = 0; i < duzinaNiza; i++) {
				upisaneOceneNovi[i] = upisaneOcene[i];
			}
			upisaneOceneNovi[duzinaNiza] = x;
			upisaneOcene = upisaneOceneNovi;
		}
	}

	public String getPotpis() {
		return potpis;
	}

	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Ocena[] getUpisaneOcene() {
		return upisaneOcene;
	}

	public void setUpisaneOcene(Ocena[] upisaneOcene) {
		this.upisaneOcene = upisaneOcene;
	}

	public double getProsecnaOcena() {
		double sum = 0;
		int brojacOcena = 0;
		for (int i = 0; i < upisaneOcene.length; i++) {
			if (upisaneOcene[i] != null && upisaneOcene[i].getOcena() > 5) {
				sum += upisaneOcene[i].getOcena();
				brojacOcena++;
			}
		}
		return sum / brojacOcena;
	}

	public String getDatumRodjenja() {
		for (int i = 0; i < jmbg.length(); i++) {
			if (jmbg.charAt(i) < '0' || jmbg.charAt(i) > '9') {
				return "JMBG sadrzi karaktere koji nisu brojevi";
			}
		}

		if (jmbg.length() != 13) {
			return "JMBG je lose duzine";
		} else {
			int dan = Integer.parseInt(jmbg.substring(0, 2));
			int mesec = Integer.parseInt(jmbg.substring(2, 4));
			int godina = Integer.parseInt(jmbg.substring(4, 7));
			
			String danRec;
;			String mesecRec;
			if (dan <10) {
				danRec = "0" + Integer.toString(dan);
			} else danRec = Integer.toString(dan);			
			if (mesec <10) {
				mesecRec = "0" + Integer.toString(mesec);
			} else mesecRec = Integer.toString(mesec);
			
			if (godina >= 0 && godina < 10) {
				return danRec + "." + mesecRec + ".200" + godina;				// stavio sam da su JMBG od 1900 do 1999 i od 2000 do 2900
			} else if (godina >= 10 && godina < 100) {
				return danRec + "." + mesecRec + ".20" + godina;
			} else if (godina >= 100 && godina < 900) {
				return danRec + "." + mesecRec + ".2" + godina;
			} else {
				return danRec + "." + mesecRec + ".1" + godina;
			}			
			
	
		}
	}

	public String getIme() {
		String[] niz = potpis.split(" ");
		return niz[0];
	}

	public String getPrezime() {
		String[] niz = potpis.split(" ");
		return niz[1];
	}

	String najboljaOcena() {
		Ocena best = null;
		for (int i = 0; i < upisaneOcene.length; i++) { // prvo proveravamo da li postoje ocene u nizu, ako postoje
														// postavljamo pocetnu najbolju na prvu na koju naidjemo
			if (upisaneOcene[i] != null) {
				best = upisaneOcene[i];
				break;
			}
		}
		if (best == null) { // ako u nizu postoje samo null vrednosti, vracamo null
			return null;
		}

		for (int i = 0; i < upisaneOcene.length; i++) {
			if (upisaneOcene[i] != null && best.getOcena() < upisaneOcene[i].getOcena()) {
				best = upisaneOcene[i];
			}
		}
		return best.getPr().getIme();
	}

	static boolean starijiOd(Student s, int god) {
		if (s == null) {
			return false;
		}
		int godina = Integer.parseInt(s.getJmbg().substring(4, 7));
		if (godina < 900 && godina >=0) {				// od 0 -900 sam stavio 2000++ godiste
			return (2019 - 2000 - godina >= god);
		} else											// od 900 do 999 1000++
			return (2019 - 1000 - godina >= god);

	}
	static Student [] prosekVeciOd(Student[ ] nizStudenata, double ocena) {
		Student [] niz = new Student[5];
		
		for (int i =0; i<nizStudenata.length; i++) {
			if(nizStudenata[i] != null && nizStudenata[i].getProsecnaOcena() > ocena) {
				boolean punNiz = true;
				int duzina = niz.length;
				for (int j = 0; j < duzina; j++) {
					if (niz[j] == null) {
						niz[j] = nizStudenata[i];
						punNiz = false;
						break;
					}
				}
				if (punNiz) {
					Student [] nizNovi = new Student[duzina * 2];
					for (int j = 0; j < duzina; j++) {
						nizNovi[j] = niz[j];
					}
					nizNovi[duzina] = nizStudenata[i];
					niz = nizNovi;
				}
			}
		}
		int brojacNull=0;						// ovo sam pravio da mi vraca niz bez null elemenata, mozda je suvisno jer kad citam mogu da stavim da mi skipuje null, al eto da vezbam :D
		for (int i =0; i<niz.length; i++) {
			
			if (niz[i] == null) {
				brojacNull++;
			}
		}
		Student [] noviNiz = new Student[niz.length-brojacNull];			
		for (int i =0; i<niz.length; i++) {
			if (niz[i] != null) {
				noviNiz[i] = niz[i];
			}
		}
		
		
		return noviNiz;
		
		
	}

}
