
public class KlientPołowiczny extends Klient{

	public KlientPołowiczny(String imię, String nazwisko, Ankieta ankieta) {
		super(imię, nazwisko, ankieta);
	}
	
	public boolean czyAkceptujesz(Pokój pokój) {
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
