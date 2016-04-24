
public abstract class Recepcjonista {
	
	private String imię;
	private String nazwisko;
	public Recepcjonista(String imię, String nazwisko) {
		this.imię = imię;
		this.nazwisko = nazwisko;
	}
	
	private static int ileWolnychPokojów(Pokój [] pokoje, Ankieta ankieta) {
		int licznik = 0;
		for (Pokój x: pokoje) {
			if (x.czyWolnyTermin(ankieta.dajDatęPrzyjazdu(), ankieta.dajDługośćPobytu())) {
				licznik++;
			}
		}
		return licznik;
	}
	
	public static Pokój [] wolnePokoje(Pokój [] pokoje, Ankieta ankieta) {
		int iter = 0;
		Pokój [] wolnePokoje = new Pokój [ileWolnychPokojów(pokoje, ankieta)];
		for (Pokój x: pokoje) {
			if (x.czyWolnyTermin(ankieta.dajDatęPrzyjazdu(), ankieta.dajDługośćPobytu())) {
				wolnePokoje[iter] = x;
				iter++;
			}
		}
		return wolnePokoje;
	}
	public abstract Pokój zaproponujPokój(Pokój [] pokoje, Ankieta ankieta);
	
	public String dajImię() {
		return imię;
	}
	public String dajNazwisko() {
		return nazwisko;
	}
	public String toString() {
		return imię + " " + nazwisko + ", ";
	}
	
}
