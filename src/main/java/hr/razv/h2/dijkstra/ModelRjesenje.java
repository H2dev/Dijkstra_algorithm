package hr.razv.h2.dijkstra;

import java.util.ArrayList;

public class ModelRjesenje {
	
	ArrayList<Character> rjesenjePut = new ArrayList<Character>();
	int rjesenjeDuljinaPuta = 0;
	
	public ModelRjesenje(ArrayList<Character> rjesenjePut,
			int rjesenjeDuljinaPuta) {
		super();
		this.rjesenjePut = rjesenjePut;
		this.rjesenjeDuljinaPuta = rjesenjeDuljinaPuta;
	}

	public ArrayList<Character> getRjesenjePut() {
		return rjesenjePut;
	}

	public void setRjesenjePut(ArrayList<Character> rjesenjePut) {
		this.rjesenjePut = rjesenjePut;
	}

	public int getRjesenjeDuljinaPuta() {
		return rjesenjeDuljinaPuta;
	}

	public void setRjesenjeDuljinaPuta(int rjesenjeDuljinaPuta) {
		this.rjesenjeDuljinaPuta = rjesenjeDuljinaPuta;
	}
	
	
	

}
