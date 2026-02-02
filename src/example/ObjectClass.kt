package example

import java.awt.Color

object GameSession{
    init {
        println(" Game session created")
    }
    var isActive: Boolean = false
    fun start (){
        isActive = true
        println(" Game session started")
    }
    fun end(){
        isActive = false
        println(" Game session ended")
    }
}
object Logger {
    var count = 0

    fun log(message: String){
        count++
        println("[$count] $message")
    }
}
object AppSettings {
    val version = "1.0.0"
    var isDarkMode = true

    fun toggleTheme(){
        isDarkMode = !isDarkMode
    }
    fun checkTheme(){
        if (AppSettings.isDarkMode){
            println("Dark mode is on")
        }
    }
}
object Colors {
    const val Red = "#FF0000"
    const val GREEN = "#00FF00"
    const val BLUE = "#0000FF"
}
class Mycar(val model: String){
    fun drive()  = println("${model} drive")
}
object TrafficContoller {
    var carCount = 0
    fun carPasssed() {
        carCount++
    }
}
fun main() {
    Mycar("Toyota")
    Mycar("Vroom-vroom")
    TrafficContoller.carPasssed()
//    val handler = object {
//        val name = "Handler"
//        fun  handle() {
//            println("Handling...")
//        }
//    }
//    println(handler.name)
//    handler.handle()
//    println(Colors.Red)
//    println(Colors.GREEN)
//    println(Colors.BLUE)

//    Logger.log("1 message")
//    Logger.log("2 message")
//
//    val logger1 = Logger
//    val logger2 = Logger
//    println(logger1 === logger2)

//    println("Program has started")
//    println("Checking state, but do not touch Game session")
//    println("Now let's launch the game")
//    GameSession.start()
//    println("Checking state once more")
//    println("Is the session active: ${GameSession.isActive}")
}