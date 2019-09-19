package trougao;

public class Trougao {
	private Tacka t;
	private int a;
	private int b;
	private int c;

	Trougao(Tacka t, int a, int b, int c) {
		if ((a > 0 && b > 0 && c > 0) && (a + b > c && b + c > a && a + c > b)) {
			this.t = t;
			this.a = a;
			this.b = b;
			this.c = c;
		} else {
			System.out.println("Trougao nije validan");
			if (a <= 0 || b <= 0 || c <= 0) {
				System.out.println("Upisali ste negativan broj ili 0 za stranice trougla");
			} else if (a + b < c) {
				System.out.printf("Trougao sa stranicama %d,%d,%d ne postoji jer %d + %d nije vece od %d\n", a, b, c, a,
						b, c);
			} else if (b + c < a)
				System.out.printf("Trougao sa stranicama %d,%d,%d ne postoji jer %d + %d nije vece od %d\n", b, c, a, b,
						c, a);
			else
				System.out.printf("Trougao sa stranicama %d,%d,%d ne postoji jer %d + %d nije vece od %d\n", a, c, b, a,
						c, b);
		}
	}

	public boolean jednakokraki() {
		if ((a == b || b == c || a == c) && this.a != 0 && this.b != 0 && this.c != 0 && this.t != null) {
			System.out.println("Trougao je jednakokraki");
			return true;
		} else {
			System.out.println("Trougao nije jednakokraki");
			return false;
		}
	}

	public double getPovrsina() {
		double s = (double) (a + b + c) / 2;
		double p = Math.sqrt((s * (s - a) * (s - b) * (s - c)));
		return p;
	}

	public int getObim() {
		return a + b + c;
	}

	public void setA(int a) {
		if (a > 0 && a + b > c && b + c > a && a + c > b) {
			this.a = a;
			System.out.println("Stranica a uspesno promenjena!");
		} else {
			System.out.println("Niste uspeli da promenite stranicu a!");
		}
	}

	public void setB(int b) {
		if (b > 0 && a + b > c && b + c > a && a + c > b) {
			this.b = b;
			System.out.println("Stranica b uspesno promenjena!");
		} else {
			System.out.println("Niste uspeli da promenite stranicu b!");
		}
	}

	public void setC(int c) {
		if (c > 0 && a + b > c && b + c > a && a + c > b) {
			this.c = c;
			System.out.println("Stranica c uspesno promenjena!");
		} else {
			System.out.println("Niste uspeli da promenite stranicu c!");
		}
	}

	public void setSveStranice(int a, int b, int c) {
		if ((a > 0 && b > 0 && c > 0) && (a + b > c && b + c > a && a + c > b)) {
			this.a = a;
			this.b = b;
			this.c = c;
			System.out.println("Promena stranica uspesna");
		} else {
			System.out.println("Promena stranica nije uspesna");
		}
	}

	public Tacka getTacka() {
		return t;
	}

	public boolean isteTacke(Trougao y) {
		if (getTacka() == null || y.getTacka() == null) {
			System.out.println("Trouglovi su lose kreirani");			
			return false;
		}

		else if (getTacka().getX() == y.getTacka().getX() && getTacka().getY() == y.getTacka().getY()) {
			System.out.println("Tacke dva trougla su jednake: " + getTacka().toString());
			return true;
		}

		else {
			System.out.println("Tacke su razlicite, prva je u " + getTacka().toString() + " a druga je "
					+ y.getTacka().toString());
			return false;
		}
	}

	public String toString() {
		if (this.a != 0 && this.b != 0 && this.c != 0 && this.t != null) {
			String ispis = "";
			ispis += "Trougao sa pocetkom u " + this.getTacka() + ":\n";
			ispis += "Stranice trougla: " + a + " " + b + " " + c + " \n";
			ispis += "Povrsina i obim: P = " + String.format("%.2f", this.getPovrsina()) + ", O = " + this.getObim();
			return ispis;
		} else
			return "Trougao nije kreiran pravilno";

	}

	public void setTacka(Tacka t) {
		this.t = t;
	}

}
