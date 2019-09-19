package inheritanceDomaci;

public class Profesor extends Nastavnik {
private String titula;
	public Profesor(String ime, String prezime, int godinaRodjenja, int godinaZaposlenja, int plata,
			String omiljeniPredmet, String[] listaPredmeta, String titula) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata, omiljeniPredmet, listaPredmeta);
		// TODO Auto-generated constructor stub
		if (titula.toLowerCase().equals("docent") || titula.toLowerCase().equals("vanredni") || titula.toLowerCase().equals("redovni")) {
			this.titula = titula;
		} else {
			System.out.println("Pogresna titula");
			this.titula = null;
		}
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		if (titula.equals("docent") || titula.equals("vanredni") || titula.equals("redovni")){
		this.titula = titula;
		} else {
			System.out.println("Titule: docent / vanredni / redovni");
		}
	}
	@Override
	public String toString() {
		return super.toString()+ "\n\t Profesor: titula=" + titula;
	}

}
