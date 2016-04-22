import java.util.*;

public class Ankieta {
	private Calendar dataPrzyjazdu;
	private int długośćPobytu;
	private int maksCena;
	private int minPojemność;
	private Kolor preferowanyKolor;
	private StylWystroju preferowanyStyl;
	private Kierunek kierunekOkna;
	private boolean czyInternet;
	
	public Ankieta(Calendar dataPrzyjazdu, int dlugoscPobytu, int maksCena, int minPojemnosc, Kolor preferowanyKolor,
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
	
	public Calendar dajDatęPrzyjazdu() {
		return dataPrzyjazdu;
	}

	public int dajDługośćPobytu() {
		return długośćPobytu;
	}

	public int dajMaksCenę() {
		return maksCena;
	}

	public int dajMinPojemność() {
		return minPojemność;
	}

	public Kolor dajPreferowanyKolor() {
		return preferowanyKolor;
	}

	public StylWystroju dajPreferowanyStyl() {
		return preferowanyStyl;
	}

	public Kierunek dajKierunekOkna() {
		return kierunekOkna;
	}

	public boolean czyJestInternet() {
		return czyInternet;
	}

	
}

