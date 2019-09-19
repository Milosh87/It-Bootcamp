package petnaestipaket;

public class Main {

	public static void main(String[] args) {
		Pravougaonik pravougaonikJedan = new Pravougaonik(5.0, 2.0, "Prvi");
		Pravougaonik pravougaonikDva = new Pravougaonik(3.0, "Drugi");
		System.out.println("Prvi pravougaonik stranica a: " + pravougaonikJedan.getA());
		System.out.println("Prvi pravougaonik stranica b: " + pravougaonikJedan.getB());
		System.out.println("----------------------------------");
		System.out.println("Drugi pravougaonik stranica a: " + pravougaonikDva.getA());
		System.out.println("Drugi pravougaonik stranica b: " + pravougaonikDva.getB());
		System.out.println("----------------------------------");
		pravougaonikJedan.ispisiPravougaonik();
		System.out.println("----------------------------------");
		pravougaonikDva.ispisiPravougaonik();
	}

}
