package inheritanceDomaci;

public class StudentOsnovnih extends Student {
	private String smerOsnovnihStudija;

	public StudentOsnovnih(String ime, String prezime, int godinaRodjenja, int godinaStudija, double prosek,
			String smerOsnovnihStudija) {
		super(ime, prezime, godinaRodjenja, godinaStudija, prosek);
		// TODO Auto-generated constructor stub
		this.smerOsnovnihStudija = smerOsnovnihStudija;
	}

	public String getSmerOsnovnihStudija() {
		return smerOsnovnihStudija;
	}

	@Override
	public String toString() {
		return super.toString() +  "\n\t Student Osnovnih Studija: Smer osnovnih studija=" + smerOsnovnihStudija;
	}

}
