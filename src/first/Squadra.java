package first;

import java.util.ArrayList;

public class Squadra { 
	public boolean[][] disp ;
	public int id ;
	public ArrayList<Squadra> avversari = new ArrayList<Squadra>();
	
	
	public Squadra(int id, int n_squadre){
		this.id = id ;
		//this.id = (char) (id + 97) ; // assegna ad ogni squarda una lettera come id
		this.disp = Metodi.trueTab(n_squadre/2) ;
		avversari.add(this) ;
	}
	
	public void annulla(int r, int c, int totSq){
		for(int i = 0 ; i < totSq/2 ; i++)
			this.disp[r][i] = false ;
		for(int i = 0 ; i < totSq/2 ; i++)
			this.disp[i][c] = false ;
	}
	
	public void inserisciAvversario(Squadra s){
		this.avversari.add(s) ;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
