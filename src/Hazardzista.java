import java.util.*;
public class Hazardzista extends Recepcjonista {
	
	private Random los;
	
	public Hazardzista(String imię, String nazwisko) {
		super(imię, nazwisko);
		los = new Random();
	}

	public Pokój zaproponujPokój(Pokój [] pokój, Ankieta ankieta) {
		Pokój wybranyPokój;
		int n = los.nextInt(pokój.length);
		wybranyPokój = pokój[n];
		return wybranyPokój;
	}
	
	public String toString() {
		return super.toString() + "losowa.";
	}
}
