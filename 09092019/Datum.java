package domaciKlase;

public class Datum {
	private int dan;
	private int mesec;
	private int godina;

	public Datum(int dan, int mesec, int godina) {
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;
	}
	public Datum(Datum d) {
		this.dan = d.dan;
		this.mesec = d.mesec;
		this.godina = d.godina;
	}

	public int getDan() {
		return dan;
	}

	public int getMesec() {
		return mesec;
	}

	public int getGodina() {
		return godina;
	}
	
	public void setDan(int dan) {
		this.dan = dan;
	}
	public void setMesec(int mesec) {
		this.mesec = mesec;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public String toString() {
		if(dan <10 && mesec <10) {
			return "0"+dan + "." + "0" + mesec + "." + godina + ".";
		}
		if (dan < 10) {
			return "0"+dan + "." + mesec + "." + godina + ".";
		}
		if (mesec<10) {
			return dan + "." + "0"+ mesec + "." + godina + ".";
		}
		 return dan + "." + mesec + "." + godina + ".";
	}

}
