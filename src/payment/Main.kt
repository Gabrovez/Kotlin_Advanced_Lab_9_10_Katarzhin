package payment
fun main(){
    val processor = PaymentProcessor()
    val payments = listOf(
        Payment("4111111111111111", 1000, CardType.VISA),
        Payment("5111111111111111", 2000, CardType.MASTERCARD),
        Payment("2222222222222222", 1500, CardType.MIR),
        Payment("1234567812345678", 500, CardType.UNKNOWN),
        Payment("123",3000, CardType.VISA)
    )
    println("=== Payment processing ===")
    payments.forEach { payment ->
        println("\nPayment ${payment.type}: ${payment.card.take(4)}..., ${payment.sum} rub")
        val result = processor.pay(payment)
        processor.show(result)
    }
    println("\n=== Working with enum ====")
    val cardType = CardType.VISA
    println("Type of card: $cardType")
    println("Serial number ${cardType.ordinal}")
    println("All types of cards: ${CardType.values().joinToString()}")

    val payment1 = Payment("4111111111111", 1000, CardType.VISA)
    val payment2 = payment1.copy(type = CardType.MASTERCARD, sum = 2000)

    println("\n=== Comparison data class ====")
    println("Payment 1: $payment1")
    println("Payment 2: $payment2")
    println("Identical? ${payment1 == payment2  }")
}
