package inheritanceDomaci;

public class StudentMasterStudija extends Student {
	private String smerMasterStudija;

	public StudentMasterStudija(String ime, String prezime, int godinaRodjenja, int godinaStudija, double prosek, String smerMasterStudija) {
		super(ime, prezime, godinaRodjenja, godinaStudija, prosek);
		// TODO Auto-generated constructor stub
		this.smerMasterStudija = smerMasterStudija;
	}

	public String getSmerMasterStudija() {
		return smerMasterStudija;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t Student Master Studija: Smer master studija=" + smerMasterStudija;
	}

}
