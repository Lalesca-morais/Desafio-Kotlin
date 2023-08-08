package Snacks.Edit

import Desafio.Compras
import java.util.*

class LancheShop(private val snack: List<SnackItem>) {

    fun startShopping() {
        val cart = mutableListOf<SnackItem>()

        do {
            Compras.showMenuSnacks(snack)

            try {
                val opcaoLanche = readln().toIntOrNull() ?: 0
                if (opcaoLanche < 1 || opcaoLanche > snack.size) {
                    println("Opção inválida, tente novamente.")
                    continue
                }
                val chosenSnack = snack[opcaoLanche - 1]

                println("Digite a quantidade de ${chosenSnack.name} que deseja comprar:")
                val amount = readln().toIntOrNull() ?: 0

                if (amount <= 0) {
                    println("Digite uma quantidade válida!")
                    continue
                }
                val totalItemValue = chosenSnack.value * amount
                val cartItem = SnackItem(Compras.codeGenerator(), chosenSnack.name, totalItemValue, amount)
                cart.add(cartItem)

                Compras.showUpdatedCartSnack(cart)

                val valorTotalCompra = cart.sumOf { it.value }
                println("Valor total da compra até o momento: R$ $valorTotalCompra")

                DisplayOption.displayOptions(cart)

            } catch (e: InputMismatchException) {
                println("Opção inválida, tente novamente.")
            }
        } while (true)
    }
}



