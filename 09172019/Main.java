package titlovi_;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(Integer.parseInt(args[0]) == 2) {
			String [] proveraUlaz = args[1].split("\\.");
			if(proveraUlaz.length > 2) {
				System.out.println("Los unos");
				System.exit(-1);
			}
			if(!proveraUlaz[1].toLowerCase().equals("srt")) {
				System.out.println("Los format, morate uneti za ulaz srt fajl");
				System.exit(-1);
			}
			String [] proveraIzlaz = args[2].split("\\.");
			if(!proveraIzlaz[1].toLowerCase().equals("txt")) {
				System.out.println("Los format, morate uneti za izlaz txt fajl");
				System.exit(-1);
			}
			try {
				Convert.srtToTxt(args[1], args[2]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(Integer.parseInt(args[0]) == 4) {
			String [] proveraUlaz = args[1].split("\\.");
			if(proveraUlaz.length > 2) {
				System.out.println("Los unos");
				return;
			}
			if(!proveraUlaz[1].toLowerCase().equals("txt")) {
				System.out.println("Los format, morate uneti za ulaz txt fajl");
				System.exit(-1);
			}
			String [] proveraIzlaz = args[2].split("\\.");
			if(!proveraIzlaz[1].toLowerCase().equals("srt")) {
				System.out.println("Los format, morate uneti za izlaz srt fajl");
				System.exit(-1);
			}
			try {
				Convert.txtToSrt(args[1], args[2]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
