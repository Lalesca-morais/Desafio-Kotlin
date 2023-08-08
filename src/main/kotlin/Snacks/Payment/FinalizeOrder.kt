package Snacks.Payment

import Snacks.Edit.SnackItem

class FinalizeOrder() {

    fun FinalizeOrder(carrinhoCompraBebidas: MutableList<SnackItem>) {

        val totalValue = CalculateTotalValue(SnackItem)

        val opcaoPagamento = selecionarFormaPagamento()

        when (opcaoPagamento) {
            1, 2, 3 -> {
                println("Compra finalizada com sucesso! Boa refeição!")
            }
            4 -> Money(ShoppingCartSnacks, totalValue)
            else -> println("Opção inválida, tente novamente")
        }
    }
}