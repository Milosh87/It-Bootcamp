package tetris;

public class Kvadrat extends Blok2x2 {
	public Kvadrat() {
		for (int i=0; i<niz.length; i++) {
			for (int j=0; j<niz[i].length; j++) {
				niz[i][j] = 'c';
			}
		}
		niz[0][0] = '#';
		niz[0][1] = '#';
		niz[1][0] = '#';
		niz[1][1] = '#';
	}
	
	
	
	public void rotate() {
		
	 return;
	}
		
	public  String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<niz.length; i++) {
			for(int j=0; j<niz.length; j++) {
				sb.append(niz[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
