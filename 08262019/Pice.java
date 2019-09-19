package abstrakt;

public class Pice extends Namirnica {
	private double kolicina;
	private double enVr;

	public Pice(String ime, double kolicina, double enVr) {
		super(ime);
		this.kolicina = kolicina;
		this.enVr = enVr;

	}
	public double getKolicina() {
		return kolicina;
	}
	@Override
	public double energVr() {
		// TODO Auto-generated method stub
		return enVr*kolicina;
	}
	@Override
	public String toString() {
		return super.toString() + "(" + kolicina +"l, " + this.energVr()+"kJ)";
	}
	

}
