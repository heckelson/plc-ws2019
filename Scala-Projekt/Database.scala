/**
 * @author Hecke Alexander
 * @id 11710696
 */

// Database.scala

class Database extends StockManagement {
    var storedItems = new Array[StoreItem](0)
    
  // Members declared in StockManagement
    override def delete(id: Int): Array[StoreItem] = {
        val (matching, nonmatching) = storedItems.partition(item => item.id == id)
        
        if (!matching.isEmpty) {
            matching foreach(item => item.printAction("delete", item.name))
        }
        else println(s"Id $id nicht gefunden")
        
        storedItems = nonmatching
        nonmatching
    }
    
    
    override def search(name: String): Array[StoreItem] = {
        // unlike Java, in Scala filter() filters if false
        val foundItems = storedItems.filter(item => (item.name contains name))
        if (foundItems.size == 0) {
            println(name + " nicht gefunden")
        }
        else {
            foundItems foreach(item => item.printAction("found", item.name))
        }
        
        foundItems
    }
    
    
    override def store(item: StoreItem): Array[StoreItem] = {
        storedItems :+= item
        item.printAction("add", item.name)
        
        storedItems
    }
    
    
    override def sumUp(): Int = {
        var sum : Int = storedItems.map(item => item.value)
                                   .reduce((x,y) => x + y)
        sum
    }    
    
    // for testing
    def printAll() : Unit = storedItems.foreach(item => println(s"${item.id} ${item.name} ${item.value}"))
    
}
