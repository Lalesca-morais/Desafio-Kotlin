package Snacks.Payment

import Desafio.Compras
import Desafio.Shopping
import Snacks.Edit.SnackItem

fun Money(item: List<SnackItem>, totalValue: Double) {
    var cashValue: Double
    var change = 0.0

    do {
        Shopping.showUpdatedCartSnack(item)
        println("Valor total da compra: $totalValue")
        println()
        println("Digite o valor em dinheiro que irá pagar (apenas com pontos): ")
        cashValue = readln().toDouble()

        if (cashValue >= totalValue) {
            change = cashValue - totalValue
            println("Pagamento realizado com sucesso! Troco: $change")
        } else {
            println("Valor insuficiente, digite um valor igual ou maior que o valor total da compra!")
            println()
        }
    } while (cashValue < totalValue)
}

