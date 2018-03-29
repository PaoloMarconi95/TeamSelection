package first;

import java.util.Random ;

public class Metodi {
	
	public static int numeroRandom(int min , int max){
		Random r = new Random();
		int n = r.nextInt( (max + 1) - min) ;
		return n + min;
	}
	
	
	public static boolean[][] trueTab(int n) {
		boolean[][] tab = new boolean[n][n] ;
		for(int j = 0 ; j < n ; j++)
			for(int i = 0 ; i < n ; i++)
				tab[j][i] = true ;
		return tab ;
	}

}
