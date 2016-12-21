package hr.razv.h2.dijkstra;

public class Clan {
	
	char tocka;
	int udaljenost;
	char besk;
	
	public Clan(char tocka, int udaljenost) {
		
		this.tocka = tocka;
		this.udaljenost = udaljenost;
	}

	
	public Clan(char tocka, char besk) {
		
		this.tocka = tocka;
		this.besk = besk;
	}
	
	public String getClan () {
		
		String clan = new String();
		
		if (this.besk == '#')
			clan = clan.concat(Character.toString(tocka)).concat(", ").concat(Character.toString(besk));
		else
			clan = clan.concat(Character.toString(tocka)).concat(", ").concat(Integer.toString(udaljenost));
			
		return clan;
				
	}


	public char getTocka() {
		return tocka;
	}


	public void setTocka(char tocka) {
		this.tocka = tocka;
	}


	public int getUdaljenost() {
		return udaljenost;
	}


	public void setUdaljenost(int udaljenost) {
		this.udaljenost = udaljenost;
	}


	public char getBesk() {
		return besk;
	}


	public void setBesk(char besk) {
		this.besk = besk;
	}


}
