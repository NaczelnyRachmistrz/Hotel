public abstract class Klient {

	String imię;
	String nazwisko;
	Ankieta ankieta;
	
	public Klient(String imię, String nazwisko, Ankieta ankieta) {
		this.imię = imię;
		this.nazwisko = nazwisko;
		this.ankieta = ankieta;
	}

	public String dajImię() {
		return imię;
	}

	public String dajNazwisko() {
		return nazwisko;
	}

	public Ankieta dajAnkietę() {
		return ankieta;
	}
	
	public abstract boolean czyAkceptujesz(Pokój pokój);
	
	public String toString() {
		return imię + " " + nazwisko + ", ";
	}
}
