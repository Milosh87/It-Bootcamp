package nasledjivanjeDomaci;

import java.time.LocalDate;

public class Album {
	private String naziv;
	private String izvodjac;
	private LocalDate datum;
	private Numera[] lista;

	public Album(String naziv, String izvodjac, LocalDate datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
		this.lista = new Numera[10];
	}

	public void dodaj(Numera x) {
		boolean pun = true;
		int duzina = lista.length;
		for (int i = 0; i < duzina; i++) {
			if (lista[i] == null) {
				lista[i] = x;
				pun = false;
				break;

			}
		}
		if (pun) {
			Numera[] novaLista = new Numera[duzina * 2];
			for (int i = 0; i < duzina; i++) {
				novaLista[i] = lista[i];
			}
			novaLista[duzina] = x;
			lista = novaLista;
		}

	}
	public void dodaj(String name, String trajanje) {
		this.dodaj(new Numera(name, this.izvodjac, trajanje));
	}

	public String getNaziv() {
		return naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public String getTrajanje() {
		int minuti = 0;
		int sekunde = 0;
		int sati = 0;
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == null) {
				continue;
			}
			String[] niz = lista[i].getTrajanje().split(":");
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
	public Numera getNumera(int n) {
		if (n>=0 && n <lista.length) {
			return lista[n];
		} else return null;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(izvodjac + " - " + naziv+"(" + datum.getYear() + "):" + "[\n");
		for (int i=0;i<lista.length; i++) {
			sb.append("\t" + lista[i] + "\n");
		}
		sb.append("]:" + getTrajanje());
		return sb.toString();
	}
	
}
