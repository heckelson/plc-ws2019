/**
 * @author Hecke Alexander
 * @id 11710696
 */

import java.util.List;
import java.util.stream.Collectors;

public class Artikelverwaltung {
	private ArtikelDAO ad;
	
	public Artikelverwaltung(ArtikelDAO ad) {
		this.ad = ad;
	}
	
	public void printEverything() {
		for (Artikel a : ad.getArtikel()) {
			System.out.println(a);
		}
	}
	
	public void printById(int id) {
		System.out.println(ad.getArtikel(id));	
	}
	
	public void addArtikel(Artikel artikel) {
		ad.saveArtikel(artikel);
		System.out.println("Info: Artikel " + artikel.getId() + " added.");
	}
	
	public void deleteArtikel(int id) {
		ad.deleteArtikel(id);
		System.out.println("Info: Artikel " + id + " deleted.");
	}
	
	public int countArtikel() {
		return ad.getArtikel().size();
	}
	
	public double avgPrice() throws ArithmeticException {
		if(ad.getArtikel().size() < 1) return 0.0;
		
		double sumOfPrices = ad.getArtikel().stream()
				.mapToDouble(a -> a.price())
				.reduce(0.0, (a,b) -> a + b);
		
		double avgPrice = sumOfPrices / ad.getArtikel().size(); // throws here
		
		return avgPrice;
	}
	
	public List<Artikel> oldestArtikel() {
		List<Artikel> alist = ad.getArtikel();
		
		// find oldest release year in the list of Artikels
		int oldestYear = alist.stream()
				.mapToInt(a -> a.getReleaseYear())
				.min()
				.orElse(Integer.MIN_VALUE);
		
		// collect all Artikels that have the oldest release year
		List<Artikel> allOldest = alist.stream()
							.filter(a -> a.getReleaseYear() == oldestYear)
							.collect(Collectors.toList());
		
		// let's hope this works
		return allOldest;
	}
}
