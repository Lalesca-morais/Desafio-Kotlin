package LanchesTest

import Snacks.Edit.SnackItem
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LancheTest {

    @Test
    @DisplayName("remover produto encontrado")
    fun testMethodRemoveitem() {

        val cartBuySnacksTest1 = mutableListOf(
            SnackItem(1, "Hambúrguer", 10.0, 2),
            SnackItem(2, "Batata Frita", 5.0, 1),
            SnackItem(3, "Refrigerante", 3.5, 3))

        Snacks().removeItem(cartBuySnacksTest1)

        assertEquals(2, cartBuySnacksTest1.size)
        assertNull(cartBuySnacksTest1.find { it.code == 1 })
    }

    @Test
    @DisplayName("retornar produto nao encontrado")
    fun testMethodRemoveitem1() {

        val cartBuySnacksTest2 = mutableListOf(
            SnackItem(1, "Hambúrguer", 10.0, 4),
            SnackItem(2, "Batata Frita", 5.0, 3),
            SnackItem(3, "Refrigerante", 3.5, 2))

        Snacks().removeItem(cartBuySnacksTest2)
        assertEquals(5, cartBuySnacksTest2.size)
    }
}




