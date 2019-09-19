package jmbg;

public class Ocena {
	private int bodovi;
	private Predmet pr;

	public Ocena(int bodovi, Predmet pr) {
		this.bodovi = bodovi;
		this.pr = pr;
	}

	public int getOcena() {
		if (bodovi >= 0 && bodovi < 50) {
			return 5;
		} else if (bodovi >= 51 && bodovi <= 60) {
			return 6;
		} else if (bodovi >= 61 && bodovi <= 70) {
			return 7;
		} else if (bodovi >= 71 && bodovi <= 80) {
			return 8;
		} else if (bodovi >= 81 && bodovi <= 90) {
			return 9;
		} else if (bodovi >= 91 && bodovi <= 100) {
			return 10;
		} else
			return 0;
	}

	public String toString() {
		return "Predmet: " + pr.getIme() + ", Ocena: " + getOcena();
	}

	public int getBodovi() {
		return bodovi;
	}

	public Predmet getPr() {
		return pr;
	}

}
