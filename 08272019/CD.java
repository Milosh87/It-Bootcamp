package nasledjivanjeDomaci;

public class CD extends AlbumArtikal{

	public CD(Album album, String izdavac, double cena, int kolicina) {
		super(album, izdavac, cena, kolicina);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ime() {
		// TODO Auto-generated method stub
		return album.getIzvodjac() + " - " + album.getNaziv() +" (CD)";
	}

}
