package domaciIzrazi;

public class Sabiranje extends BinarnaOperacija {

	public Sabiranje(Izraz levi, Izraz desni) {
		super(levi, desni);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double izracunaj() {
		// TODO Auto-generated method stub
		double vrednostLevogIzraza = levi.izracunaj();
		double vrednostDesnogIzraza = desni.izracunaj();
		return vrednostLevogIzraza + vrednostDesnogIzraza;
	}

	@Override
	public String toString() {
		if (levi.izracunaj() < 0) {
			return levi.toString() + " + " + desni.toString();
		}
		return levi.toString() + " + " + desni.toString();
	}
	
	

}
