package domaciKlase;

public abstract class Osoba {
	private String ime;
	private String prezime;
	private String adresa;

	public Osoba(String ime, String prezime, String adresa) {
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
	}

	public Osoba(Osoba o) {
		this.ime = o.ime;
		this.prezime = o.prezime;
		this.adresa = o.adresa;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getAdresa() {
		return adresa;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public abstract int numeroloskiBroj();
	public abstract String metabolizam(final Datum d);
	public abstract Datum getDatum();

	@Override
	public String toString() {
		return "[ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + "]";
	}
	
	
}
