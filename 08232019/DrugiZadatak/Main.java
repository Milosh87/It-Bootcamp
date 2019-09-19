package policaa;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l1 = new List(1, "Tekst 1");
		List l2 = new List(2, "Tekst 2");
		List l3 = new List(3, "Tekst 3");
		List l4 = new List(4, "Tekst 4");
		List l5 = new List(5, "Tekst 5");
		List l6 = new List(6, "Tekst 6");
		List l12 = new List(34, "Tekst 9");

		List l14 = new List(11, "Tekst 11");


		Knjiga k1 = new Knjiga("Ime Vetra", 15);
		Knjiga k2 = new Knjiga("Ubik", 15);
		k2.dodajList(l12);
		k2.dodajList(l4);
		k2.dodajList(l2);
		k2.dodajList(l14);
		k2.dodajList(l5);
		k2.dodajList(l6);
		k1.dodajList(l1);
		k1.dodajList(l12);
		k1.dodajList(l3);

		Polica p1 = new Polica();
		p1.dodajKnjigu(k1, 2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2);
		p1.dodajKnjigu(k2, 1);
		System.out.println(p1);

	}

}
