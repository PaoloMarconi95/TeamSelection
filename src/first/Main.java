package first;

import java.util.Scanner ;

public class Main {
	public static void main(String[] args ){
		Scanner kb = new Scanner(System.in) ;
		//Scelta numero di Squadre
			System.out.println("Inserisci il numero di squadre ") ;
			int n_squadre = kb.nextInt();
		while( ( ( n_squadre % 2 ) != 0 ) &&  ( n_squadre > 0 ) ) {
			System.out.println("Inserisci un numero pari di squadre");
			n_squadre = kb.nextInt();
		}
		//Entro  nel vero e proprio algoritmo
		Griglia griglia = null ;
		int attempt = 0 ;
		boolean cond = true ;
		while(cond){
			try {
				griglia = new Griglia(n_squadre) ;	
				Squadra[] Squadre = new Squadra[n_squadre] ;
				//Creazione degli oggetti squadra, viene passato il contatore "i" per id_squadra 
				for(int i = 0 ; i < n_squadre ; i++)
					Squadre[i] = new Squadra(i, n_squadre) ;
				attempt++ ;
				griglia.generaGriglia(Squadre) ;
				cond = false ;
			}catch(Exception e){
				System.out.print(e.getMessage());
			}
		}
		griglia.stampaGriglia() ;
		System.out.println("\nce l'ho fatta in " + attempt + " tentativi") ;
		kb.close();
	}
}
