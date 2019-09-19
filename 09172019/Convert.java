package titlovi_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Convert {

	public static void srtToTxt(String ulaz, String izlaz) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(ulaz));
		BufferedWriter writer = new BufferedWriter(new FileWriter(izlaz));
		String line;
		String konacno = "";
		String trenutno = "";
		int brojac = 0;
		while ((line = br.readLine()) != null) {
			if (!line.matches("[0-9]+")) {
				if (line.contains(" --> ")) {
					String novi = line.replace("-->", ":");
					String[] splitByTacke = novi.split(":");
					splitByTacke[2] = splitByTacke[2].replace(",", ".");
					splitByTacke[5] = splitByTacke[5].replace(",", ".");
					double satiOd = Double.parseDouble(splitByTacke[0]);
					double minutiOd = Double.parseDouble(splitByTacke[1]);
					double sekundeOd = Double.parseDouble(splitByTacke[2]);
					double satiDo = Double.parseDouble(splitByTacke[3]);
					double minutiDo = Double.parseDouble(splitByTacke[4]);
					double sekundeDo = Double.parseDouble(splitByTacke[5]);
					double frameOd = Math.ceil((double) (satiOd * 60 * 60 + minutiOd * 60 + sekundeOd) * 25);
					double frameDo = Math.ceil((double) (satiDo * 60 * 60 + minutiDo * 60 + sekundeDo) * 25);
					int pocetak = (int) frameOd;
					int kraj = (int) frameDo;
					konacno += "{" + pocetak + "}" + "{" + kraj + "}";
				} else if (!line.matches("[0-9]+") && !line.matches("")) {

					if (brojac > 0) {
						trenutno += "|";
					}
					if (line.contains("<i>")) {
						trenutno += line.replace("<i>", "{Y:i}");
						brojac++;
					} else {
						trenutno += line;
						brojac++;

					}

				}
			}
			if (line.matches("")) {
				if (trenutno.contains("{Y:i}")) {
					konacno += trenutno.substring(0, trenutno.length() - 4) + "\n";
					brojac = 0;
					trenutno = "";
				} else {
					konacno += trenutno + "\n";
					brojac = 0;
					trenutno = "";
				}
			}

		}
		konacno += trenutno;
		br.close();
		writer.write(konacno);
		writer.close();

	}

	public static void txtToSrt(String ulaz, String izlaz) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				ulaz));
		BufferedWriter writer = new BufferedWriter(new FileWriter(izlaz));
		String line;
		int i = 1;
		String konacno = "";
		while ((line = br.readLine()) != null) {
			String[] bezZagrada = line.split("}");
			konacno += i + "\n";
			String nova = line.replace("{Y:i}", "<i>");
			int vremeOdSekunde = Integer.parseInt(bezZagrada[0].substring(1)) / 25;
			int vremeDoSekunde = Integer.parseInt(bezZagrada[1].substring(1)) / 25;
			int vremeOdSati = 0;
			int vremeOdMinuti = 0;
			int vremeDoSati = 0;
			int vremeDoMinuti = 0;
			double milisekundeOd = Double.parseDouble(bezZagrada[0].substring(1)) / 25;
			double milisekundeDo = Double.parseDouble(bezZagrada[1].substring(1)) / 25;
			String milisecOd = String.valueOf(milisekundeOd);
			milisecOd = milisecOd.substring ( milisecOd.indexOf ( "." )+1 );
			String milisecDo = String.valueOf(milisekundeDo);
			milisecDo = milisecDo.substring ( milisecDo.indexOf ( "." ) +1);
			if(Integer.parseInt(milisecDo) == 0) {
				milisecDo = "000";
			}
			else if(Integer.parseInt(milisecDo) < 10) {
				milisecDo =  "0" + Integer.parseInt(milisecDo) + "0"; 
			}
			else if(Integer.parseInt(milisecDo) < 100) {
				milisecDo =  Integer.parseInt(milisecDo) + "0";
			}
			if(Integer.parseInt(milisecOd) == 0) {
				milisecOd = "000";
			}
			if(Integer.parseInt(milisecOd) < 10) {
				milisecOd = "0" + Integer.parseInt(milisecOd) +"0" ;
			}
			else if(Integer.parseInt(milisecOd ) < 100) {
				milisecOd =Integer.parseInt(milisecOd) + "0";
			}
			String sekundeOd;
			String sekundeDo;
			String minutiOd;
			String minutiDo;
			String satiOd;
			String satiDo;
			while (vremeOdSekunde >= 60) {
				vremeOdMinuti++;
				vremeOdSekunde -= 60;
			}
			while (vremeDoSekunde >= 60) {
				vremeDoMinuti++;
				vremeDoSekunde -= 60;
			}
			while (vremeDoMinuti >= 60) {
				vremeDoSati++;
				vremeDoMinuti -= 60;
			}
			while (vremeOdMinuti >= 60) {
				vremeOdSati++;
				vremeOdMinuti -= 60;
			}
			if (vremeOdSekunde < 10) {
				sekundeOd = "0" + vremeOdSekunde;
			} else {
				sekundeOd = Integer.toString(vremeOdSekunde);
			}
			if (vremeDoSekunde < 10) {
				sekundeDo = "0" + vremeDoSekunde;
			} else {
				sekundeDo = Integer.toString(vremeDoSekunde);

			}
			if (vremeOdMinuti < 10) {
				minutiOd = "0" + vremeOdMinuti;
			} else {
				minutiOd = Integer.toString(vremeOdMinuti);

			}
			if (vremeDoMinuti < 10) {
				minutiDo = "0" + vremeDoMinuti;
			} else {
				minutiDo = Integer.toString(vremeDoMinuti);

			}
			if (vremeOdSati < 10) {
				satiOd = "0" + vremeOdSati;
			} else {
				satiOd = Integer.toString(vremeOdSati);

			}
			if (vremeDoSati < 10) {
				satiDo = "0" + vremeDoSati;
			} else {
				satiDo = Integer.toString(vremeDoSati);

			}

			String vreme = satiOd + ":" + minutiOd + ":" + sekundeOd + "," +milisecOd +" --> " + satiDo + ":" + minutiDo + ":"
					+ sekundeDo + "," + milisecDo;
			konacno += vreme + "\n";
			String splitByZagrada = nova.split("}")[2];
			String[] splitByWord = splitByZagrada.split("\\|");
			for (int j = 0; j < splitByWord.length; j++) {
				if (!splitByWord[j].contains("}")) {
					if (j == splitByWord.length - 1) {
						if (nova.contains("<i>")) {
							konacno += splitByWord[j] + "</i>" + "\n";
						} else
							konacno += splitByWord[j] + "\n";
					} else
						konacno += splitByWord[j] + "\n";
				}

			}

			konacno += "\n";

			i++;

		}
		writer.write(konacno);
		writer.close();
		br.close();

	}

}
