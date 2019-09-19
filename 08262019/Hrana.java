package abstrakt;

public class Hrana extends Namirnica {
	private double tezina;
	private double belancevine;
	private double masti;
	private double ugljHidrati;

	public Hrana(String ime, double tezina, double belancevine, double masti, double ugljHidrati) {
		super(ime);
		if ((belancevine + masti + ugljHidrati > 100)) {
			this.ime = null;
			this.tezina = 0;
			this.belancevine = 0;
			this.masti = 0;
			this.ugljHidrati = 0;
		} else {
		this.tezina = tezina;
		this.belancevine = belancevine;
		this.masti = masti;
		this.ugljHidrati = ugljHidrati;
		}
	}

	public double getTezina() {
		return tezina;
	}

	public double getBelancevine() {
		return belancevine * tezina;
	}

	public double getMasti() {
		return masti * tezina;
	}

	public double getUgljHidrati() {
		return ugljHidrati * tezina;
	}

	@Override
	public double energVr() {
		return (this.getBelancevine() * 16.7 + this.getMasti() * 37.6 + this.getUgljHidrati() * 17.2) / 100;
	}

	@Override
	public String toString() {
		return super.toString() + "(" + tezina + "g, " + this.energVr() + "kJ)";
	}

}
