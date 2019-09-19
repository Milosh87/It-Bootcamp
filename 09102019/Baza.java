package prodavnica;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Baza {
private String connectionString;
private Connection con;
private String trenutniUser=null;
	public Baza(String constr) {
		this.connectionString = constr;
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
	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String user = sc.nextLine();
		System.out.print("Password: ");
		String pass = sc.nextLine(); 
		try {
			PreparedStatement ps = con.prepareStatement("SELECT username, password"
					+ "	FROM KORISNIK ");
			ResultSet rs = ps.executeQuery();
			boolean userPassGood = false;
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				
				if(username.equals(user) && password.equals(pass)) {
					userPassGood=true;
					trenutniUser(user);
					System.out.println("Uspesno ste ulogovani, " + trenutniUser);
					
				}
			}
			if(!userPassGood) {
			System.out.println("Pogresan username ili password");
			return;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		
	}
	public boolean userReg() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String user = sc.nextLine();
		System.out.print("Password: ");
		String pass = sc.nextLine(); 
		System.out.print("Password: ");
		String pass2 = sc.nextLine();
		if (!pass.equals(pass2)) {
			System.out.println("Sifre nisu iste");
			return false;
		}
		if(blanko(user)) {
			System.out.println("Username sadrzi blanko");
			return false;
		}
		if(blanko(pass)) {
			System.out.println("Sifra sadrzi blanko");
			return false;
		}
		if(!veceOd5(pass)) {
			System.out.println("Sifra ima manje od 5 znakova");
			return false;
		}
		try {
			boolean ima = false;
			PreparedStatement ps = con.prepareStatement("SELECT Username"
					+ "	FROM korisnik");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (user.equals(rs.getString(1))) {
					ima = true;
					break;
				}
			}
			if(ima) {
				System.out.println("Postoji vec korisnicko ime");
				return false;
			}
			else {
				PreparedStatement pss = con.prepareStatement("INSERT INTO Korisnik(Username, Password, DatumRodjenja)"
						+ " VALUES(?,?, NULL)");
				pss.setString(1, user);
				pss.setString(2, pass);
				pss.executeUpdate();
				return true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void pregledKupovine() {
		System.out.println("1. Pregled svih automobila");
		System.out.println("2. Uplatite novac za neki od kupljenih");
		
	}
	
	public void uplata() {
		Scanner sc = new Scanner(System.in);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT AUTOMOBIL.idauto, model.naziv, IFNULL(automobil.cena,0) - IFNULL(SUM(uplata.iznos), 0)"
					+ " FROM Automobil LEFT JOIN model using (IdModel)  LEFT JOIN UPLATA using(IdAuto)"
					+ " WHERE IdAuto in(SELECT IdAuto FROM Prodaja WHERE Username = ?)"
					+ " GROUP BY IdAuto");
			ps.setString(1, trenutniUser);
			ResultSet rs = ps.executeQuery();
			if(rs.getInt(1) == 0 && rs.getString(2) == null) {
				System.out.println("Nemate automobil za placanje");
				return;
			}
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt(1) + " Model: " + rs.getString(2) + " Za placanje: " + rs.getInt(3));
			}
			rs.close();
			ResultSet rs2 = ps.executeQuery();
			boolean dobarID = false;
			System.out.println("Ukucajte ID automobila koji zelite da platite(-1 ako ne zelite da platite nijedan): ");
			int idA = sc.nextInt();
			if (idA == -1) {
				return;
			}
			while(rs2.next()) {
				if(rs2.getInt(1) == idA) dobarID = true;
			}
			if (!dobarID) {
				System.out.println("Uneli ste ID automobila koji niste kupili");
			}
			else {
				System.out.println("Unesite koliko zelite da platite: ");
				int placanje = sc.nextInt();
				if (placanje <=0) {
					System.out.println("Mozete uneti samo vrednosti vece od 0");
					return;
				}
				PreparedStatement ps2 =  con.prepareStatement("SELECT AUTOMOBIL.idauto, model.naziv, IFNULL(automobil.cena,0)-IFNULL(SUM(uplata.iznos),0)"
						+ " FROM Automobil LEFT JOIN model using (IdModel) LEFT JOIN UPLATA using(IdAuto) LEFT JOIN PRODAJA using(IdAuto)"
						+ " WHERE IdAuto = ? AND prodaja.Username = ?"
						+ " GROUP BY IdAuto");
				ps2.setInt(1, idA);
				ps2.setString(2, trenutniUser);
				ResultSet rs3 = ps2.executeQuery();
				if(rs3.getInt(3) == 0) {
					System.out.println("Automobil je vec u potpunosti isplacen");
				}
				else if (placanje > rs3.getInt(3)) {
					System.out.println("Uplata je prevelika, uplatite maksimum " + rs3.getInt(3));
				}
				else {
					LocalDate today = LocalDate.now();
					PreparedStatement ps3 = con.prepareStatement("INSERT INTO UPLATA(IdAuto, Iznos, Datum)"
							+ " VALUES(?, ?, ?)");
					ps3.setInt(1, idA);
					ps3.setInt(2, placanje);
					ps3.setString(3, today.toString());
					ps3.executeUpdate();
					ps3 = con.prepareStatement("UPDATE MODEL" + 
							" SET PROFIT =(" + 
							" SELECT IFNULL(SUM(Iznos),0) - IFNULL(SUm( DISTINCT NABAVNACENA),0)" + 
							" FROM NABAVKA Left JOIN Automobil USING(IdAuto) Left JOIN MODEL USING(IDMODEL) LEFT JOIN Uplata USING(IdAuto)" + 
							" WHERE IdModel  IN (SELECT IdMOdel from Automobil WHERE IdAuto = ?)" + 
							" GROUP BY IdModel)" + 
							" WHERE  IdModel  IN (SELECT IdMOdel from Automobil WHERE IdAuto = ?)"); 
					ps3.setInt(1, idA);
					ps3.setInt(2, idA);
					ps3.executeUpdate();
					rs2.close();
					ps2.close();
					ps3.close();
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void meni() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("[1] Login");
			System.out.println("[2] Registracija korisnika");
			System.out.println("[x] Exit");
			String meniPitanje = sc.nextLine();
			if(meniPitanje.equals("x")) {
				break;
			}
		
			if(meniPitanje.equals("1")) {
				login();
				if(trenutniUser!=null) {
				while(true) {
					if(!trenutniUser.equals("admin")) {
					System.out.println("[1] Kupite automobil");
					System.out.println("[2] Platite automobil");
					System.out.println("[x] Logout");
					System.out.print(">");
					String pitanje = sc.nextLine().toLowerCase();
					if(pitanje.equals("x")) {
						trenutniUser = null;
						break;
					}
					else if (pitanje.equals("1")) {
						kupiAutomobil();
					}
					else if(pitanje.equals("2")) {
						uplata();
					}
				}
					else {
						System.out.println("[1] Menjanje cene neprodatih automobila");
						System.out.println("[2] Pravljenje nabavke");
						System.out.println("[x] Logout");
						String adminPitanje = sc.nextLine();
						if(adminPitanje.equals("x")) {
							trenutniUser=null;
							break;
						}
						else if(adminPitanje.equals("1")) {						
								setCenaAutomobila();
						}
						else if(adminPitanje.equals("2")) {
							napraviNabavku();
						}
					}
				}
			}
			}
			else if (meniPitanje.equals("2")) {
				userReg();
			}

		}
		
		
		
		
	}
	public void kupiAutomobil() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Automobili koje mozete da kupite: ");
		try {
			PreparedStatement ps = con.prepareStatement("SELECT IdAuto, Model.Naziv, Cena" + 
					" FROM Automobil JOIN Model using(IdModel) JOIN Nabavka USING(IdAuto)" + 
					" WHERE IdAuto NOT IN(SELECT IdAuto FROM Prodaja)");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Id Automobila: " +  rs.getInt(1) + " Model: " + rs.getString(2) + " Cena: " + rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Koji automobil zelite da kupite(-1 ne zelite da kupite): ");
		int kupujeAutomobilId = sc.nextInt();
		if(kupujeAutomobilId == -1) {
			return;
		}
		boolean ima = false;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT Nabavka.IdAuto, Model.Naziv, Cena" + 
					" FROM Automobil JOIN Model using(IdModel) JOIN Nabavka USING(IdAuto)" + 
					" WHERE  Nabavka.IdAuto NOT IN (SELECT IdAuto FROM Prodaja)");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == kupujeAutomobilId) {
					ima = true;
				}
			}
			ps = con.prepareStatement("UPDATE AUTOMOBIL"
					+ " SET Status = \"p\""
					+ " WHERE IdAuto = ?");
			ps.setInt(1, kupujeAutomobilId);
			ps.executeUpdate();
			ps = con.prepareStatement("UPDATE MODEL"
					+ " SET BrProdatih = BrProdatih + 1"
					+ " WHERE IdModel IN (SELECT IdModel FROM Automobil WHERE IdAuto = ?)");
			ps.setInt(1, kupujeAutomobilId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!ima) {
			System.out.println("Id automobila koji ste izabrali ne postoji u prodaji");
			System.out.println("");
		} else {
			try {
				LocalDate danas = LocalDate.now();
				PreparedStatement ps = con.prepareStatement("INSERT INTO Prodaja(Idauto, Username, datum)"
						+ " VALUES(?, ?, ?)");
				ps.setInt(1, kupujeAutomobilId);
				ps.setString(2, trenutniUser);
				ps.setString(3, danas.toString());
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		}
	
	}
	
	public void setCenaAutomobila() {
		Scanner sc = new Scanner(System.in);
		if(!trenutniUser.equals("admin")) {
			System.out.println("Samo ADMIN moze da koristi ovu komandu!");
			return;
		}
		try {
			PreparedStatement ps = con.prepareStatement("SELECT IdModel, Model.Naziv,  cena"
					+ " FROM Automobil JOIN Model using(IdModel)"
					+ " WHERE status IS null OR status = \"n\""
					+ " GROUP BY IdModel");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Id modela: " + rs.getInt(1) + " Model: " + rs.getString(2) + " Cena: " + rs.getInt(3));
			}
			System.out.println("Izaberite Id modela ciju cenu zelite da promenite: ");
			int idModelaAutomobila = sc.nextInt();
			System.out.println("Ukucajte cenu koju zelite da postavite: ");
			int cenaAutomobila = sc.nextInt();
			if(cenaAutomobila < 0) {
				System.out.println("Cena ne moze biti negativna!");
			}
			ps = con.prepareStatement("SELECT IdModel"
					+ " FROM Automobil"
					+ " WHERE status IS null OR status = \"n\"");
			rs = ps.executeQuery();
			boolean postoji = false;
			while(rs.next()) {
				if(idModelaAutomobila == rs.getInt(1)) {
					postoji = true;
				}
			}
			if(!postoji) {
				System.out.println("Automobil sa tim Id modela ne postoji");
			}
			else {
				ps = con.prepareStatement("UPDATE  AUTOMOBIL"
						+ " SET cena = ?"
						+ " WHERE IdModel = ?");
				ps.setInt(1, cenaAutomobila);
				ps.setInt(2, idModelaAutomobila);
				ps.executeUpdate();
				ps.close();
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void napraviNabavku() {
		Scanner sc = new Scanner(System.in);
		try {
			PreparedStatement ps = con.prepareStatement("SELECT *"
					+ " FROM Dobavljac");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Id dobavljaca: " + rs.getInt(1) + " Telefon: " + rs.getString(2) + "Info: " + rs.getString(3));
			}
			int idDob = sc.nextInt();
			if(idDob < 0) {
				System.out.println("Los id");
				return;
			}
			 ps = con.prepareStatement("SELECT IdDob"
					+ " FROM Dobavljac");
			 rs = ps.executeQuery();
			 boolean postoji = false;
			 while(rs.next()) {
				 if(idDob == rs.getInt(1)) {
					 postoji = true;
				 }
			 }
			 if(!postoji) {
				 System.out.println("Izabrani dobavljac ne postoji!");
				 return;
			 }
			 else {
				  ps = con.prepareStatement("SELECT IdMOdel, Naziv"
							+ " FROM Model");
					 rs = ps.executeQuery();
					 while(rs.next()) {
						 System.out.println("ID modela: " + rs.getInt(1) + " Naziv: " + rs.getString(2));
					 }
				 System.out.println("Koji model automobila zelite da kupite");
				 int idModela = sc.nextInt();
				 ps = con.prepareStatement("SELECT IdModel"
				 		+ " FROM Model");
				 rs = ps.executeQuery();
				 postoji = false;
				 while(rs.next()) {
					 if(rs.getInt(1) == idModela) {
						 postoji = true;
					 }
				 }
				 if(!postoji) {
					 System.out.println("Izabrani model automobila ne postoji");
					 return;
				 }
				 else {
					 System.out.println("Ukucajte cenu za koju zelite da kupite automobil: ");
					 int nabavnaCena = sc.nextInt();
					 if (nabavnaCena < 0) {
						 System.out.println("Ukucali ste cenu koja nije validna");
						 return;
					 }
					 System.out.println("Ukucajte prodajnu cenu: ");
					 int prodajnaCena = sc.nextInt();
					 if (prodajnaCena < 0) {
						 System.out.println("Ukucali ste cenu koja nije validna");
						 return;
					 }
					 ps = con.prepareStatement("INSERT INTO Automobil(Idmodel,Cena,IdDob, Status)"
					 		+ " VALUES(?,?,?,\"n\")");
					 ps.setInt(1, idModela);
					 ps.setInt(2, prodajnaCena);
					 ps.setInt(3, idDob);
					 ps.executeUpdate();
					 ps = con.prepareStatement("UPDATE MODEL"
					 		+ " SET BrNabavljenih = BrNabavljenih + 1, Profit = Profit - ?"
					 		+ " WHERE IdModel = ?");
					 ps.setInt(1, nabavnaCena);
					 ps.setInt(2, idModela);
					 ps.executeUpdate();
					 ps = con.prepareStatement("INSERT INTO NABAVKA(IdAuto,NabavnaCena)"
					 		+ " VALUES((SELECT MAX(IdAuto) FROM Automobil),?)");
					 ps.setInt(1, nabavnaCena);
					 ps.executeUpdate();
					 ps.close();
					 rs.close();
				 }
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 

	public boolean blanko(String s) {
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==' ') {
				return true;
			}
		}
		return false;
	}
	public boolean veceOd5(String s) {
		if(s.length() >= 5) {
			return true;
		} else return false;
	}
	private void trenutniUser(String s) {
		trenutniUser = s;
	}
	public String getTrenutni() {
		return trenutniUser;
	}
}
