/**
 * @author Hecke Alexander
 * @id 11710696
 */

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.Year;

public abstract class Artikel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String publisher; // Verlag
	private int releaseYear;
	private double price;

	private int getCurrentYear() {
		Year y = Year.now();
		return y.getValue();
	}
	
	private String getDecimalFormat() {
		return "#0.00";
	}
	
	public Artikel(int id, String title, String publisher, int releaseDate, double price) {
		if (title != null && !title.isEmpty()) {
			this.title = title;
		} else {
			throw new IllegalArgumentException("");
		}

		if (publisher != null && !publisher.isEmpty()) {
			this.publisher = publisher;
		} else {
			throw new IllegalArgumentException("");
		}
		
		if (releaseDate <= getCurrentYear()) {
			this.releaseYear = releaseDate;
		} else {
			throw new IllegalArgumentException("Error: Erscheinungsjahr ungueltig.");
		}

		if (price >= 0) {
			this.price = price;
		} else {
			throw new IllegalArgumentException("");
		}

		if (id >= 0) {
			this.id = id;
		}
		else throw new IllegalArgumentException("");
	}
	
	
	abstract double rebate();
	

	public int alter() {
		return (getCurrentYear() - releaseYear);
	}

	public double price() {
		double finalPrice = price - rebate();
		if(finalPrice >= 0) {
			return finalPrice;
		}
		else return 0.00;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) { 
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null && !title.isEmpty()) {
			this.title = title;
		} else {
			throw new IllegalArgumentException("");
		}
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		if (releaseYear <= getCurrentYear()) {
			this.releaseYear = releaseYear;
		} else {
			throw new IllegalArgumentException("Error: Erscheinungsjahr ungueltig.");
		}
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		if (publisher != null && !publisher.isEmpty()) {
			this.publisher = publisher;
		} else {
			throw new IllegalArgumentException("");
		}
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price;
		} else {
			throw new IllegalArgumentException("");
		}
	}

	// The missing extra information is brought to you by the
	// subclasses' toString Overrides.
	@Override
	public String toString() {

		DecimalFormat df = new DecimalFormat(getDecimalFormat());
		String getPriceAsString = df.format(getPrice());
		String priceAsString = df.format(price());
		
		StringBuilder s = new StringBuilder();
		s.append("Typ:        ").append(this.getClass().getCanonicalName()).append("\n");
		s.append("Id:         ").append(getId()).append("\n");
		s.append("Titel:      ").append(getTitle()).append("\n");
		s.append("Jahr:       ").append(getReleaseYear()).append("\n");
		s.append("Verlag:     ").append(getPublisher()).append("\n");
		s.append("Grundpreis: ").append(getPriceAsString).append("\n");
		s.append("Preis:      ").append(priceAsString).append("\n");
		
		return s.toString();
	}
}
