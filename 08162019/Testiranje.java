package trougao;

import java.util.Random;

public class Testiranje {

	public static void main(String[] args) {
		Tacka [] a = new Tacka[10];
		randomTackeNiz(a);			// kreiranje random niza tacaka od 10 elemenata
		ispisiTacke(a);				// ispis tih 10 tacaka
		Trougao x = new Trougao(a[5], 2, 7 , 14);
		Trougao y = new Trougao(a[3], 6, 6 ,7);
		Trougao z = new Trougao(a[8], 4, 6 ,5);
		System.out.println(x);
		System.out.println(z);
		x.jednakokraki();		
		y.jednakokraki();		// y = 6 6 7
		z.jednakokraki();
		System.out.println(z);
		Trougao k = new Trougao(a[3], 6, 6 ,7);
		y.setA(7);
		y.isteTacke(z);			// razlicite tacke
		k.isteTacke(y);			// iste tacke
		z.setTacka(a[9]);		// promena tacke
		z.setSveStranice(8, 9, 10);		// promena svih stranica
		System.out.println(z);		// ispis z sa novom tackom i novim stranicama
		
	}
	static void randomTackeNiz(Tacka [] a) {
		for (int i =0; i<a.length; i++) {
			a[i] = new Tacka(randomDouble(), randomDouble());
		}
	}
	static double randomDouble() {
		Random r = new Random();
		return  r.nextInt(100) / 10.0;
	}
	static void ispisiTacke(Tacka [] a) {
		for (int i =0; i<a.length; i++) {
			System.out.println(i + ": " + "x = " + a[i].getX() + ", y = " + a[i].getY());
		}
	}
}
