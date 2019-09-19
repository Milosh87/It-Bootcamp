package dvanestidomaci;

import java.util.Scanner;

public class PrviZadatak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite rec: ");
		String [] reci = sc.nextLine().toLowerCase().split(" ");
		String rec = spojeneReci(reci);
		boolean palindrom = palindrom(rec);
		if (palindrom) {
			System.out.println("Rec jeste palindrom");
		} else {
			System.out.println("Rec nije palindrom");
		}
		
	}
	public static String spojeneReci(String [] reci) {			// pretvaranja niza u string
		String rec="";
		for (int i =0; i<reci.length; i++) {
			rec += reci[i];
		}
		return rec;
	}
	public static boolean palindrom(String rec) {				// provera da li je string palindrom
		for (int i = 0, j=rec.length()-1; i<j; i++,j--) {
			if (rec.charAt(i) != rec.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
