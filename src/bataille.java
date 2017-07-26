import java.util.Scanner;


public class bataille {

	public static void main(String[] args) {
		int run = 5;
		
		// déclaration de 2 tableaux, celui ou est le bateau et celui qui comptabilise les éssais 
		int[][] mer = new int[10][10];
		char[][] essai = new char[10][10];
		
		// placement du bateau par un seul point sur 2 axes (x, y)
		int x = (int) (Math.random() * (9+1-0) + 0);
		int y = (int) (Math.random() * (9+1-0) + 0);
		System.out.println("Triche debug");
		System.out.println(x+" "+y);
		System.out.println();
		System.out.println("Bataille navalle, grille 10x10");
		int testX = 0;
		int testY = 0;
		Scanner scan = new Scanner(System.in);
		
		
		
		// tant qu'il reste des éssais le jeu continu
		while(run != 0) {
			
			// check x plus grand que tableau
			if(x+2 > mer.length){			// si le bateau dépasse du tableau 
				mer[x][y] = 1;				// on le pose a partir du point
				mer[x-1][y] = 1;			// et recule jusqu'a x-1 et x-2
				mer[x-2][y] = 1;
			} else if (y+2 > mer.length) {	// sinon s'il est plus grand sur y 
				mer[x][y] = 1;				// placement en y-1 y-2
				mer[x][y-1] = 1;
				mer[x][y-2] = 1;
			} else if (x+2 > mer.length && y+2 > mer.length) {
				mer[x][y] = 1;
				mer[x-1][y] = 1;
				mer[x-2][y] = 1;
			} else {						// sinon placement normal
				mer[x][y] = 1;
				mer[x+1][y] = 1;
				mer[x+2][y] = 1;			
			}
			
			System.out.println("Entrez une coordonnées en x :");
			System.out.println("(0 -> 9)");
			testX = scan.nextInt();
			System.out.println("Entrez une coordonnées en y :");
			System.out.println("(0 -> 9");
			testY = scan.nextInt();
			
			// test si coordonnées x y correspondent au bateau 
			if(mer[testX][testY] == 1) {			// si oui 
				System.out.println("KABOOM !");		// gagné
				break;
			} else {								// sinon 
				System.out.println("plouf...");		// raté
				essai[testX][testY] = 'X';			// affichage sur la carte 
				run--;								// décrémentation essai
				System.out.println("Il reste "+run+ " essais.");
				
			}
			
			for (int i = 0; i < mer.length; i ++) {
				for(int j = 0; j < mer.length; j++) {
					System.out.print("["+essai[i][j]+"]");
				}
				System.out.println();
			}
		}
		System.out.println("Fin de partie");
	}
}
