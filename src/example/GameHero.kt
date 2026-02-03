package example

import kotlin.properties.Delegates

class GameHero(startName:String) {
    var name: String by Delegates.observable(startName) { _, old, new -> println("[$old] got new name: $new!") }
    var mana: Int by Delegates.observable(100) { _,old,new -> println("Mana: $old -> $new!") }
    val ultimate: String by lazy {
        println("Downloading animation of skill... ")
        "Meteor rain"
    }
}
fun main() {
    println("Creating hero...")
    val hero = GameHero("Light Warrior")

    println("\nCurrent mana: ${hero.mana}")

    println("\nHero is trying to use ability:")
    println("Ability: ${hero.ultimate}")

    println("\nRepeated ability call (should be instant):")
    println("Ability: ${hero.ultimate}")

    println("\nChanging hero's name:")
    hero.name = "Dark Paladin"

    println("\nHero restores mana:")
    hero.mana = 200
}