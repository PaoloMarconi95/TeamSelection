package first;
import java.util.ArrayList;

public class Griglia {
	public String[][] tabella ;
	public int max ;
	
	public Griglia(int n) {
		String[][] tab = new String[n/2][n/2] ;
		this.tabella = tab ;
		this.max = n/2 ;
	}
	
	/*public void generaGriglia(Squadra[] squadre){
		int tentativi2 ;
		boolean uscita = false ;
		for(int c = 0 ; c < this.max ; c++){
			for(int r = 0 ; r < this.max ; r++) {
				int sq1 ;
				int sq2 ;
				do{
					sq1 = 0 ;
					sq2 = 0 ;
					ArrayList<Integer> n1Estratti = new ArrayList<Integer>();
					ArrayList<Integer> n2Estratti = new ArrayList<Integer>();
					sq1 = Metodi.numeroRandom(0, squadre.length - 1) ;
					n1Estratti.add(sq1) ;
					while( !(squadre[sq1].disp[c][r]) ){
						if( !(n1Estratti.contains(sq1)) )
							n1Estratti.add(sq1);
						do{
							sq1 = Metodi.numeroRandom(0, squadre.length - 1) ;
						  }while( n1Estratti.contains(sq1) ) ;
						} // fine scelta prima squadra
						tentativi2 = 0 ;
						sq2 = Metodi.numeroRandom(0, squadre.length - 1) ;
						n2Estratti.add(sq2) ;
						while( ( !(squadre[sq2].disp[c][r]) || ( squadre[sq2].avversari.contains(squadre[sq1]) ) || (squadre[sq2].id == squadre[sq1].id) ) && (tentativi2 < (squadre.length + 2) ) ) {
							if( !(n2Estratti.contains(sq2)) )
								n2Estratti.add(sq2);
							do{
								if(n2Estratti.size() == squadre.length)
									uscita = true ;
								sq2 = Metodi.numeroRandom(0, squadre.length - 1) ;
							} while( n2Estratti.contains(sq2) && !uscita ) ;
							tentativi2++ ;
						} // fine scelta seconda squadra
				}while(tentativi2 > (squadre.length + 2) ) ;
				squadre[sq1].annulla(c, r, this.max) ;
				squadre[sq2].annulla(c, r, this.max) ;
				squadre[sq1].inserisciAvversario(squadre[sq2]) ;
				this.tabella[c][r] = (String) ( (char) (squadre[sq1].id + 97 ) + "-" + (char) (squadre[sq2].id + 97) + "   ") ;
				}
		}
	} */
	
	public void generaGriglia(Squadra[] squadre){
		for(int c = 0 ; c < this.max ; c++){
			for(int r = 0 ; r < this.max ; r++) {
			int idsquadra1 ;
			int idsquadra2 ;
			ArrayList<Integer> Estraibili = new ArrayList<Integer>() ;
			for(int i = 0 ; i < squadre.length ; i++ )
				Estraibili.add(squadre[i].id) ; // inserisco tutte le squadre nell'array ESTRAIBILI
			do { // scelta prima squadra
				int random = Metodi.numeroRandom(0, Estraibili.size() - 1) ;
				idsquadra1 = Estraibili.get(random) ;
				Estraibili.remove(squadre[idsquadra1].id) ;
			}while( !squadre[idsquadra1].disp[c][r] ) ; // quando la squadra scelta è disponibile, si esce dal ciclo
			do {
				int random = Metodi.numeroRandom(0, Estraibili.size() - 1) ;
				idsquadra2 = Estraibili.get(random) ;
				Estraibili.remove(squadre[idsquadra2].id) ;
			}while ( !squadre[idsquadra2].disp[c][r] || 
					squadre[idsquadra1].avversari.contains(squadre[idsquadra2])) ;
			}
		}
		
	}
	
	
	public void stampaGriglia() {
		short riga = 0 ;
		for(int i = 0 ; i < this.max; i++)
		System.out.print(" " + "Gioco" + (i + 1) );
		System.out.println("");
		for(int c = 0 ; c < this.max ; c++){
			if(c != 0)
				System.out.println("");
			riga++ ;
			for(int r = 0 ; r < this.max ; r++) {
				if(r == 0)
				System.out.print(riga + " " + this.tabella[c][r]);
				else
					System.out.print(" " + this.tabella[c][r]);
			}
		}	
	}
	
	
}

