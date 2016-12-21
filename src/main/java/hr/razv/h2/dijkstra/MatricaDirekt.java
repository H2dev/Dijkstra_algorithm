package hr.razv.h2.dijkstra;

public class MatricaDirekt {
	
	
	public static ModelRjesenje provuciMatricu( int n, String[][] matricaSus ) {
	
		ListeClanova lc = new ListeClanova( matricaSus );
		ModelRjesenje rjesenje = lc.izracunajPut();   
				
		return rjesenje;
	}
	

}
