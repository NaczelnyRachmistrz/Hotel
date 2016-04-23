
public class KlientUgodowy extends Klient {
	
	public KlientUgodowy(String imię, String nazwisko, Ankieta ankieta) {
		super(imię, nazwisko, ankieta);
	}

	public boolean czyAkceptujesz(Pokój pokój, Ankieta ankieta) {
		return true;
	}
	
	public String toString() {
		return super.toString() + "ugodowa.";
	}
}
