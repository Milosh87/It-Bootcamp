package domaciKlase;

public class OsobaJMBG extends Osoba{
	private String jmbg;
	public OsobaJMBG(String ime, String prezime, String adresa, String jmbg) {
		super(ime, prezime, adresa);	
		this.jmbg = jmbg;
		// TODO Auto-generated constructor stub
	}
	public OsobaJMBG(OsobaJMBG o) {
		super(o);
		this.jmbg = o.jmbg;
	}
	public String getJmbg() {
		return jmbg;
	}
	@Override
	public Datum getDatum() {
		return new Datum(Integer.parseInt(jmbg.substring(0,2)), Integer.parseInt(jmbg.substring(2, 4)), (1000+Integer.parseInt(jmbg.substring(4, 7))));
	}
	@Override
	public int numeroloskiBroj() {
		if(jmbg == null) {
			System.out.println("Ne postoji jmbg");
			return 0;
		}
		Datum dr = getDatum();
		int sum=0;
		int d = dr.getDan();
		int m = dr.getMesec();
		int g = dr.getGodina();
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
	
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	@Override
	public String metabolizam(Datum d) {
		// TODO Auto-generated method stub
		String jmbgDatum = getDatum().toString().replace(".","");
		String drugiDatum = d.toString().replace(".", "");	
		int konacan = Integer.parseInt(jmbgDatum) + Integer.parseInt(drugiDatum);
		if(konacan<10000000) {
			return (Integer.toString(konacan) + "0");
		}
		else return Integer.toString(konacan);
	}
	@Override
	public String toString() {
		return super.toString() +  " [jmbg=" + jmbg + "]";
	}
	
	
	
}
