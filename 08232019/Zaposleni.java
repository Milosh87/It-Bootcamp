package inheritanceDomaci;

public class Zaposleni extends Covek {
	private int godinaZaposlenja;
	private int plata;

	public Zaposleni(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata) {
		super(ime, prezime, godinaRodjenja);
		// TODO Auto-generated constructor stub
		this.godinaZaposlenja = godinaZaposlenja;
		this.plata = plata;
	}

	public int getGodinaZaposlenja() {
		return godinaZaposlenja;
	}

	public int getPlata() {
		return plata;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t Zaposleni: Godina zaposlenja=" + godinaZaposlenja + ", Plata=" + plata;
	}

}
