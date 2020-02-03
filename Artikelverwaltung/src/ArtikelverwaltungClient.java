/**
 * @author Hecke Alexander
 * @id 11710696
 */

import java.text.DecimalFormat;

public class ArtikelverwaltungClient {
	
	private static void add(String[] args, Artikelverwaltung av) throws NumberFormatException {		
		if(args.length < 9 || args.length > 10) {
			throw new IllegalArgumentException("");
		}
		// Parsing the arguments happens here
		String typeOfArtikel = 	args[2];
		int id = 				Integer.parseInt(args[3]);
		String title = 			args[4];
		String publisher = 		args[5];
		int releaseDate = 		Integer.parseInt(args[6]);
		double price = 			Double.parseDouble(args[7]);		
		
		// check the type of Artikel (args[2]), add a buch or a DVD
		if(typeOfArtikel.equalsIgnoreCase("buch") && args.length == 9) {
			int nrOfPages = Integer.parseInt(args[8]);
			
			av.addArtikel(new Buch(id, title, publisher, releaseDate, price, nrOfPages));
		}
		else if(typeOfArtikel.equalsIgnoreCase("dvd") && args.length == 10) {
			int playtime = Integer.parseInt(args[8]);
			int minAge = Integer.parseInt(args[9]);
			
			av.addArtikel(new DVD(id, title, publisher, releaseDate, price, playtime, minAge));
		}
		else {
			throw new IllegalArgumentException("");
		}
	}
	
	
	private static void list(String[] args, Artikelverwaltung av) {
		if(args.length == 2) {
			av.printEverything();
		}
		else {
			int id = Integer.parseInt(args[2]);
			av.printById(id);
		}
	}
	
	public static void main(String[] args) {
		// The input should look like this:
		// $ java ArtikelverwaltungClient <Dateiname> <Parameter> [Parameter] ...
		// 		<Dateiname>: args[0], z.B. myFile
		// 		<Parameter>: args[1]: add | list | delete | count | meanprice | oldest
		// 		further parameters are not always a given
		
		if(args.length < 2) {
			System.out.println("Error: Parameter ungueltig.");
			return;
		}
		
		String filename = args[0];
		String function = args[1].toLowerCase();
		
		try {
			Artikelverwaltung av = new Artikelverwaltung(new SerializationArtikelDAO(filename));
			
			// <Parameter>: args[1]: add | list | delete | count | meanprice | oldest
			switch(function) {
				case("add"):
					add(args, av);
					break;
				case("list"):
					list(args, av);
					break;
				case("delete"):
					if(args.length < 3) throw new IllegalArgumentException("");
					av.deleteArtikel(Integer.parseInt(args[2]));
					break;
				case("count"):
					System.out.println(av.countArtikel());
					break;
				case("meanprice"):
					DecimalFormat df = new DecimalFormat("#0.00");
					System.out.println(df.format(av.avgPrice()));
					break;
				case("oldest"):
					av.oldestArtikel().stream()
									.forEach(artikel -> System.out.println("Id: " + artikel.getId()));
					break;
				case("help"):
					System.out.println("usage: java ArtikelverwaltungClient [add | list | delete | count | meanprice | oldest]");
					System.out.println("------------------------------------");
					System.out.println("  add:");
					System.out.println("  - add buch 0 \"Don Quichote\" \"Springer Verlag\" 1814 12.99 301: ");					
					System.out.println("  - add buch <id> \"title\" \"publisher\" <release year> <price> <pages>");
					System.out.println("  - add dvd <id> \"title\" \"publisher\" <release year> <price> <playtime> <min age>");
					System.out.println("  list:");
					System.out.println("  - list     : prints all saved articles");
					System.out.println("  - list <ID>: prints the article with the id");
					System.out.println("  delete:");
					System.out.println("  - delete <ID>: deletes the article with the corresponding id");
					System.out.println("  count:");
					System.out.println("  - count: prints the amount of saved articles");					
					System.out.println("  meanprice:");
					System.out.println("  - meanprice: prints the average price of the articles");
					System.out.println("  oldest:");
					System.out.println("  - oldest: prints the oldest article (by release date)");
					break;
					
				default:
					throw new IllegalArgumentException("");
			}
		}
		catch(IllegalArgumentException e) {
			if(e instanceof NumberFormatException || 
				e.getMessage().isEmpty()) {
				System.out.println("Error: Parameter ungueltig.");
			}
			else {
				System.out.println(e.getMessage());
			}
		}
		catch(Exception e) {
			// hopefully I caught all exceptions at this point...
			// if not, here's the stack trace to help with debugging
			e.printStackTrace();
		}
		
	}
}
