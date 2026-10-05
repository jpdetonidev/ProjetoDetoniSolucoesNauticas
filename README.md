# Controle de Estoque — Detoni Soluções Náuticas

Sistema de console em Java para controle de estoque de peças de reposição.

## O problema

Meu pai é mecânico náutico e mantém em sua oficina um estoque de peças de reposição, sem nenhum controle registrado.

O problema principal era não saber o que tinha em mãos. Sem conseguir consultar o estoque, ele acabava comprando peças que já possuía.

Este sistema resolve isso permitindo consultar rapidamente se uma peça existe no estoque e em que quantidade, além de registrar entradas e saídas.

## Funcionalidades

- **Cadastro de peças** — registra nome, modelo, marca e quantidade. Se a peça já existir, soma a quantidade em vez de duplicar o registro.
- **Consulta por nome** — mostra todas as peças com aquele nome e suas quantidades.
- **Entrada em estoque** — registra a chegada de novas unidades.
- **Baixa em estoque** — registra a saída, impedindo que a quantidade fique negativa.
- **Listagem completa** — exibe todo o estoque.

## Tecnologias

- Java 25
- Programação Orientada a Objetos (encapsulamento, regras de negócio na entidade)
- Aplicação de console

## Como rodar

1. Clone o repositório: git clone https://github.com/jpdetonidev/Project-DETONI-SOLUCOES-NAUTICAS.git
2. Abra o projeto em uma IDE Java (IntelliJ, Eclipse ou VS Code)

3. Execute a classe `Main` em `src/application/Main.java`

## Próximos passos

- [x] Menu interativo para escolher as operações
- [ ] Preço por peça e cálculo do valor total do estoque
- [ ] Persistência dos dados (banco de dados)
- [ ] Interface gráfica
