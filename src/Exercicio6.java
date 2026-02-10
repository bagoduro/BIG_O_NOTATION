/**
 * Exercício 6 - Merge Sort e Uso de Memória
 * Pior caso: O mesmo para qualquer entrada - O(n log n)
 */
public class Exercicio6 {
    
    static class ResultadoMergeSort {
        int[] vetor;
        int comparacoes;
        int memoriaAdicional;
        
        public ResultadoMergeSort(int[] vetor, int comparacoes, int memoriaAdicional) {
            this.vetor = vetor;
            this.comparacoes = comparacoes;
            this.memoriaAdicional = memoriaAdicional;
        }
        
        @Override
        public String toString() {
            return "Comparações: " + comparacoes + ", Memória adicional: " + memoriaAdicional + " elementos";
        }
    }
    
    static class ContadorComparacoes {
        int count = 0;
    }
    
    /**
     * Merge Sort com contagem de comparações
     * Complexidade: O(n log n) em todos os casos
     * Espaço: O(n) para arrays auxiliares
     */
    private static void mergeSort(int[] vetor, int esquerda, int direita, 
                                   ContadorComparacoes contador) {
        if (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            
            // Divide
            mergeSort(vetor, esquerda, meio, contador);
            mergeSort(vetor, meio + 1, direita, contador);
            
            // Conquista (combina)
            merge(vetor, esquerda, meio, direita, contador);
        }
    }
    
    /**
     * Combina duas submatrizes ordenadas
     */
    private static void merge(int[] vetor, int esquerda, int meio, int direita, 
                             ContadorComparacoes contador) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;
        
        // Arrays auxiliares
        int[] esquerdaArr = new int[n1];
        int[] direitaArr = new int[n2];
        
        // Copia dados
        System.arraycopy(vetor, esquerda, esquerdaArr, 0, n1);
        System.arraycopy(vetor, meio + 1, direitaArr, 0, n2);
        
        int i = 0, j = 0, k = esquerda;
        
        // Combina as duas submatrizes
        while (i < n1 && j < n2) {
            contador.count++;
            if (esquerdaArr[i] <= direitaArr[j]) {
                vetor[k++] = esquerdaArr[i++];
            } else {
                vetor[k++] = direitaArr[j++];
            }
        }
        
        // Copia elementos restantes
        while (i < n1) {
            vetor[k++] = esquerdaArr[i++];
        }
        
        while (j < n2) {
            vetor[k++] = direitaArr[j++];
        }
    }
    
    public static ResultadoMergeSort mergeSort(int[] vetor) {
        ContadorComparacoes contador = new ContadorComparacoes();
        int[] copia = vetor.clone();
        mergeSort(copia, 0, copia.length - 1, contador);
        
        // Memória adicional = tamanho do vetor original
        int memoriaAdicional = vetor.length;
        
        return new ResultadoMergeSort(copia, contador.count, memoriaAdicional);
    }
    
    public static void main(String[] args) {
        System.out.println("=== EXERCÍCIO 6: MERGE SORT ===\n");
        
        // Caso 1: Vetor aleatório
        System.out.println("CASO 1: Vetor aleatório");
        int[] caso1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Antes: " + java.util.Arrays.toString(caso1));
        ResultadoMergeSort resultado = mergeSort(caso1);
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        // Caso 2: Vetor já ordenado
        System.out.println("CASO 2: Vetor já ordenado");
        int[] caso2 = {10, 20, 30, 40, 50};
        System.out.println("Antes: " + java.util.Arrays.toString(caso2));
        resultado = mergeSort(caso2);
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        // Caso 3: Vetor em ordem decrescente
        System.out.println("CASO 3: Vetor em ordem decrescente");
        int[] caso3 = {50, 40, 30, 20, 10};
        System.out.println("Antes: " + java.util.Arrays.toString(caso3));
        resultado = mergeSort(caso3);
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        System.out.println("ANÁLISE:");
        System.out.println("- Melhor caso: O(n log n)");
        System.out.println("- Caso médio: O(n log n)");
        System.out.println("- Pior caso: O(n log n) - IGUAL em todas as situações");
        System.out.println("- Justificação: O vetor é sempre dividido pela metade log₂(n) vezes");
        System.out.println("  e cada merge leva O(n) comparações");
        System.out.println("- Espaço adicional: O(n) - precisa de arrays auxiliares");
        System.out.println("- Vantagem: Desempenho previsível");
        System.out.println("- Desvantagem: Usa mais memória que QuickSort");
    }
}
