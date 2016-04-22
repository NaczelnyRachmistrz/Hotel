import java.util.*;

public class Pokój {
	TreeSet<Calendar> ZajęteTerminy;
	private int nr;
	private int pojemność;
	private int cena;
	private Kolor kolor;
	private StylWystroju styl;
	private Kierunek kierunekOkna;
	private boolean dostepDoInternetu;
	
	public Pokój(int nr, int pojemność, int cena, Kolor kolor,
			StylWystroju styl, Kierunek kierunekOkna, boolean dostepDoInternetu) {
		this.nr = nr;
		this.pojemność = pojemność;
		this.cena = cena;
		this.kolor = kolor;
		this.styl = styl;
		this.kierunekOkna = kierunekOkna;
		this.dostepDoInternetu = dostepDoInternetu;
		ZajęteTerminy = new TreeSet<Calendar>();
	}

	private boolean czyWolnaData(Calendar data) {
		return (!ZajęteTerminy.contains(data));
	}
	
	public boolean czyWolnyTermin(Calendar początek, int długośćPobytu) {
		while(długośćPobytu-- > 0) {
			 if (!czyWolnaData(początek)) {
				 return false;
			 }
			 początek.add(Calendar.DAY_OF_MONTH, 1);
		}
		return true;
	}
	
	public void dodajRezerwację(Calendar początek, int długośćPobytu) {
		while(długośćPobytu-- > 0) {
			ZajęteTerminy.add(początek);
			początek.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
	
	public int dajNr() {
		return nr;
	}

	public int dajPojemność() {
		return pojemność;
	}

	public int dajCenę() {
		return cena;
	}

	public Kolor dajKolor() {
		return kolor;
	}

	public StylWystroju dajStyl() {
		return styl;
	}

	public Kierunek dajKierunekOkna() {
		return kierunekOkna;
	}

	public boolean czyJestInternet() {
		return dostepDoInternetu;
	}
		
}
