package example

import kotlin.properties.Delegates

interface Base{
    fun someFun()
}
class BaseImpl() : Base{
    override fun someFun(){}
}
class Derived(someBase: Base) : Base by someBase

interface Messenger{
    fun sendTextMessage()
    fun sendVideoMessage()
}
class InstantMessenger(val programName: String) : Messenger {
    override fun sendTextMessage() = println("Send text message")
    override fun sendVideoMessage() = println("Send video message")
}

interface PhotoDevice{
    fun takePhoto()
}
class PhotoCamera: PhotoDevice{
    override fun takePhoto() = println("Take a photo")
}


class SmartPhone(val name: String, m: Messenger, p: PhotoDevice) : Messenger by m, PhotoDevice by p {
    override fun sendTextMessage() = println("Send sms")
}

var counter: Int by Delegates.observable(0) {_, old, new -> println("Counter changed: $old -> $new") }

class User {
    var name: String by Delegates.observable("<no name>") { _, old, new -> println("Name changed: `$old` -> `$new`") }
}

fun main() {
    val kk = InstantMessenger("KK")
    val photoCamere = PhotoCamera()
    val yotaPhone = SmartPhone( "YotaPhone",  kk, photoCamere)
    yotaPhone.sendTextMessage()
    yotaPhone.sendVideoMessage()
    yotaPhone.takePhoto()
    counter = 1
    counter = 5
}