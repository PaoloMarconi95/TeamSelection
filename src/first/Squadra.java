package first;

import java.util.ArrayList;

public class Squadra { 
	public boolean[][] disp ;
	public int id ;
	public ArrayList<Integer> avversari ; // = new ArrayList<int>();
	
	public Squadra(int id){
		this.id = id ;
		//this.id = (char) (id + 97) ; // assegna ad ogni squarda una lettera come id
	}
	
	public void annulla(int c, int r, int totSq){
		for(int i = 0 ; i < totSq/2 ; i++)
			this.disp[c][i] = false ;
		for(int i = 0 ; i < totSq/2 ; i++)
			this.disp[i][r] = false ;
	}
	
	public void inserisciAvversario(Squadra s){
		this.avversari.add(s.id) ;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
