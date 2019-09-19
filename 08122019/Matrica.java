package trinaestipaket;

import java.util.Random;
import java.util.Scanner;

public class Matrica {
    //NIJE DOZVOLJENO MENJANJE MAIN FUNKCIJE!!!!!!!!!!!!!!
    //NIJE DOZOVLJENO MENJANJE POTPISA FUNKCIJA(POTPIS FUNKCIJE SE SASTOJI OD POVRATNE VREDNOSTI, IMENA FUNKCIJE I PARAMETARA
    //DOZVOLJENO JE ALI NIJE POZELJNO NITI POTREBNO DEFINISATI I DODAVATI NOVE FUNKCIJE
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite dimenziju kvadratne matrice (n): ");
        int n = sc.nextInt();

        int[][] matrica = new int[n][n];
        generisiElementeMatrice(matrica, 100);
        System.out.println("Matrica izgleda ovako: ");
        ispisiMatricu(matrica);
        System.out.println();

        int[] elementiNaglavnoj = elementiNaGlavnojDijagonali(matrica);
        System.out.println("Elementi na glavnoj dijagonali su: ");
        if(elementiNaglavnoj!=null) ispisiNiz(elementiNaglavnoj);
        else System.out.println("Greska u funkciji elementiNaGlavnojDijagonali");
        System.out.println();

        System.out.println("Elementi na sporednoj dijagonali su: ");
        int[] elementiNaSporednoj = elementiNaSporednojDijagonali(matrica);
        if(elementiNaSporednoj!=null) ispisiNiz(elementiNaSporednoj);
        else System.out.println("Greska u funkciji elementiNaSporednojDijagonali");
        System.out.println();

        System.out.println("Elementi iznad glavne dijagonale su: ");
        ispisiElementeIznadGlavneDijagonale(matrica);
        System.out.println();

        System.out.println("Elementi ispod glavne dijagonale su: ");
        ispisiElementeIspodGlavneDijagonale(matrica);
        System.out.println();

        int[][] transponovanaMatrica = transponujMatricu(matrica);
        System.out.println("Transponovana matrica izgleda ovako: ");
        if(transponovanaMatrica!=null)ispisiMatricu(transponovanaMatrica);
        else System.out.println("Greska u funkciji transponujMatricu.");
        System.out.println();

        System.out.println("Pre uklanjanja duplih elemenata niz izgleda ovako: ");
        ispisiNiz(elementiNaglavnoj);
        System.out.println();

        elementiNaglavnoj = ukloniElementeKojiSePonavljajuUnizu(elementiNaglavnoj);
        System.out.println("Nakon uklanjanja duplih elemenata niz izlgeda ovako: ");
        if(elementiNaglavnoj!=null) ispisiNiz(elementiNaglavnoj);
        else System.out.println("Greska u funkcji ukloniElementeKojiSePonavljajuUnizu");

    }

    public static void generisiElementeMatrice(int[][] matrica, int gornjaGranica){
        //TODO 
    	Random r = new Random();
    	for (int i =0; i<matrica.length; i++) {
    		for (int j =0; j<matrica[i].length; j++) {						// matrica[i].length u slucaju da je pravougaonik 3x5 npr, inace moze i matrica.length
    			matrica[i][j] = r.nextInt(gornjaGranica+1);
    		}
    	}
    }

    public static int[] elementiNaGlavnojDijagonali(int[][] matrica){
        //TODO
    	 int [] dijagonala = new int [matrica.length];
    	 for (int i =0; i<matrica.length; i++) {
    		 for (int j =0; j<matrica[i].length; j++) {
    			 if (i == j) {
    				 dijagonala[i] = matrica[i][j];
    			 }
    		 }
    	 }

        return dijagonala; 	//STOJI OVDE SAMO DA SE KOMPAJLER NE BI BUNIO STO FUNKCIJA KOJA VRACA POVRATNU VREDNST NEMA RETRUN U SEBI
                     		//NAKON STO IMPLEMENTIRATE FUNKCIJU, ZAMENITE OVAJ RETURN NULL NEKIM KOJI VI MISLITE DA TREBA
                     		//ISTO VAZI I ZA FUNKCIJE ISPOD KOJE IMAJU RETURN NULL
    }

    public static int[] elementiNaSporednojDijagonali(int[][] matrica){
        //TODO
    	 int [] dijagonala = new int [matrica.length];
    	 for (int i =0; i<matrica.length; i++) {
    		 for (int j =0; j<matrica[i].length; j++) {
    			 if (i+j == matrica.length-1) {
    				 dijagonala[i] = matrica[i][j];
    			 }
    		 }
    	 }
        return dijagonala;
    }

    public static int[][] transponujMatricu(int[][] matrica){
        //TODO
    	int [][] trans = new int [matrica[0].length][matrica.length];
    	for (int i =0; i<matrica[0].length; i++) {							// ovo matrica[0] sam stavljao da bi radilo u slucaju da nisu 3x3 matrice, nego npr 3x5
    		for (int j =0; j<matrica.length; j++) {
    			trans[i][j] = matrica[j][i]; 
    		}
    	}

        return trans;
    }

    public static void ispisiElementeIznadGlavneDijagonale (int[][] matrica){
        //TODO
    	for (int i =0; i<matrica.length; i++) {
    		for (int j =0; j<matrica[i].length; j++) {
    			if (j > i) {
    				System.out.print(matrica[i][j] + " ");
    			} else {
    				System.out.print("* " + " ");
    			}
    		}
    		System.out.println();
    	}
    }

    public static void ispisiElementeIspodGlavneDijagonale (int[][] matrica){
        //TODO
    	for (int i =0; i<matrica.length; i++) {
    		for (int j =0; j<matrica[i].length; j++) {
    			if (j < i) {
    				System.out.print(matrica[i][j] + " ");
    			} else {
    				System.out.print("* " + " ");
    			}
    		}
    		System.out.println();
    	}
    }

    public static void ispisiMatricu(int[][] matrica){
        //TODO
    	for (int i =0; i<matrica.length; i++) {
    		for (int j =0; j< matrica[i].length; j++) {
    			System.out.print(matrica[i][j] + " ");
    		}
    		System.out.println();
    	}
    }

    public static void ispisiNiz(int[] niz){
        //TODO
     	for (int i = 0; i<niz.length; i++) {
    		System.out.print(niz[i] + " ");
    	}
    }

    public static int[] ukloniElementeKojiSePonavljajuUnizu(int[] niz){
        //TODO
    	int dupli = 0;
    	for (int i = 0; i<niz.length-1; i++) {
    		for (int j = i+1; j < niz.length; j++) {
    			if (niz[i] == niz[j]) {
    				dupli++;
    				break;
    			}
    		}
    	}
        int [] bezDuplih = new int [niz.length-dupli];     
    	boolean duplikati = false;
        for (int i =0, k=0; i<niz.length; i++) {
        	for (int j= i+1; j<niz.length; j++) {
        		if (niz[i] == niz[j]) {
        			duplikati = true;
        			break;
        		}        		
        	}
        	if (!duplikati) {
    			bezDuplih[k] = niz[i];
    			k++;
    		}
        	duplikati = false;
        }
        return bezDuplih;
    }




}






