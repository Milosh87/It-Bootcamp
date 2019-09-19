package policaa;

public class List {
	private int redniBr;
	private String tekst;

	public List(int redniBr, String tekst) {
		this.redniBr = redniBr;
		this.tekst = tekst;
	}

	public int getRedniBr() {
		return redniBr;
	}

	public boolean isteStranice(List x) {
		if (redniBr == x.getRedniBr()) {
			return true;
		} else
			return false;
	}

	public static boolean isteStranice(List x, List y) {
		if (x.getRedniBr() == y.getRedniBr()) {
			return true;
		} else
			return false;
	}

	public boolean vecaStranica(List x) {
		if (redniBr > x.getRedniBr()) {
			return true;
		} else
			return false;
	}

	public static boolean vecaStranica(List x, List y) {
		if (x.getRedniBr() > y.getRedniBr()) {
			return true;
		} else
			return false;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return "\t" + tekst + "(" + redniBr + ")\n";
	}

}
