
public class KlientPołowiczny extends Klient{

	public KlientPołowiczny(String imię, String nazwisko) {
		super(imię, nazwisko);
	}
	
	public boolean czyAkceptujesz(Pokój pokój, Ankieta ankieta) {
		if (ankieta.spełnionePozycje(pokój) >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return super.toString() + "połowiczna.";
	}
}
