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
	
	public abstract boolean czyAkceptujesz(Pokój pokój, Ankieta ankieta);
	
	public String toString() {
		return imię + " " + nazwisko + ", ";
	}
}
