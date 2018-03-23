package first;

import java.util.Scanner ;

public class Main {
	public static void main(String[] args ){
		Scanner kb = new Scanner(System.in) ;
		//Scelta numero di Squadre
			System.out.println("Inserisci il numero di squadre ") ;
			int n_squadre = kb.nextInt();
		while( ( n_squadre % 2 ) != 0 ) {
			System.out.println("Inserisci un numero pari di squadre");
			n_squadre = kb.nextInt();
		}
		Griglia griglia = new Griglia(n_squadre) ;	
		Squadra[] Squadre = new Squadra[n_squadre] ;
		//Creazione degli oggetti squadra, viene passato il contatore "i" come fosse id_squadra 
		for(int i = 0 ; i < n_squadre ; i++){ 
			Squadre[i] = new Squadra(i) ;
			Squadre[i].disp = Metodi.trueTab(n_squadre/2) ;
		}
		//Vero e proprio algoritmo
		griglia.generaGriglia(Squadre) ;
		griglia.stampaGriglia() ;
		kb.close();
	}
}
