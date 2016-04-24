import java.util.*;
public class KartkaKalendarza implements Comparable<KartkaKalendarza>{
	
	private Calendar dzień;
	
	public KartkaKalendarza(Calendar dzień) {
		Calendar pom = Calendar.getInstance();
		pom.setTimeInMillis(0);
		pom.set(dzień.get(Calendar.YEAR), dzień.get(Calendar.MONTH), dzień.get(Calendar.DATE));
		this.dzień = pom;
	}
	public int compareTo(KartkaKalendarza kartka) {
		if (this.dzień.getTimeInMillis() < kartka.dajDzień().getTimeInMillis()) {
			return 1;
		} else {
			if (this.dzień.getTimeInMillis() == kartka.dajDzień().getTimeInMillis()) {
				return 0;
			} else {
				return -1;
			}
		}
	}
	
	public Calendar dajDzień() {
		return dzień;
	}
	
}
