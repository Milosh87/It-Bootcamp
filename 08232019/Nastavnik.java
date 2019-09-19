package inheritanceDomaci;

import java.util.Arrays;

public class Nastavnik extends Zaposleni {
	private String omiljeniPredmet;
	private String[] listaPredmeta;

	public Nastavnik(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata,
			String omiljeniPredmet, String[] listaPredmeta) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata);
		// TODO Auto-generated constructor stub
		this.omiljeniPredmet = omiljeniPredmet;
		this.listaPredmeta = listaPredmeta;
	}

	public String getOmiljeniPredmet() {
		return omiljeniPredmet;
	}

	public String[] getListaPredmeta() {
		return listaPredmeta;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t Nastavnik: Omiljeni predmet=" + omiljeniPredmet + ", Predaje ="
				+ Arrays.toString(listaPredmeta);
	}

}
