package inheritanceDomaci;

public class Sluzbenik extends Zaposleni {
	private String odsek;

	public Sluzbenik(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata, String odsek) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata);
		// TODO Auto-generated constructor stub
		this.odsek = odsek;
	}

	public String getOdsek() {
		return odsek;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t Sluzbenik:  Odsek=" + odsek;
	}

}
