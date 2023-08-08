package Snacks.Payment

class FormOfPayment {
    fun selectPaymentMethod(): Int? {
        while (true) {
            println(
                """
        Selecione a forma de pagamento:
        1 - Cartão de crédito
        2 - Cartão de débito
        3 - Vale refeição
        4 - Dinheiro"""
            )
            val option = readln().toIntOrNull()

            if (option in 1..4) {
                return option
            } else {
                println("Opção inválida, tente novamente.")
            }
        }
    }
}
