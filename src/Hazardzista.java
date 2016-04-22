import java.util.*;
public class Hazardzista extends Recepcjonista {

	public Hazardzista(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	public Pokój zaproponujPokój(Pokój [] pokój, Ankieta ankieta) {
		
		Pokój wybranyPokój;
		Random los = new Random();
		int n = los.nextInt();
		n %= pokój.length;
		wybranyPokój = pokój[n];
		return wybranyPokój;
	}
	
	public String toString() {
		return super.toString() + "losowa.";
	}
}
