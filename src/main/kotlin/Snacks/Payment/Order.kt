package Snacks.Payment

import Snacks.Edit.SnackItem

class Order(private val cart: MutableList<SnackItem>) {

    fun getTotalPurchaseAmount(): Double {
        return cart.sumOf { it.value }
    }
}
