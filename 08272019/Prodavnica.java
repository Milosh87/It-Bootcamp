package nasledjivanjeDomaci;

public class Prodavnica {
	private String ime;
	private String lokacija;
	private Artikal[] inventar;

	public Prodavnica(String ime, String lokacija) {
		super();
		this.ime = ime;
		this.lokacija = lokacija;
		this.inventar = new Artikal[10];
	}

	public Artikal[] pretrazi(String tekst) {
		int brojacArtikala = 0;
		for (int i = 0; i < inventar.length; i++) {
			if (inventar[i] != null && inventar[i].ime().toLowerCase().contains(tekst.toLowerCase())) {
				brojacArtikala++;
			}
		}
		Artikal[] sadrziTekst = new Artikal[brojacArtikala];
		for (int i = 0, j = 0; i < inventar.length; i++) {
			if (inventar[i] != null && inventar[i].ime().toLowerCase().contains(tekst.toLowerCase())) {
				sadrziTekst[j] = inventar[i];
				j++;
			}
		}
		return sadrziTekst;
	}
	public void dodaj(Artikal x) {
		boolean pun = true;
		int duzinaNiza = inventar.length;
		for (int i=0; i<duzinaNiza; i++) {
			if (inventar[i] == null) {
				inventar[i] = x;
				pun = false;
				break;
			}
		}
		if (pun) {
			Artikal [] noviNiz = new Artikal[2*duzinaNiza];
			for (int i=0; i<duzinaNiza; i++) {
				noviNiz[i] = inventar[i];
			}
			noviNiz[duzinaNiza] = x;
			inventar = noviNiz;
		}
	}

	public String getIme() {
		return ime;
	}

	public String getLokacija() {
		return lokacija;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime + ": " + lokacija + " [\n");
		for (int i=0; i<inventar.length; i++) {
			if (inventar[i] != null) {
				sb.append("\t" + inventar[i] + "\n");
			}
			
		}
		sb.append("]");
		return sb.toString();
		
	}
	
}
