package first;

public class Main {
	public static Griglia MainAlgorithm(int n_squadre ) throws Exception{
		while( ( ( n_squadre % 2 ) != 0 ) &&  ( n_squadre > 0 ) ) {
			throw new Exception() ;
		}
		//Entro  nel vero e proprio algoritmo
		Griglia griglia = null ;
		//int attempt = 0 ;
		boolean cond = true ;
		while(cond){
			try {
				griglia = new Griglia(n_squadre) ;	
				Squadra[] Squadre = new Squadra[n_squadre] ;
				//Creazione degli oggetti squadra, viene passato il contatore "i" per id_squadra 
				for(int i = 0 ; i < n_squadre ; i++)
					Squadre[i] = new Squadra(i, n_squadre) ;
				//attempt++ ;
				griglia.generaGriglia(Squadre) ;
				cond = false ;
			}catch(Exception e){;
			}
		} ;
		return griglia ;
	}
}
