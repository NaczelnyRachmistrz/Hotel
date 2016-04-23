import java.util.*;
public class Hotel {
	Pokój [] pokoje;
	Recepcjonista [] recepcjoniści;
	public Hotel(Pokój[] pokoje, Recepcjonista[] recepcjoniści) {
		this.pokoje = pokoje;
		this.recepcjoniści = recepcjoniści;
	}
	
	public Zamówienie przyjmijZamówienie(Klient klient, Ankieta ankieta) {
		return new Zamówienie(klient, ankieta);
	}
	
	public void akceptuj(Zamówienie [] zamówienie, Pokój [] pokój, 
			Recepcjonista [] recepcjonista)  {
		ArrayDeque<Zamówienie> zamówienia = new ArrayDeque<Zamówienie>();
		Pokój [] wolnePokoje;
		Pokój proponowanyPokój;
		Zamówienie akt;
		Recepcjonista aktRecep;
		for (int i = 0; i < zamówienie.length; i++) {
			zamówienia.addLast(zamówienie[i]);
		}
		int iter = -1;
		while (!zamówienia.isEmpty()) {
			iter++;
			iter = iter == recepcjonista.length ? 0:iter;
			proponowanyPokój = null;
			akt = zamówienia.pollFirst();
			aktRecep = recepcjonista[iter];
			System.out.println("Recepcjonista: " + aktRecep.toString());
			System.out.println("Zamówienie: " + akt.dajAnkietę().toString());
			wolnePokoje = Recepcjonista.wolnePokoje(pokoje, akt.dajAnkietę());
			if (wolnePokoje.length == 0) {
				System.out.println("Brak wolnych pokojów w podanym terminie!");
				System.out.println("Klient: " + akt.dajKlienta().toString());
				System.out.println("Do zobaczenia w innym terminie!\n");
				continue;
			}
			proponowanyPokój = aktRecep.zaproponujPokój(wolnePokoje, akt.dajAnkietę());
			if (proponowanyPokój == null) {
				System.out.println("Brak pokoju spełniającego wszystkie wymagania!");
				System.out.println("Klient: " + akt.dajKlienta().toString());
				System.out.println("nie;\n");
			} else {
				System.out.println("Proponowany pokój: " + proponowanyPokój.toString());
				System.out.println("Klient: " + akt.dajKlienta().toString());
				if (akt.dajKlienta().czyAkceptujesz(proponowanyPokój, akt.dajAnkietę())) {
					System.out.println("tak;\n");
					proponowanyPokój.dodajRezerwację(akt.dajAnkietę().dajDatęPrzyjazdu(),
							akt.dajAnkietę().dajDługośćPobytu());
				} else {
					System.out.println("nie;\n");
					akt.zwiększLicznik();
					if (akt.dajLicznik() < 3) {
						zamówienia.addLast(akt);
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
	}
}
