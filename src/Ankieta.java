public class Ankieta {
	private KartkaKalendarza dataPrzyjazdu;
	private int długośćPobytu;
	private int maksCena;
	private int minPojemność;
	private Kolor preferowanyKolor;
	private StylWystroju preferowanyStyl;
	private Kierunek kierunekOkna;
	private boolean czyInternet;
	
	public Ankieta(KartkaKalendarza dataPrzyjazdu, int dlugoscPobytu, int maksCena, int minPojemnosc, Kolor preferowanyKolor,
			StylWystroju preferowanyStyl, Kierunek kierunekOkna, boolean czyInternet) {
		this.dataPrzyjazdu = dataPrzyjazdu;
		this.długośćPobytu = dlugoscPobytu;
		this.maksCena = maksCena;
		this.minPojemność = minPojemnosc;
		this.preferowanyKolor = preferowanyKolor;
		this.preferowanyStyl = preferowanyStyl;
		this.kierunekOkna = kierunekOkna;
		this.czyInternet = czyInternet;
	}
	
	public int spełnionePozycje(Pokój pokój) {
		int licznik = 0;
		licznik += pokój.dajCenę() <= maksCena ?1:0;
		licznik +=  pokój.dajPojemność() >= minPojemność ?1:0;
		licznik += pokój.dajStyl() == preferowanyStyl ?1:0;
		licznik += pokój.dajKierunekOkna() == kierunekOkna ?1:0;
		licznik += pokój.dajKolor() == preferowanyKolor ?1:0;
		licznik += pokój.czyJestInternet() == czyInternet ?1:0;
		
		return licznik;
	}
	
	public KartkaKalendarza dajDatęPrzyjazdu() {
		return dataPrzyjazdu;
	}

	public int dajDługośćPobytu() {
		return długośćPobytu;
	}

	public int dajMaksCenę() {
		return maksCena;
	}

	public Kierunek dajKierunekOkna() {
		return kierunekOkna;
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
		switch (preferowanyStyl) {
		case RUSTYKALNY: return "rustykalny";
		case MORSKI: return "morski";
		case SECESYJNY: return "secesyjny";
		case NOWOCZESNY: return "nowoczesny";
		case ORIENTALNY: return "orientalny";
		default: return "błąd";
		}
	}
	
	private String wypiszKolor() {
		switch (preferowanyKolor) {
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
		String ret =  "liczba osób - " + minPojemność + ", cena - " + maksCena + ", styl - " + wypiszStyl() 
				+ ", kolor - " + wypiszKolor() + ", okno - " + wypiszKierunek() + ", Internet - ";
		if (czyInternet) {
			ret = ret + "tak.";
		} else {
			ret = ret + "nie.";
		}
		return ret;
	}
	
}

