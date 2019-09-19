package petnaestipaket;

public class Pravougaonik {
	private double a;
	private double b;
	private String ime;

	public Pravougaonik(double a, double b, String ime) {
		this.a = a;
		this.b = b;
		this.ime = ime;
	}

	public Pravougaonik(double a, String ime) {
		this.a = a;
		this.b = a;
		this.ime = ime;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public String getIme() {
		return ime;
	}

	public double getObim() {
		return 2 * a + 2 * b;
	}

	public double getPovrsina() {
		return a * b;
	}

	public void ispisiPravougaonik() {
		System.out.println("Pravougaonik " + this.ime + ": ");
		System.out.println("Duzina prve stranice je " + this.a);
		System.out.println("Duzina druge stranice je " + this.b);
		System.out.println("Povrsina pravougaonika je " + getPovrsina());
		System.out.println("Obim pravougaonika je " + getObim());
	}
}
