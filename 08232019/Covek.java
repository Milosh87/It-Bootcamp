package inheritanceDomaci;

public class Covek {
	private String ime;
	private String prezime;
	private int godinaRodjenja;

	public Covek(String ime, String prezime, int godinaRodjenja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public int getGodinaRodjenja() {
		return godinaRodjenja;
	}

	@Override
	public String toString() {
		return "Covek: Ime=" + ime + ", Prezime=" + prezime + ", Godiste=" + godinaRodjenja;
	}

}
