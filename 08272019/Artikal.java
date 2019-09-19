package nasledjivanjeDomaci;

public abstract class Artikal {
	private static int globalID = 1;
	private int id;
	private double cena;
	private int kolicina;

	public Artikal(double cena, int kolicina) {
		this.cena = cena;
		this.kolicina = kolicina;
		id = globalID++;
	}
public boolean kupi() {
	if(kolicina > 0) {
		kolicina--;
		return true;
	} else return false;
}

public abstract String ime();

public double getCena() {
	return cena;
}
public int getId() {
	return id;
}
public int getKolicina() {
	return kolicina;
}
public String toString() {
	return "#" + id + ": " + ime() + " - " + cena + " [kol: " + kolicina + "]";
}


}


