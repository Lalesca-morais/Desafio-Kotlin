package Snacks.Edit

import Desafio.Compras

class EditItem {
    companion object {

        fun editItem(ShoppingCartSnacks: MutableList<SnackItem>) {
            println("Digite o código do produto que deseja editar: ")
            val productCode = readln().toIntOrNull() ?: 0

            val itemToEdit = ShoppingCartSnacks.find { it.code == productCode }

            if (itemToEdit == null) {
                println("Produto não encontrado no carrinho. Digite um código válido.")
                return
            }

            println("Digite a nova quantidade de itens para ${itemToEdit.name}: ")
            val newAmount = readln().toIntOrNull() ?: 0

            if (newAmount <= 0) {
                println("Quantidade inválida. Não é permitido um número menor que zero!")
                return
            } else {
                val newUnitValue = itemToEdit.value * (newAmount.toDouble() / itemToEdit.amount)
                itemToEdit.value = newUnitValue
                itemToEdit.amount = newAmount
                println("Item ${itemToEdit.name} atualizado!")
            }
            Compras.showUpdatedCartSnack(ShoppingCartSnacks)
            FinalizeOrder(ShoppingCartSnacks)
        }
    }
}