package hr.razv.h2.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.Character;

public class ListeClanova {

	public String[][] matricaSus;

	public ListeClanova (String matricaSus[][]) {
	
		this.matricaSus = matricaSus;
		
	}
				
	public ModelRjesenje izracunajPut () {
		
		int n = matricaSus[0].length;
		
		ArrayList<Clan> S = new ArrayList<Clan>();
		ArrayList<Clan> T = new ArrayList<Clan>();
		ArrayList<Character> put = new ArrayList<Character>();
		int razlika, indexZadnji, duljinaPuta;
		Character krajnjaTocka = new Character('A');
		
			
		Clan a = new Clan('A', 0);
		S.add(a);
				
				
		//POPUNJAVANJE PO�ETNE 'T' LISTE
		
		Clan b,c;
		
		for (int i=1; i<n; i++) {
			
			if (!matricaSus[i][0].equals("#")) {
				b = new Clan((char)(65+i), Integer.valueOf(matricaSus[i][0]));
			}
			else {
				b = new Clan((char)(65+i), (char)'#');
			}
			
			if ( i==(n-1) ) {
				krajnjaTocka = b.getTocka();
			}
			
			T.add(b);
				
		}
		
		//DODAVANJE U 'S' LISTU
		
		while (T.size()>0) {
		
			int indexMinUdaljenost=0;
			int minUdaljenost = T.get(0).getUdaljenost();
			char minTocka = T.get(0).getTocka();
			
			for (int i=1; i<T.size(); i++) {
				
				if (T.get(i).getBesk() != '#' && T.get(i).getUdaljenost() < minUdaljenost) {
					minUdaljenost = T.get(i).getUdaljenost();
					minTocka = T.get(i).getTocka();
					indexMinUdaljenost = i;
								
				}
							
			}
			
			c = new Clan(minTocka, minUdaljenost);
			S.add(c);
			if ( krajnjaTocka.equals(c.getTocka() ) ) {
				break;
			}
			T.remove(indexMinUdaljenost);
					
						//MODIFICIRANJE NOVIH UDALJENOSTI U 'T' LISTI
			for (int i=0; i<T.size(); i++) {
				
				String sljedecaUdaljenost = matricaSus [(int)minTocka-65][(int)T.get(i).getTocka()-65];
							
				if (!sljedecaUdaljenost.equals("#"))
					if  (minUdaljenost + Integer.valueOf(sljedecaUdaljenost) < T.get(i).getUdaljenost()) {
							T.get(i).setUdaljenost(minUdaljenost + Integer.valueOf(sljedecaUdaljenost));
						}
				if (T.get(i).getBesk() == '#' && (!sljedecaUdaljenost.equals("#"))) {
						T.get(i).setUdaljenost(minUdaljenost + Integer.valueOf(sljedecaUdaljenost));
						T.get(i).setBesk(' ');
				}
			
			}
		

		}
		
		
				//PUNJENJE PUTA
		
		indexZadnji = S.size()-1;
		put.add(S.get(indexZadnji).getTocka());
				
		for (int i=S.size()-2; i>=0; i--) {		
					
			razlika = S.get(indexZadnji).getUdaljenost() - S.get(i).getUdaljenost();
			
			String stringZaProvjeru = matricaSus[(int)S.get(indexZadnji).getTocka()-65] [(int)S.get(i).getTocka()-65];
			
			if (stringZaProvjeru.equals("#") || stringZaProvjeru == null) {
			}
			else if (razlika == Integer.valueOf( stringZaProvjeru )) {
				put.add(S.get(i).getTocka());
				indexZadnji = i;
			}
			
		}
		
		duljinaPuta = S.get(S.size()-1).getUdaljenost();
		Collections.reverse(put);
		
		
		return new ModelRjesenje( put , duljinaPuta );
				
     }
}