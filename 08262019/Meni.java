package abstrakt;

public class Meni {
	private Namirnica[] niz;
	private int brNam;

	public Meni(int kapacitet) {
		this.niz = new Namirnica[kapacitet];
		this.brNam = 0;
	}

	public double energVr() {
		double ukupnaVr = 0;
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] != null) {
				ukupnaVr += niz[i].energVr();
			}
		}
		return ukupnaVr;
	}

	public boolean dodaj(Namirnica x) {
		if (x == null) {
			return false;
		}
		if (x.getIme() == null) {
			return false;
		}
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == null) {
				niz[i] = x;
				brNam++;
				return true;
			}
		}
		return false;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Meni (" + this.energVr() + "kJ):\n");
		for (int i=0; i<niz.length; i++) {
			if(niz[i] != null) {
				sb.append(" " + niz[i] + "\n");
			}
		}
		return sb.toString();
	}

}
