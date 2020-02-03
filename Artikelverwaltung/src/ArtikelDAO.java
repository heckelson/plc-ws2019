/**
 * @author Hecke Alexander
 * @id 11710696
 */

import java.util.List;

public interface ArtikelDAO {

	public List<Artikel> getArtikel();

	public Artikel getArtikel(int id);

	public void saveArtikel(Artikel artikel);

	public void deleteArtikel(int id);
}