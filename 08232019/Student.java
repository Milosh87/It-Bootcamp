package inheritanceDomaci;

public class Student extends Covek {
	private int godinaStudija;
	private double prosek;

	public Student(String ime, String prezime, int godinaRodjenja, int godinaStudija, double prosek) {
		super(ime, prezime, godinaRodjenja);
		this.godinaStudija = godinaStudija;
		this.prosek = prosek;
		// TODO Auto-generated constructor stub
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public double getProsek() {
		return prosek;
	}

	@Override
	public String toString() {
		return  super.toString() + "\n\t Student: Godina studija=" + godinaStudija + ", Prosek=" + prosek;
	}

}
