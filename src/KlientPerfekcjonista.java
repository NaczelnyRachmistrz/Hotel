
public class KlientPerfekcjonista extends Klient {

	public KlientPerfekcjonista(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	public boolean czyAkceptujesz(Pokój pokój, Ankieta ankieta) {
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
