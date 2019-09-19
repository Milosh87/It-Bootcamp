package domaciIzrazi;

public class Oduzimanje extends BinarnaOperacija {

	public Oduzimanje(Izraz levi, Izraz desni) {
		super(levi, desni);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double izracunaj() {
		// TODO Auto-generated method stub
		double vrednostLevogIzraza = levi.izracunaj();
		double vrednostDesnogIzraza = desni.izracunaj();
		return vrednostLevogIzraza - vrednostDesnogIzraza;
	}
	@Override
	public String toString() {
		return levi.toString() + " - " + desni.toString();
	}



}
