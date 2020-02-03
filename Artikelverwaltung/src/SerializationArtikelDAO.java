/**
 * @author Hecke Alexander
 * @id 11710696
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// DONE: Refactor this class to use an ArrayList<> instead of a map

public class SerializationArtikelDAO implements ArtikelDAO {
	private List<Artikel> alist = new ArrayList<>();
	private String filename;
	
	public SerializationArtikelDAO(String filename) {
		this.filename = filename;
		if(filename.isEmpty()) {
			throw new IllegalArgumentException("");
		}
	}
	
	private void serializeAlist() {
		try(ObjectOutputStream out = new ObjectOutputStream(
			new FileOutputStream(filename))) {
			out.writeObject(alist);
			out.close();
		}
		catch (FileNotFoundException e) {
			File f = new File(filename);
			if(!f.exists()) {
				try {
					f.createNewFile();
				}
				catch(IOException ee) {
					System.out.println("Fehler bei Serialisierung");
					System.exit(1);
				}
			}
		}
		catch (IOException e) {
			System.out.println("Fehler bei Serialisierung");
			System.exit(1);
		}
		catch (Exception e) {
			System.out.println("Fehler bei Serialisierung");
			System.exit(1);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void deserializeAlist() {
		try(ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(filename))) {
			alist = (List<Artikel>) in.readObject();
		}
		catch(FileNotFoundException e) {
			// do nothing, the list is just empty
		}
		catch (Exception e) {
			System.out.println("Fehler bei Deserialisierung");
			System.exit(1);
		}
	}
	
	@Override
	public List<Artikel> getArtikel() {
		deserializeAlist();
		return alist;
	}

	@Override
	public Artikel getArtikel(int id) {
		deserializeAlist();
		
		for(Artikel a : alist) {
			if (a.getId() == id && a != null) {
				return a;
			}
		}
		
		throw new IllegalArgumentException("Error: Artikel nicht vorhanden. (id=" + id + ")");
	}

	@Override
	public void saveArtikel(Artikel artikel) {
		deserializeAlist();
		int artikelId = artikel.getId();
		
		for(Artikel a : alist) {
			if(a.getId() == artikelId) {
				throw new IllegalArgumentException("Error: Artikel bereits vorhanden. (id=" + artikelId + ")");
			}
		}
		
		alist.add(artikel);
		serializeAlist();
	}
	
	@Override
	public void deleteArtikel(int id) {
		deserializeAlist();
		
		// Could be refactored into a stream 
		for(Artikel a : alist) {
			if(a.getId() == id) {
				alist.remove(a);
				serializeAlist();
				return;
			}
		}
		
		throw new IllegalArgumentException("Error: Artikel nicht vorhanden. (id=" + id + ")");
	}
	
}
