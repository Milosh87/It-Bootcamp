package inheritanceDomaci;

public class Asistent extends Nastavnik {
	private String smerDoktorskihStudija;

	public Asistent(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata,
			String omiljeniPredmet, String[] listaPredmeta, String smerDoktorskihStudija) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata, omiljeniPredmet, listaPredmeta);
		// TODO Auto-generated constructor stub
		this.smerDoktorskihStudija = smerDoktorskihStudija;
	}

	public String getSmerDoktorskihStudija() {
		return smerDoktorskihStudija;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t Asistent: Smer doktorskih studija=" + smerDoktorskihStudija;
	}

}
