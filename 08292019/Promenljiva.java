package domaciIzrazi;

public class Promenljiva extends Izraz {
	private String ime;
	private double vrednost;
	
	
	public Promenljiva(String ime, double vrednost) {
		super();
		this.ime = ime;
		this.vrednost = vrednost;
	}


	@Override
	public double izracunaj() {
		// TODO Auto-generated method stub
		return vrednost;
	}
	
	public String toString() {
		return vrednost+"(" + ime + ")";
	}
	
	
}
