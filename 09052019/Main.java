package domaciBaza;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Baza b = new Baza("jdbc:sqlite:C:\\Users\\Milos\\Desktop\\Baza\\studentskabaza.db");
		b.connect();
		b.dodajStudenta(1312302313, "Milos", "Mijatovic", "25-02-2008", "08-11-1987", "Beograd");
		b.podaciPredmeti();
		System.out.println("---------------------------------------------------------------------------");
		b.studentiIzBg();
		System.out.println("---------------------------------------------------------------------------");
		b.mestaRodjenja();
		System.out.println("---------------------------------------------------------------------------");
		b.predmetiPrekoSest();
		System.out.println("---------------------------------------------------------------------------");
		b.predmetiIzmedju8i15();
		System.out.println("---------------------------------------------------------------------------");
		b.bodovi_81_76_ili_59();
		System.out.println("---------------------------------------------------------------------------");
		b.notBodovi_81_76_ili_59();
		System.out.println("---------------------------------------------------------------------------");
		b.cenaSamofin();
		System.out.println("---------------------------------------------------------------------------");
		b.brisiInvalidOcene();
		b.promeniDatumRodjenjaStudenta(20140026, "11-06-2000");
		b.disconnect();

		
	}

}
