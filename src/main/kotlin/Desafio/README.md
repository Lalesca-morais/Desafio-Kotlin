# Totem de Autoatendimento - README

Este é um código em Kotlin que implementa um "Totem de Autoatendimento", permitindo que os usuários escolham entre comprar lanches, bebidas ou sair do programa. O totem é uma aplicação de linha de comando (CLI) e foi desenvolvido utilizando a linguagem de programação Kotlin.

## Funcionalidades

- Compra de Lanches: O totem permite aos usuários comprar lanches disponíveis em uma lista pré-definida. O preço e a quantidade disponível de cada lanche são exibidos.
- Compra de Bebidas: Os usuários também têm a opção de comprar bebidas da lista pré-definida. O preço e a quantidade disponível de cada bebida são exibidos.
- Sair: Caso o usuário deseje sair do programa, pode selecionar essa opção para encerrá-lo.

## Como utilizar

1. Ao iniciar o programa, o totem de autoatendimento é exibido, e o usuário é solicitado a escolher uma das seguintes opções:
    - Digite 1 para comprar um lanche.
    - Digite 2 para comprar uma bebida.
    - Digite 3 para sair do programa.

2. Caso o usuário selecione a opção de compra de lanche ou bebida, o totem exibirá a lista de lanches ou bebidas disponíveis. O usuário será solicitado a digitar o número do item desejado e a quantidade, posteriormente será solicitado que o usuário informe quais opções deseja fazer com o produto e será encaminhado para o serviço de pagamento.

3. Após a compra ser concluída, o totem volta ao menu principal e o usuário pode fazer novas escolhas.

## Itens disponíveis

O totem de autoatendimento possui uma lista pré-definida de lanches e bebidas disponíveis para compra. A lista é inicializada no início do programa e não pode ser modificada durante a execução. Abaixo estão os itens disponíveis:

### Lanches:
1. X-burger: Preço: R$10.00.
2. X-salada: Preço: R$12.00.

### Bebidas:
1. Refrigerante: Preço: R$8.00.
2. Suco: Preço: R$6.00.

## Notas importantes

- Caso o usuário selecione uma opção inválida ou informe um formato inválido ao escolher um item, o programa exibirá uma mensagem de erro e voltará ao menu principal.
- O programa aguarda 3 segundos antes de voltar ao menu principal após cada compra, para dar tempo ao usuário de visualizar a mensagem de conclusão da compra.

## Dependências

Este programa não possui dependências externas além das bibliotecas padrão da linguagem Kotlin.

