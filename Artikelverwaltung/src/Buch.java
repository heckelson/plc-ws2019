/**
 * @author Hecke Alexander
 * @id 11710696
 */

public class Buch extends Artikel {

	private static final long serialVersionUID = 1L;
	private int nrOfPages;

	public Buch(int id, String title, String publisher, int releaseDate, double price, int nrOfPages) {
		super(id, title, publisher, releaseDate, price);

		if (nrOfPages > 0) {
			this.nrOfPages = nrOfPages;
		} else {
			throw new IllegalArgumentException("");
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append(super.toString());
		s.append("Seiten:     ").append(getNrOfPages()).append("\n");
		
		return s.toString();
	}

	public int getNrOfPages() {
		return nrOfPages;
	}

	public void setNrOfPages(int nrOfPages) {
		if (nrOfPages > 0) {
			this.nrOfPages = nrOfPages;
		} else {
			throw new IllegalArgumentException("Error: Parameter ungueltig.");
		}
	}

	
	@Override
	public double rebate() {
		int alter = alter();
		double rebatePercentage = alter * 0.05;
		
		// limit the rebate% to 0.3
		if (rebatePercentage > 0.3) {
			rebatePercentage = 0.3;
		}

		return rebatePercentage;
	}
	
	@Override
	public double price() {
		double finalPrice;
		
		// nrOfPages weirdness
		if (nrOfPages <= 1000) {
			finalPrice = getPrice() * (1 - rebate());
		}
		else {
			finalPrice = getPrice() * (1 - (rebate() + 0.03));
		}

		return (finalPrice >= 0) ? finalPrice : 0.0;
	}
	
}
