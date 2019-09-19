package prodavnica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Baza b = new Baza("jdbc:sqlite:C:\\Users\\Milos\\Downloads\\Prodavnica.db");
		b.connect();
		System.out.println("Dobrodosli u prodavnicu");
		b.meni();	

	}}
