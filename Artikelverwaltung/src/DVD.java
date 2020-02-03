/**
 * @author Hecke Alexander
 * @id 11710696
 */

public class DVD extends Artikel {
	
	public enum Altersfreigabe {
		AB0(20, 0),  // 20% rebate, minimum age 0.
		AB6(15, 6),  // 15% rebate, minimum age 6.
		AB12(10, 12),// 10% rebate, minimum age 12.
		AB16(5, 16), // and so on
		AB18(0, 18); // and so forth

		private final int rebatePercentage;
		private final int minAge;

		private Altersfreigabe(int rebate, int minAge) {
			this.rebatePercentage = rebate;
			this.minAge = minAge;
		}

		public int getRebatePercentage() {
			return rebatePercentage;
		}

		public int getMinAge() {
			return minAge;
		}
		
		public static Altersfreigabe parseInt(int minAge) {
			Altersfreigabe[] avalues = Altersfreigabe.values();
			
			for(Altersfreigabe a : avalues) {
				if (a.minAge == minAge) return a;
			}
			
			throw new IllegalArgumentException("Error: Altersfreigabe ungueltig.");
		}
		
	}
	
// begin of DVD class
	
	private static final long serialVersionUID = 1L;

	Altersfreigabe minAge;
	int playtime;

	public DVD(int id, String title, String publisher, int releaseDate, double price,
			int playtime, int minAge) {
		super(id, title, publisher, releaseDate, price);

		this.minAge = Altersfreigabe.parseInt(minAge);
		
		if (playtime > 0) {
			this.playtime = playtime;
		} else {
			throw new IllegalArgumentException("");
		}
	}

	@Override
	public double rebate() {
		return getPrice() * (minAge.getRebatePercentage() / 100.);
	}

	public Altersfreigabe getMinAge() {
		return minAge;
	}

	public int getPlaytime() {
		return playtime;
	}
	
	public void setPlaytime(int playtime) {
		if (playtime > 0) {
			this.playtime = playtime;
		}
		else {
			throw new IllegalArgumentException("");
		}
	}

	public void setAltersFreigabe(int i) {
		this.minAge = Altersfreigabe.parseInt(i);
	}
	
	public void setAltersFreigabe(Altersfreigabe minAge) {
		this.minAge = minAge;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(super.toString());
		s.append("Dauer:      ").append(getPlaytime()).append("\n");
		s.append("Freigabe:   ").append(minAge.getMinAge()).append("\n");
		
		return s.toString();
	}
}
