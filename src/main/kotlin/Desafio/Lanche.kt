package Desafio

import java.util.*

class Lanche {

    fun comprarLanche(scanner: Scanner, carrinhoCompraLanches: MutableList<ItemLanche>, lanches: List<ItemLanche>) {
        do {
            Compras.mostrarMenuLanches(lanches)

            try {
                val opcaoLanche = scanner.nextInt()
                if (opcaoLanche < 1 || opcaoLanche > lanches.size) {
                    println("Opção inválida, tente novamente.")
                    continue
                }
                val lancheEscolhido = lanches[opcaoLanche - 1]

                println("Digite a quantidade de ${lancheEscolhido.nome} que deseja comprar:")
                val quantidade = scanner.nextInt()

                if (quantidade <= 0) {
                    println("Digite uma quantidade válida!")
                    continue
                }
                val valorTotalItem = lancheEscolhido.valor * quantidade
                val itemCarrinho =
                    ItemLanche(Compras.geradorDeCodigo(), lancheEscolhido.nome, valorTotalItem, quantidade)
                carrinhoCompraLanches.add(itemCarrinho)

                Compras.mostrarCarrinhoAtualizadoLanche(carrinhoCompraLanches)

                val valorTotalCompra = carrinhoCompraLanches.sumOf { it.valor }
                println("Valor total da compra até o momento: R$ $valorTotalCompra")

                println("""
            Selecione a opção que deseja realizar:
            1 - Adicionar itens
            2 - Editar itens
            3 - Remover itens
            4 - Finalizar pedido""")

                when (val opcaoAcao = scanner.nextInt()) {
                    1 -> continue
                    2 -> editarItem(scanner, carrinhoCompraLanches)
                    3 -> removerItens(scanner, carrinhoCompraLanches)
                    4 -> {
                        println("Pedido finalizado!")
                        finalizarPedido(scanner, carrinhoCompraLanches)
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

    fun editarItem(scanner: Scanner, carrinhoCompraLanches: MutableList<ItemLanche>) {

        println("Selecione o código do produto que deseja editar: ")
        val codigoProduto = scanner.nextInt()

        val itemEscolhidoParaEditar = carrinhoCompraLanches.find { codigoProduto == it.codigo }

        if (itemEscolhidoParaEditar == null) {
            println("Produto não encontrado no carrinho, digite um código válido")
            return
        }
        println("Digite a nova quantidade de itens para ${itemEscolhidoParaEditar.nome}: ")
        val novaQuantidade = scanner.nextInt()

        if (novaQuantidade <= 0) {
            println("Quantidade inválida, não é permitido número menor que zero!")
            return
        } else {
            itemEscolhidoParaEditar.valor = itemEscolhidoParaEditar.valor * (novaQuantidade.toDouble() / itemEscolhidoParaEditar.quantidade)
            itemEscolhidoParaEditar.quantidade = novaQuantidade
            println("Item ${itemEscolhidoParaEditar.nome} atualizado!")
        }
        Compras.mostrarCarrinhoAtualizadoLanche(carrinhoCompraLanches)
        finalizarPedido(scanner, carrinhoCompraLanches)
    }

    fun removerItens(scanner: Scanner, carrinhoCompraLanches: MutableList<ItemLanche>) {

        println("Selecione o código do produto que deseja remover: ")
        val codigoProduto = scanner.nextInt()

        val itemEscolhidoParaRemover = carrinhoCompraLanches.find { it.codigo == codigoProduto }

        if (itemEscolhidoParaRemover == null) {
            println("Produto não encontrado no carrinho, digite um código válido")
            return
        }
        carrinhoCompraLanches.remove(itemEscolhidoParaRemover)
        println("Item ${itemEscolhidoParaRemover.nome} removido do carrinho!")

        Compras.mostrarCarrinhoAtualizadoLanche(carrinhoCompraLanches)
        finalizarPedido(scanner, carrinhoCompraLanches)
    }

    fun finalizarPedido(scanner: Scanner, carrinhoCompraLanches: MutableList<ItemLanche>) {
        val valorTotalDaCompra = carrinhoCompraLanches.sumOf { it.valor }

        var opcaoPagamento: Int
        while (true) {
            println("""
        Selecione a forma de pagamento:
        1 - Cartão de crédito
        2 - Cartão de débito
        3 - Vale refeição
        4 - Dinheiro""")

            try {
                opcaoPagamento = scanner.nextInt()
                when (opcaoPagamento) {
                    1, 2, 3 -> {
                        println("Compra finalizada com sucesso! Boa refeição!")
                        return
                    }
                    4 -> {
                        var valorEmDinheiro: Double
                        var troco = 0.0
                        do {
                            Compras.mostrarCarrinhoAtualizadoLanche(carrinhoCompraLanches)
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
                scanner.next()
            }
        }
        println("Retornando ao menu principal...")
        println("**************************************")
    }
}
