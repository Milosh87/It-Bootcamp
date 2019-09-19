package policaa;

public class Polica {
	private Knjiga[] nizKnjiga;

	public Polica() {
		nizKnjiga = new Knjiga[10];
	}

	public void dodajKnjigu(Knjiga x, int n) {
		if (x == null || n < 1 || n > 10) {
			return;
		}
		if (nizKnjiga[n - 1] == null) {
			nizKnjiga[n - 1] = x;
		}
	}

	public void dodajKnjigu(Knjiga x) {
		if (x == null) {
			return;
		}
		for (int i = 0; i < nizKnjiga.length; i++) {
			if (nizKnjiga[i] == null) {
				nizKnjiga[i] = x;
				break;
			}
		}
	}

	public Knjiga uzmiKnjigu(String naziv) {
		for (int i = 0; i < nizKnjiga.length; i++) {
			if (nizKnjiga[i].getNaziv() == naziv) {
				Knjiga uzeta = nizKnjiga[i];
				nizKnjiga[i] = null;
				return uzeta;
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nizKnjiga.length; i++) {
			if (nizKnjiga[i] == null) {
				sb.append("prazno \n");
			} else
				sb.append(nizKnjiga[i]);
		}
		return sb.toString();
	}
}
