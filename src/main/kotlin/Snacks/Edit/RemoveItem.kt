package Snacks.Edit

import Desafio.Shopping
import Snacks.Payment.FinalizeOrder

class RemoveItem {
    companion object {

        fun removeItem(ShoppingCartSnacks: MutableList<SnackItem>) {
            println("Digite o código do produto que deseja remover: ")
            val productCode = readln().toIntOrNull() ?: 0

            val itemChosenToRemove = ShoppingCartSnacks.find { it.code == productCode }

            if (itemChosenToRemove == null) {
                println("Produto não encontrado no carrinho, digite um código válido")
                return
            }
            ShoppingCartSnacks.remove(itemChosenToRemove)
            println("Item ${itemChosenToRemove.name} removido do carrinho!")

            Shopping.showUpdatedCartSnack(ShoppingCartSnacks)
            FinalizeOrder(ShoppingCartSnacks)
        }
    }
}