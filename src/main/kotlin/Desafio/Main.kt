package Desafio

import java.lang.NumberFormatException
import java.util.*
import java.util.concurrent.TimeUnit
fun main() {
    val scanner = Scanner(System.`in`)

    val carrinhoCompraLanches = mutableListOf<ItemLanche>()
    val lanches = listOf(ItemLanche(Compras.geradorDeCodigo(), "X-burger", 10.0, 0), ItemLanche(102, "X-salada", 12.0, 0))

    val carrinhoCompraBebida = mutableListOf<ItemBebida>()
    val bebidas = listOf(ItemBebida(Compras.geradorDeCodigo(), "Refrigerante", 8.0, 0), ItemBebida(202, "Suco", 6.0, 0))

    val novoLanche = Lanche()
    val novaBebida = Bebida()

    while (true) {
        try {
            println("""
                Bem-vindo ao Totem de Autoatendimento!
                Selecione uma opção:
                1. Lanche
                2. Bebida
                3. Sair""")

            val opcao = scanner.nextInt()
            when (opcao) {
                1 -> {
                    novoLanche.comprarLanche(scanner, carrinhoCompraLanches, lanches)
                    println("Retornando ao menu principal...")
                }
                2 -> {
                    novaBebida.comprarBebida(scanner, carrinhoCompraBebida, bebidas)
                    println("Retornando ao menu principal...")
                }
                3 -> {
                    println("Encerrando programa...")
                    return
                }
                else -> throw NumberFormatException()
            }
            TimeUnit.SECONDS.sleep(3)
        } catch (e: InputMismatchException) {
            println("Opção inválida, tente novamente.")
            scanner.nextLine()
        } catch (e: NoSuchElementException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele.")
            scanner.nextLine()
        }
    }
}