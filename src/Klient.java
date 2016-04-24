public abstract class Klient {

	String imię;
	String nazwisko;
	
	public Klient(String imię, String nazwisko) {
		this.imię = imię;
		this.nazwisko = nazwisko;
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
