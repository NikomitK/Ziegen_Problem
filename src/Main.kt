fun main() {
    val wiederholungen = 100000
    var gewonnenBleiben = 0.0
    var gewonnenWechseln = 0.0
    repeat(wiederholungen) {
        if(ziegenproblemBleiben()) gewonnenBleiben++
        if(ziegenproblemWechseln()) gewonnenWechseln++
    }
    println("Gewonnen: ${gewonnenBleiben/wiederholungen} mal beim Bleiben")
    println("Gewonnen: ${gewonnenWechseln/wiederholungen} mal beim Wechseln")
}

fun ziegenproblemBleiben(): Boolean{
    val doors = Array(3) { false }
    doors[(0..2).random()] = true
    val choice = (0..2).random()
    return doors[choice]
}

fun ziegenproblemWechseln(): Boolean{
    val doors = Array(3) { false }
    doors[(0..2).random()] = true
    val choice = (0..2).random()
    val open = (0..2).filter { !doors[it] && it != choice }.random()
    val newChoice = (0..2).filter { it != choice && it != open }.first()
    return doors[newChoice]
}