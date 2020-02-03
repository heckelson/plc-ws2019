/**
 * @author Hecke Alexander
 * @id 11710696
 */

// StoreItem.scala

class StoreItem (id: Int, name: String, value: Int) 
extends Item (id, name, value) 
with Printer {
    
    override def printAction (actionName: String, name: String) : Unit = {
        actionName match { 
            case "add"        => println(name + " gespeichert")
            case "found"      => println(name + " gefunden")
            case "not found"  => println(name + " nicht gefunden")
            case "delete"     => println(name + " gelöscht")
            case default      => println(actionName + ": command not found.")
        }
    }
    
}
