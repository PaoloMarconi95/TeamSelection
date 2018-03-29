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
	
	public void generaGriglia(Squadra[] squadre) throws RetryException{
		for(int r = 0 ; r < this.max ; r++) {
			for(int c = 0 ; c < this.max ; c++){
				Squadra squadra1 ;
				Squadra squadra2 ;
				ArrayList<Squadra> Estraibili = new ArrayList<Squadra>() ; // ESTRAIBILI conterrà le squadre
				for(int i = 0 ; i < squadre.length ; i++ ){
					if(squadre[i].disp[r][c])
						Estraibili.add(squadre[i]) ; // inserisco tutte le squadre nell'array ESTRAIBILI
				}
				int max = Estraibili.size() - 1 ;
				/* if(max == 1) // se ho solo 1 elemento valido per la prima squadra, riparto da 0
					throw new RetryException("Griglia non Valida") ; */									
				int random = Metodi.numeroRandom(0, max) ;
				squadra1 = Estraibili.get(random) ;
				Estraibili.remove(squadra1) ;
				boolean ripesca = false ;
				do {
					max = Estraibili.size() - 1 ;
					random = Metodi.numeroRandom(0, max) ;
					squadra2 = Estraibili.get(random) ;
					if(squadra1.avversari.contains(squadra2)){
						if(squadra2.avversari.contains(squadra1)){
							Estraibili.remove(squadra2) ;
							ripesca = true ;
						}
						else
							squadra2.inserisciAvversario(squadra1);
					}
					else
						squadra1.inserisciAvversario(squadra2);
				}while ( ripesca ) ;
				squadra1.annulla(r, c, squadre.length) ;
				squadra2.annulla(r, c, squadre.length) ;
				this.tabella[r][c] = (String) ( (char) (squadra1.id + 97 ) + "-" + (char) (squadra2.id + 97) + "   ") ;
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

