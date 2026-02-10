# Lista de Exercícios - Algoritmos e Análise de Complexidade

Este projeto contém a implementação de 10 exercícios sobre algoritmos e análise de complexidade no pior caso, com notação Big-O.

## Estrutura do Projeto

```
exercicio10022026/
├── src/
│   ├── Exercicio1.java      (Busca Linear)
│   ├── Exercicio2.java      (Busca Binária Recursiva)
│   ├── Exercicio3.java      (Bubble Sort Otimizado)
│   ├── Exercicio4.java      (Selection Sort)
│   ├── Exercicio5.java      (QuickSort)
│   ├── Exercicio6.java      (Merge Sort)
│   ├── Exercicio7.java      (Fibonacci)
│   ├── Exercicio8.java      (Palíndromo)
│   ├── Exercicio9.java      (Busca de Padrão)
│   └── Exercicio10.java     (DFS e BFS)
├── compilar.bat             (Script para compilar)
└── README.md               (Este arquivo)
```

## Como Compilar e Executar

### No Windows:

1. Abra o Prompt de Comando (cmd) na pasta `src/`
2. Execute o script de compilação:
   ```bash
   compilar.bat
   ```
3. Execute cada exercício:
   ```bash
   java Exercicio1
   java Exercicio2
   java Exercicio3
   ...
   ```

### No Linux/Mac:

1. Navegue até a pasta `src/`
2. Compile:
   ```bash
   javac Exercicio1.java
   javac Exercicio2.java
   ...
   ```
3. Execute:
   ```bash
   java Exercicio1
   java Exercicio2
   ...
   ```

## Resumo dos Exercícios

### Exercício 1: Busca Linear com Contagem
- **Algoritmo**: Busca linear que conta comparações
- **Pior caso**: Elemento inexistente ou na última posição
- **Complexidade**: O(n)
- **Saída**: Posição e número de comparações

### Exercício 2: Busca Binária Recursiva
- **Algoritmo**: Busca binária recursiva em vetor ordenado
- **Pior caso**: Elemento não existe no vetor
- **Complexidade**: O(log n)
- **Saída**: Índice e número de iterações

### Exercício 3: Bubble Sort Otimizado
- **Algoritmo**: Bubble sort com flag de otimização
- **Melhor caso**: O(n) - vetor já ordenado
- **Pior caso**: O(n²) - vetor em ordem decrescente
- **Saída**: Comparações, trocas e iterações

### Exercício 4: Selection Sort
- **Algoritmo**: Selection sort com contagem de comparações e trocas
- **Pior caso**: O(n²) - independente da ordem inicial
- **Comparações**: Sempre n(n-1)/2
- **Trocas**: Varia de 0 a n-1
- **Saída**: Comparações e trocas

### Exercício 5: QuickSort com Pivô Fixo
- **Algoritmo**: QuickSort usando primeiro elemento como pivô
- **Melhor caso**: O(n log n) - partições balanceadas
- **Pior caso**: O(n²) - vetor já ordenado ou em ordem inversa
- **Saída**: Número de comparações

### Exercício 6: Merge Sort
- **Algoritmo**: Merge sort com contagem de comparações
- **Complexidade**: O(n log n) em todos os casos
- **Espaço**: O(n) - arrays auxiliares
- **Saída**: Comparações e espaço adicional

### Exercício 7: Fibonacci
- **Versão 1**: Fibonacci recursivo simples - O(2ⁿ)
- **Versão 2**: Fibonacci com memoização - O(n)
- **Versão 3**: Fibonacci com tabulação - O(n)
- **Saída**: Resultado, número de chamadas e tempo

### Exercício 8: Verificação de Palíndromo
- **Algoritmo**: Comparação caractere a caractere
- **Pior caso**: O(n) - todos os caracteres precisam ser comparados
- **Saída**: Se é palíndromo e número de comparações

### Exercício 9: Substring por Força Bruta
- **Algoritmo**: Busca de padrão usando força bruta
- **Pior caso**: O(n · m) - falha no último caractere do padrão
- **Saída**: Posição e número de comparações

### Exercício 10: Percurso em Grafo
- **Algoritmo 1**: DFS (Depth-First Search)
- **Algoritmo 2**: BFS (Breadth-First Search)
- **Complexidade**: O(V + E)
- **Recursos adicionais**: 
  - Verificação de conectividade
  - Contagem de componentes conectadas
- **Saída**: Ordem de visitação, vértices visitados, arestas

## Conceitos Principais

### Notação Big-O
- **O(1)**: Tempo constante
- **O(log n)**: Logarítmico (ex: Busca Binária)
- **O(n)**: Linear (ex: Busca Linear)
- **O(n log n)**: Linearítmico (ex: Merge Sort, QuickSort médio)
- **O(n²)**: Quadrático (ex: Bubble Sort, Selection Sort)
- **O(2ⁿ)**: Exponencial (ex: Fibonacci recursivo)

### Pior Caso vs Melhor Caso
- **Pior caso**: Entrada que requer mais operações
- **Melhor caso**: Entrada que requer menos operações
- **Caso médio**: Comportamento esperado em cenários típicos

## Notas Importantes

1. **Comparações**: Cada exercício conta o número de comparações/operações relevantes
2. **Análise**: Todos os exercícios incluem análise detalhada do pior caso
3. **Exemplos**: Cada exercício fornece múltiplos casos de teste
4. **Justificação**: Explicação clara do porquê da complexidade no pior caso

## Autores
Lista de exercícios sobre Algoritmos e Análise de Complexidade - 10/02/2026
