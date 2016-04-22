
public class KlientPerfekcjonista extends Klient {

	public KlientPerfekcjonista(String imię, String nazwisko, Ankieta ankieta) {
		super(imię, nazwisko, ankieta);
	}

	public boolean czyAkceptujesz(Pokój pokój) {
		if (ankieta.spełnionePozycje(pokój) == 6) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return super.toString() + "perfekcjonistyczna.";
	}
}
