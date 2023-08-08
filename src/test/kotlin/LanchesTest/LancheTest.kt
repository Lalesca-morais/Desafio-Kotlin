package LanchesTest

import Desafio.ItemLanche
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LancheTest {

    @Test
    @DisplayName("remover produto encontrado")
    fun testeMetodoRemovertem() {

        val carrinhoCompraLanchesTeste1 = mutableListOf(
            ItemLanche(1, "Hambúrguer", 10.0, 2),
            ItemLanche(2, "Batata Frita", 5.0, 1),
            ItemLanche(3, "Refrigerante", 3.5, 3))

        Lanche().removerItens(carrinhoCompraLanchesTeste1)

        assertEquals(2, carrinhoCompraLanchesTeste1.size)
        assertNull(carrinhoCompraLanchesTeste1.find { it.codigo == 1 })
    }

    @Test
    @DisplayName("retornar produto nao encontrado")
    fun testeMetodoRemovertemNaoEncontrado() {

        val carrinhoCompraLanchesTeste2 = mutableListOf(
            ItemLanche(1, "Hambúrguer", 10.0, 4),
            ItemLanche(2, "Batata Frita", 5.0, 3),
            ItemLanche(3, "Refrigerante", 3.5, 2))

        Lanche().removerItens(carrinhoCompraLanchesTeste2)
        assertEquals(5, carrinhoCompraLanchesTeste2.size)
    }
}




