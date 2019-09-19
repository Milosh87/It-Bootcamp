/*2. Направити методу која на основу унетих вредности у базу уписује Студента

метода:
dodajStudenta(int indeks,String ime,String prezime,LocalDate datumUpisa,LocalDate datumRodjenja,String mestoRodjenja){
	...
} // Treba samo da doda studenta na osnovu ovih informacija,ne mora da cini dodatne provere
Hint (Ovako izgleda sql upit,ako vam je lakse,umesto LocalDate koristite String)
insert into dosije(indeks,ime,prezime,datum_upisa,datum_rodjenja,mesto_rodjenja) 
values (20140021, 'Milos'   , 'Peric' , '06.07.2014', '20.01.1995', 'Beograd' )


3. За вежбу,можете направити и преостале задатке са прошлог домаћег:
	1. Izdvojiti podatke o svim predmetima.
   	2. Izdvojiti podatke o svim studentima rođenim u Beogradu.
   	3. Izdvojiti mesta u kojima su rođeni studenti.
   	4. Izdvojiti nazive predmeta koji imaju više od 6 bodova.
   	5. Izdvojiti šifre i nazive predmeta koji imaju između 8 i 15 bodova.
   	6. Izdvojiti podatke o ispitima na kojima student ima 81, 76 ili 59 bodova.
   	7. Izdvojiti podatke o ispitima na kojima student nema 81, 76 ili 59 bodova.
   	8. Izdvojiti nazive predmeta i njihovu cenu za samofinansirajuće studente izraženu u dinarima. Jedan bod košta 1500 dinara.
 

4. Из табеле избрисати испите који немају постављену валидну оцену (оцена је валидна ако је између 5 и 10,укључујући обе вредности)

5. Направити методу која мења датум рођења за студента са датим бројем индекса

метода:
setDatumRodjenja(int indeks, LocalDate datumRodjenja){
	...
}
//Kao i gore,ako vam je lakse,umesto LocalDate,koristite String


Напомена: Сваку методу тестирати у класи Main,и проверити да ли се у бази дешавају промене које желите (направите копију базе,да бисте лакше вратили све на почетно стање уколико направите грешку) */

package domaciBaza;

import java.sql.*;

public class Baza {
	private String connectionString;
	private Connection con;
	public Baza(String conStr) {
		this.connectionString = conStr;
	}
	public void connect() {
		try {
			con = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void disconnect() {
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dodajStudenta(int indeks, String ime, String prezime, String datumUpisa, String datumRodjenja, String mestoRodjenja) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO dosije(indeks, ime, prezime, datum_upisa, datum_rodjenja, mesto_rodjenja)"
														+ " VALUES(?, ?, ?, ?, ?, ?)");
			ps.setInt(1, indeks);
			ps.setString(2, ime);
			ps.setString(3, prezime);
			ps.setString(4, datumUpisa);
			ps.setString(5, datumRodjenja);
			ps.setString(6, mestoRodjenja);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void podaciPredmeti() {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM PREDMET");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				int idP = rs.getInt(1);
				int sifra = rs.getInt(2);
				String naziv = rs.getString(3);
				int bodovi = rs.getInt(4);
				
				System.out.println("ID: " + idP + " Sifra: " + sifra + " Naziv: " + naziv + " Bodovi: " + bodovi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void studentiIzBg() {

		try {
			String upit = "SELECT *"
					+ " FROM dosije"
					+ " WHERE mesto_rodjenja = \"Beograd\"";
			PreparedStatement ps = con.prepareStatement(upit);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int indeks = rs.getInt(1);
				String ime = rs.getString(2);
				String prezime = rs.getString(3);
				String datumUpisa = rs.getString(4);
				String datumRodj = rs.getString(5);
				String mestoRodj = rs.getString(6);
				
				System.out.println("ID: " + indeks + " Ime: " + ime + " Prezime: " + prezime + " Datum upisa: " + datumUpisa + " Datum rodjenja: " + datumRodj + " Mesto rodjenja: " + mestoRodj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void mestaRodjenja() {

		try {
			PreparedStatement ps = con.prepareStatement("SELECT DISTINCT mesto_rodjenja"
					+ " FROM dosije"
					+ " WHERE mesto_rodjenja IS NOT NULL");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String mestoRodj = rs.getString(1);
				System.out.println("Mesto rodjenja: " + mestoRodj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	public void predmetiPrekoSest() {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT NAZIV"
					+ " FROM predmet"
					+ " WHERE bodovi > 6");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String naziv = rs.getString(1);
				System.out.println("Naziv: " + naziv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void predmetiIzmedju8i15() {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT sifra, naziv"
					+ " FROM predmet"
					+ " WHERE bodovi between 8 AND 15");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String sifra = rs.getString(1);
				String naziv = rs.getString(2);
				System.out.println("Sifra: " + sifra + " Naziv: " + naziv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bodovi_81_76_ili_59() {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT *"
					+ " FROM ispit"
					+ " WHERE bodovi = 81 OR bodovi = 76 OR bodovi = 59");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int indeks = rs.getInt(1);
				int id = rs.getInt(2);
				int godinaRoka = rs.getInt(3);
				String oznakaRoka = rs.getString(4);
				int ocena = rs.getInt(5);
				int datumIspita = rs.getInt(6);
				int bodovi = rs.getInt(7);
				System.out.println("Indeks: " + indeks + " Id: " + id + " Godina roka: " + godinaRoka + " Oznaka roka: " + oznakaRoka+ " Ocena: " + ocena + " Datum ispita: " + datumIspita + " Bodovi: " + bodovi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void notBodovi_81_76_ili_59() {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT *"
					+ " FROM ispit"
					+ " WHERE bodovi IS NOT 81 AND bodovi IS NOT 76 AND bodovi IS NOT 59 AND bodovi IS NOT NULL");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int indeks = rs.getInt(1);
				int id = rs.getInt(2);
				int godinaRoka = rs.getInt(3);
				String oznakaRoka = rs.getString(4);
				int ocena = rs.getInt(5);
				int datumIspita = rs.getInt(6);
				int bodovi = rs.getInt(7);
				System.out.println("Indeks: " + indeks + " Id: " + id + " Godina roka: " + godinaRoka + " Oznaka roka: " + oznakaRoka+ " Ocena: " + ocena + " Datum ispita: " + datumIspita + " Bodovi: " + bodovi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cenaSamofin() {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT NAZIV, bodovi*1500 AS \"Cena za samofin\" "
					+ " FROM predmet");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			String naziv = rs.getString(1);
			int cena = rs.getInt(2);
			System.out.println("Naziv: " + naziv + " Cena za samofin: " + cena);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void brisiInvalidOcene() {
		try {
			PreparedStatement ps = con.prepareStatement("DELETE "
														+ " FROM ispit"
														+ " WHERE ocena NOT BETWEEN 5 AND 10");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void promeniDatumRodjenjaStudenta(int brIndeksa, String noviDatum) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE dosije"
														+ " SET datum_rodjenja = ?"
														+ " WHERE indeks = ?");
			ps.setString(1, noviDatum);
			ps.setInt(2, brIndeksa);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
