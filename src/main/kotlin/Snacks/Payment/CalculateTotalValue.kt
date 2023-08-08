package Snacks.Payment

import Snacks.Edit.SnackItem

class CalculateTotalValue {

    fun totalValue(item: List<SnackItem>): Double {
        return item.sumOf { it.value }
    }
}