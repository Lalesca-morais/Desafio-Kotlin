package Desafio

data class ItemLanche(val codigo: Int, val nome: String, var valor: Double, var quantidade: Int)
data class ItemBebida(val codigo: Int, val nome: String, var valor: Double, var quantidade: Int)
class Compras {
    companion object {

        var contadorItensVendidos = 0

        fun geradorDeCodigo(): Int {
            contadorItensVendidos++
            return contadorItensVendidos
        }

        fun mostrarMenuBebidas(bebida: List<ItemBebida>) {
            println("***** MENU DE BEBIDAS *****")
            bebida.forEachIndexed { index, bebida ->
                println("${index + 1}. ${bebida.nome} - R$ ${bebida.valor}")
            }
        }

        fun mostrarMenuLanches(lanches: List<ItemLanche>) {
            println("***** MENU DE LANCHES *****")
            lanches.forEachIndexed { index, lanche ->
                println("${index + 1}. ${lanche.nome} - R$ ${lanche.valor}")
            }
        }

        fun mostrarCarrinhoAtualizadoLanche(carrinho: List<ItemLanche>) {
            println("***** CARRINHO ATUALIZADO *****")
            carrinho.forEach { item ->
                println("Nome: ${item.nome}")
                println("Quantidade: ${item.quantidade}")
                println("Valor: R$ ${item.valor}")
                println("Código: ${item.codigo}")
                println("---------------------------------")
            }
        }

        fun mostrarCarrinhoAtualizadoBebida(carrinho: List<ItemBebida>) {
            println("***** CARRINHO ATUALIZADO *****")
            carrinho.forEach { item ->
                println("Nome: ${item.nome}")
                println("Quantidade: ${item.quantidade}")
                println("Valor: R$ ${item.valor}")
                println("Código: ${item.codigo}")
                println("-----------------------------------")
            }
        }
    }
}