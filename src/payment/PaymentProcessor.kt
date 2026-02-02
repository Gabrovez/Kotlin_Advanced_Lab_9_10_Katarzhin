package payment

import sun.security.util.KeyUtil.validate

class PaymentProcessor {
    private val validator = PaymentValidator()

    fun pay(payment: Payment) :PaymentResult {
        if (!validator.check(payment)) {
            return PaymentResult.Error("Validation error")
        }
        return  when (payment.type) {
            CardType. VISA -> PaymentResult.Success ( "VISA-${System.currentTimeMillis()}")
            CardType.MASTERCARD -> PaymentResult. Processing
            CardType.MIR -> PaymentResult.Success( "MIR-${System.currentTimeMillis()}")
            CardType. UNKNOWN -> PaymentResult.Error ("Unknown type of card")
        }
    }
    fun show(result: PaymentResult){
        when (result) {
            is PaymentResult.Success -> println("Success: ${result.id}")
            is PaymentResult.Error -> println("Error: ${result.reason}")
            PaymentResult.Processing -> println("Processing...")
        }
    }
}