package tetris;

public class BlokI extends Blok4x4 {
	
	public BlokI() {
		for (int i=0; i<niz.length; i++) {
			for (int j=0; j<niz[i].length; j++) {
				niz[i][j] = ' ';
			}
		}
		niz[0][2] = '#';
		niz[1][2] = '#';
		niz[2][2] = '#';
		niz[3][2] = '#';
	}
	
	
	
	public void rotate() {
		int k = 2;   	// 2,2  fiksne koordinate oko kojeg se ostale rotiraju
		int f = 2;
		char [][] novi = new char [5][5];
		for (int i=0; i<niz.length; i++) {
			for (int j=0; j<niz[i].length; j++) {
				if(niz[i][j] == '#') {
					if(i == k && j == f) {
						novi[2][2] = niz[i][j];
					}
					else {
				int koordinate[] = coords(k,f,i,j);
				novi[koordinate[0]][koordinate[1]] = niz[i][j]; 
					}
				} 
				
			}
		}
		
	niz = novi;
	}
	private int [] coords(int k, int f, int i, int j) {
		int gornja = i-k;
		int donja = j-f;
		int [] koordinate = new int[2];
		koordinate[0] = k + ((gornja*0) + (donja * -1));								
		koordinate[1] = f + ((gornja * 1) + (donja * 0));
		return koordinate;
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
