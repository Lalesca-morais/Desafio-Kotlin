package Desafio

import java.util.*
class Bebida {

    fun comprarBebida(scanner: Scanner, carrinhoCompraBebidas: MutableList<ItemBebida>, bebidas: List<ItemBebida>) {
        do {
            Compras.mostrarMenuBebidas(bebidas)
            try {
                val opcaoBebidas = scanner.nextInt()
                if (opcaoBebidas < 1 || opcaoBebidas > bebidas.size) {
                    println("Opção inválida, tente novamente.")
                    continue
                }
                val bebidaEscolhida = bebidas[opcaoBebidas - 1]

                println("Digite a quantidade de ${bebidaEscolhida.nome} que deseja comprar:")
                val quantidade = scanner.nextInt()

                if (quantidade <= 0) {
                    println("Digite uma quantidade válida!")
                    continue
                }

                val valorTotalItem = bebidaEscolhida.valor * quantidade
                val itemCarrinho = ItemBebida(Compras.geradorDeCodigo(), bebidaEscolhida.nome, valorTotalItem, quantidade)
                carrinhoCompraBebidas.add(itemCarrinho)

                Compras.mostrarCarrinhoAtualizadoBebida(carrinhoCompraBebidas)

                val valorTotalCompra = carrinhoCompraBebidas.sumOf { it.valor }
                println("Valor total da compra até o momento: R$ $valorTotalCompra")

                println("""
                Selecione a opção que deseja realizar:
                1 - Adicionar itens
                2 - Editar itens
                3 - Remover itens
                4 - Finalizar pedido""")

                when (val opcaoAcao = scanner.nextInt()) {
                    1 -> continue
                    2 -> editarItem(scanner, carrinhoCompraBebidas)
                    3 -> removerItens(scanner, carrinhoCompraBebidas)
                    4 -> {
                        println("Pedido finalizado!")
                        finalizarPedido(scanner, carrinhoCompraBebidas)
                        break
                    }
                    else -> println("Opção inválida, tente novamente")

                }
            } catch (e: InputMismatchException) {
                println("Opção inválida, tente novamente.")
                scanner.nextLine()
            } catch (e: NoSuchElementException) {
                println("Formato inválido, para escolher o item, você deve informar o número dele.")
                scanner.nextLine()
            }
        } while (true)
    }

    fun editarItem(scanner: Scanner, carrinhoCompraBebidas: MutableList<ItemBebida>) {
        println("Selecione o código do produto que deseja editar: ")
        val codigoProduto = scanner.nextInt()

        var itemEscolhidoParaEditar = carrinhoCompraBebidas.find { codigoProduto == it.codigo }

        if (itemEscolhidoParaEditar == null) {
            println("Produto não encontrado no carrinho, digite um código válido")
            return
        }
        println("Digite a quantidade de itens para ${itemEscolhidoParaEditar.nome}: ")
        val novaQuantidade = scanner.nextInt()

        if (novaQuantidade <= 0) {
            println("Quantidade inválida, não é permitido número menor que zero!")
            return
        } else {
            itemEscolhidoParaEditar.valor =
                itemEscolhidoParaEditar.valor * (novaQuantidade.toDouble() / itemEscolhidoParaEditar.quantidade)
            itemEscolhidoParaEditar.quantidade = novaQuantidade
            println("Item ${itemEscolhidoParaEditar.nome} atualizado!")
        }
        Compras.mostrarCarrinhoAtualizadoBebida(carrinhoCompraBebidas)
        finalizarPedido(scanner, carrinhoCompraBebidas)
    }

    fun removerItens(scanner: Scanner, carrinhoCompraBebidas: MutableList<ItemBebida>) {
        println("Selecione o código do produto que deseja remover: ")
        val codigoProduto = scanner.nextInt()

        val itemEscolhidoParaRemover = carrinhoCompraBebidas.find { it.codigo == codigoProduto }

        if (itemEscolhidoParaRemover == null) {
            println("Produto não encontrado no carrinho, digite um código válido")
            return
        }
        carrinhoCompraBebidas.remove(itemEscolhidoParaRemover)
        println("Item ${itemEscolhidoParaRemover.nome} removido do carrinho!")

        Compras.mostrarCarrinhoAtualizadoBebida(carrinhoCompraBebidas)
        finalizarPedido(scanner, carrinhoCompraBebidas)
    }

    fun finalizarPedido(scanner: Scanner, carrinhoCompraBebidas: MutableList<ItemBebida>) {
        val valorTotalDaCompra = carrinhoCompraBebidas.sumOf { it.valor }

        var opcaoPagamento: Int

        while (true) {
            println("""
        Selecione a forma de pagamento:
        1 - Cartão de crédito
        2 - Cartão de débito
        3 - Vale refeição
        4 - Dinheiro""")
            opcaoPagamento = scanner.nextInt()
            try {
                when (opcaoPagamento) {
                    1, 2, 3 -> {
                        println("Compra finalizada com sucesso! Boa refeição!")
                        return
                    }
                    4 -> {
                        var valorEmDinheiro: Double
                        var troco = 0.0
                        do {
                            Compras.mostrarCarrinhoAtualizadoBebida(carrinhoCompraBebidas)
                            println("Valor total da compra: $valorTotalDaCompra")
                            println()
                            println("Digite o valor em dinheiro que irá pagar (apenas em vírgulas): ")
                            valorEmDinheiro = scanner.nextDouble()

                            if (valorEmDinheiro >= valorTotalDaCompra) {
                                troco = valorEmDinheiro - valorTotalDaCompra
                                println("Pagamento realizado com sucesso! Troco: $troco")

                            } else {
                                println("Valor insuficiente, digite um valor igual ou maior que o valor total da compra!")
                                println()
                            }

                        } while (valorEmDinheiro < valorTotalDaCompra)
                        return
                    }
                }
            } catch (e: InputMismatchException) {
                println("Digite apenas números válidos!")
                scanner.nextLine()
            }
        }
        println("Retornando ao menu principal...")
        println("**************************************")
    }
}