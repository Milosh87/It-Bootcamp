package domaciIzrazi;

public class Broj extends Izraz{
	private double vrednost;
	
	public Broj(double vrednost) {
		super();
		this.vrednost = vrednost;
	}

	@Override
	public double izracunaj() {
		// TODO Auto-generated method stub
		return vrednost;
	}
	
	public String toString() {
		if(vrednost < 0) {
			return "(" + Double.toString(vrednost) + ")"; 
		}
		else return Double.toString(vrednost);
	}
	
}
