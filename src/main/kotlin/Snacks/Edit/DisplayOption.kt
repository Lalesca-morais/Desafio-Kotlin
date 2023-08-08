package Snacks.Edit

class DisplayOption {
    companion object {
        fun displayOptions(cart: MutableList<SnackItem>) {
            println(
                """
            Selecione a opção que deseja realizar:
            1 - Adicionar itens
            2 - Editar itens
            3 - Remover itens
            4 - Finalizar pedido
            Selecione a opção desejada!"""
            )
            val option = readln().toIntOrNull() ?: 0

            when (option) {
                1 -> LancheShop().startShopping()
                2 -> EditItem.editItem(cart)
                3 -> RemoveItem.removeItem(cart)
                4 -> FinalizeOrder(cart)
                else -> println("Opção inválida, tente novamente")
            }
        }
    }
}