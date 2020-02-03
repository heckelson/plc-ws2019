/**
 * @author Hecke Alexander
 * @id 11710696
 */

// MainApp.scala

object MainApp extends App {
    val db = new Database()
    
    val item1 = new StoreItem(1, "Laptop", 1000)
    val item2 = new StoreItem(2, "PC", 800)
    val item3 = new StoreItem(3, "Smartphone", 1200)
    val item4 = new StoreItem(4, "PC", 1400)
    
    db.store(item1)
    db.store(item2)
    db.store(item3)
    db.store(item4)
    
    db.delete(1)
    db.search("PC")
    
}
