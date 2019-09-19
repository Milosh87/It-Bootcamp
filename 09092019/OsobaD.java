package domaciKlase;

public class OsobaD extends Osoba {
	private Datum datumRodj;

	public OsobaD(String ime, String prezime, String adresa, Datum datumRodj) {
		super(ime, prezime, adresa);
		// TODO Auto-generated constructor stub
		this.datumRodj = datumRodj;
	}
	
	public OsobaD(OsobaD od) {
		super(od);
		this.datumRodj = od.datumRodj;
	}
	@Override
	public Datum getDatum() {
		return datumRodj;
	}

	@Override
	public int numeroloskiBroj() {
		int sum=0;
		int d = datumRodj.getDan();
		int m = datumRodj.getMesec();
		int g = datumRodj.getGodina();
		while(d>0) {
			sum+= d%10;
			d/=10;
		}
		while(m>0) {
			sum+= m%10;
			m/=10;
		}
		while(g>0) {
			sum+= g%10;
			g/=10;
		}
		while (sum > 9) {
			int sum2 = 0;
			while(sum >0) {
				sum2 += sum%10;
				sum/=10;
			}
			sum = sum2;
		}
		return sum;
	}
	

	public void setDatumRodj(Datum datumRodj) {
		this.datumRodj = datumRodj;
	}

	@Override
	public String metabolizam(Datum d) {
		// TODO Auto-generated method stub
		String osobaDatum = datumRodj.toString().replace(".","");
		String drugiDatum = d.toString().replace(".", "");		
		int konacan = Integer.parseInt(osobaDatum) + Integer.parseInt(drugiDatum);
		System.out.println(konacan);
		if(konacan<10000000) {
			return (Integer.toString(konacan) + "0");
		}
		else return Integer.toString(konacan);
	}

	@Override
	public String toString() {
		return super.toString() + " [datumRodj=" + datumRodj + "]";
	}
	
	}



