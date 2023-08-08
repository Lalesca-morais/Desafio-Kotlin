package Desafio

import Snacks.Edit.SnackItem

data class ItemBebida(val codigo: Int, val nome: String, var valor: Double, var quantidade: Int)
class Shopping {
    companion object {

        var counterItemsSold = 0

        fun codeGenerator(): Int {
            counterItemsSold++
            return counterItemsSold
        }

        fun showMenuDrinks(drinks: List<ItemBebida>) {
            println("***** MENU DE BEBIDAS *****")
            drinks.forEachIndexed { index, bebida ->
                println("${index + 1}. ${bebida.nome} - R$ ${bebida.valor}")
            }
        }

        fun showMenuSnacks(snacks: List<SnackItem>) {
            println("***** MENU DE LANCHES *****")
            snacks.forEachIndexed { index, lanche -> println("${index + 1}. ${lanche.name} - R$ ${lanche.value}")
            }
        }
        fun showUpdatedCartSnack(cart: List<SnackItem>) {
            println("***** CARRINHO ATUALIZADO *****")
            cart.forEach { SnackItem ->
                println("Nome: ${SnackItem.name}")
                println("Quantidade: ${SnackItem.amount}")
                println("Valor: R$ ${SnackItem.value}")
                println("Código: ${SnackItem.code}")
                println("---------------------------------")
            }
        }
        fun showUpdateCartDrink(cart: List<ItemBebida>) {
            println("***** CARRINHO ATUALIZADO *****")
            cart.forEach { item ->
                println("Nome: ${item.nome}")
                println("Quantidade: ${item.quantidade}")
                println("Valor: R$ ${item.valor}")
                println("Código: ${item.codigo}")
                println("-----------------------------------")
            }
        }
    }
}