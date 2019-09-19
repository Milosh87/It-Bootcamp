package nasledjivanjeDomaci;

public abstract class AlbumArtikal extends Artikal {
	protected String izdavac;
	protected Album album;
	public AlbumArtikal(Album album, String izdavac, double cena, int kolicina) {
		super(cena, kolicina);
		// TODO Auto-generated constructor stub
		this.album = album;
		this.izdavac = izdavac;
	}

	public abstract String ime();


}
