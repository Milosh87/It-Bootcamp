package jedanestidomaci;

public class PrviZadatak {

	public static void main(String[] args) {
		int[][] a = { 
				{ 1, 2, 8, 9 }, 
				{ 21, 2, 1, -105, 6 }, 
				{ 3, 3, 89, 2, 142 }
			};
		int [] minMax = minMax(a);
		ispisi2dNiz(a);
		System.out.printf("Minimum niza = %d, a maksimum = %d",minMax[0], minMax[1]);
		
	}
	static int [] minMax(int [][] a) {						// funkcija koja vraca min i max vrednost niza
		int min = a[0][0];
		int max = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] < min) {
					min = a[i][j];
				}
				if (a[i][j] > max) {
					max = a[i][j];
				}
			}
		}
		int[] minMax = { min, max };
		return minMax;
	}
	
	static void ispisi2dNiz(int [][] a) {				// funkcija koja ispisuje 2d niz
		for (int i =0; i<a.length; i++) {
			System.out.print("[");
			for (int j =0; j<a[i].length;j++) {
				if (j == a[i].length -1) {
					System.out.print(a[i][j]);
				} else
				System.out.print(a[i][j] + " , ");
			}
			System.out.println("]");
		}
	}
}
