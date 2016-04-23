
public class Perfekcjonista extends Recepcjonista {
	
	public Perfekcjonista(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	public Pokój zaproponujPokój(Pokój [] pokój, Ankieta ankieta) {
		Pokój wybranyPokój = null;
		for (Pokój x: pokój) {
			if (ankieta.spełnionePozycje(x) == 6) {
				if (wybranyPokój == null) {
					wybranyPokój = x;
				} else {
					wybranyPokój = wybranyPokój.dajNr() < x.dajNr() ?wybranyPokój:x;
				}
			} 
		}
		return wybranyPokój;
	}
	
	public String toString() {
		return super.toString() + "perfekcjonistyczna.";
	}
}
