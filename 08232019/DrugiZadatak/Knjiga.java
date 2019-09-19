package policaa;

public class Knjiga {
	private String naziv;
	private List[] brojListova;

	public Knjiga(String naziv, int brojListova) {
		super();
		this.naziv = naziv;
		this.brojListova = new List[brojListova];
	}

	public String getNaziv() {
		return naziv;
	}

	public void dodajList(List x) {
		boolean postoji = false;
		if (x == null) {
			return;
		} else {
			for (int i = 0; i < brojListova.length; i++) {
				if (brojListova[i] != null && List.isteStranice(brojListova[i], x)) {
					postoji = true;
					brojListova[i] = x;
					break;
				}
			}
			if (!postoji) {
				for (int i = 0; i < brojListova.length; i++) {
					if (brojListova[i] == null) {
						brojListova[i] = x;
						break;
					}
				}
			}
		}
	}

	public int brojListova(int n) {
		return brojListova.length;
	}

	public List listSaRednimBrojem(int n) {
		for (int i = 0; i < brojListova.length; i++) {
			if (brojListova[i] != null && brojListova[i].getRedniBr() == n) {
				return brojListova[i];
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv + "\n");
		List[] noviBrojListova = new List[brojListova.length];
		for (int i = 0; i < brojListova.length; i++) {
			noviBrojListova[i] = brojListova[i];
		}
		for (int i = 0; i < noviBrojListova.length; i++) {
			List min = noviBrojListova[i];
			if (min == null) {
				continue;
			}
			for (int j = i + 1; j < noviBrojListova.length; j++) {
				if (noviBrojListova[j] != null && List.vecaStranica(min, noviBrojListova[j])) {
					List zamena = min;
					min = noviBrojListova[j];
					noviBrojListova[j] = zamena;

				}
			}
			sb.append(min);
		}
		return sb.toString();
	}
}
