/**
 * @author Hecke Alexander
 * @id 11710696
 */

// StockManagement.scala

trait StockManagement {
    // deletes an item from the list and returns the rest, and prints
    def delete(id: Int) : Array[StoreItem]
    
    // returns an array of all Items where the name matches the string and prints
    def search(name: String) : Array[StoreItem] 
    
    // adds item to the list and prints
    def store(item: StoreItem) : Array[StoreItem] 
    
    // returns sum of all values
    def sumUp() : Int 
}
