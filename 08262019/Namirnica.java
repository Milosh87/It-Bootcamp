package abstrakt;

public abstract class Namirnica extends Energent {
	private static int globalID=1;
	protected String ime;
	protected int id;
	public Namirnica(String ime) {
		super();
		this.ime = ime;
		id = globalID++;
	}

	public String getIme() {
		return ime;
	}
	public int getId() {
		return id;
	}
	public String toString() {
		return "[" + id + "] " + ime;
	}
}
