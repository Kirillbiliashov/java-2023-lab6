import model.Cucumber
import model.Lettuce
import model.Tomato

fun main() {
    val v1 = Tomato(3.5)
    val v2 = Cucumber(1.5)
    val v3 = Lettuce(0.5)
    val v4 = Tomato(3.5)
    val v5 = Tomato(0.5)
    val ls = LinkedSet(listOf(v1, v2, v3, v4))
    val subcollection = listOf(v2, v3)
    println(ls.contains(v1))
    println(ls.contains(v5))
    println(ls.size == 3)
    println(ls.containsAll(subcollection))
    println(ls.containsAll(subcollection + v5))
    for (veg in ls) {
        println("vegetable: $veg")
    }
}