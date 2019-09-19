package nasledjivanjeDomaci;

public class LP extends AlbumArtikal {
	private int tezina;
	public LP(Album album, String izdavac, double cena, int kolicina, int tezina) {
		super(album, izdavac, cena, kolicina);
		// TODO Auto-generated constructor stub
		this.tezina = tezina;
	}

	
	
	@Override
	public String ime() {
		// TODO Auto-generated method stub
		return album.getIzvodjac() + " - " + album.getNaziv() +  " (" + tezina + "g" + " LP)";
	}

}
