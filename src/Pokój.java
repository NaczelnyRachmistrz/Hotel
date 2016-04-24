import java.util.*;

public class Pokój {
	TreeSet<KartkaKalendarza> ZajęteTerminy;
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
		ZajęteTerminy = new TreeSet<KartkaKalendarza>();
	}

	private boolean czyZajętaData(KartkaKalendarza data) {
		return ZajęteTerminy.contains(data);
	}
	
	public boolean czyWolnyTermin(KartkaKalendarza początek, int długośćPobytu) {
		Calendar pom;
		while(długośćPobytu > 0) {
			 if (czyZajętaData(początek)) {
				 return false;
			 }
			 pom = (Calendar) początek.dajDzień().clone();
			 pom.add(Calendar.DAY_OF_MONTH, 1);
			 początek = new KartkaKalendarza(pom);
			 długośćPobytu--;
		}
		return true;
	}
	
	public void dodajRezerwację(KartkaKalendarza początek, int długośćPobytu) {
		Calendar pom = Calendar.getInstance();
		while(długośćPobytu > 0) {
			ZajęteTerminy.add(początek);
			pom = (Calendar) początek.dajDzień().clone();
			pom.add(Calendar.DAY_OF_MONTH, 1);
			początek = new KartkaKalendarza(pom);
			długośćPobytu--;
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

	private String wypiszKierunek() {
		switch (kierunekOkna) {
		case ZACHÓD: return "zachód";
		case WSCHÓD: return "wschód";
		case PÓŁNOC: return "północ";
		case POŁUDNIE: return "południe";
		default: return "błąd";
		}
	}
	
	private String wypiszStyl() {
		switch (styl) {
		case RUSTYKALNY: return "rustykalny";
		case MORSKI: return "morski";
		case SECESYJNY: return "secesyjny";
		case NOWOCZESNY: return "nowoczesny";
		case ORIENTALNY: return "orientalny";
		default: return "błąd";
		}
	}
	
	private String wypiszKolor() {
		switch (kolor) {
		case SZARY: return "szary";
		case MORSKI: return "morski";
		case STALOWY: return "stalowy";
		case PURPUROWY: return "purpurowy";
		case JASNOZIELONY: return "jasnozielony";
		case SELEDYNOWY: return "seledynowy";
		default: return "błąd";
		}		
	}	
	
	public String toString() {
		String ret =  "liczba osób - " + pojemność + ", cena - " + cena + ", styl - " + wypiszStyl() + ", kolor - "
				+ wypiszKolor() + ", okno - " + wypiszKierunek() + ", Internet - ";
		if (dostepDoInternetu) {
			ret = ret + "tak.";
		} else {
			ret = ret + "nie.";
		}
		return ret;
	}
	
	
}
