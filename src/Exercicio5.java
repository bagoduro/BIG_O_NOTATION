/**
 * Exercício 5 - QuickSort com Pivô Fixo (primeiro elemento)
 * Pior caso: Vetor já ordenado ou ordenado inversamente - O(n²)
 */
public class Exercicio5 {
    
    static class ResultadoQuickSort {
        int[] vetor;
        int comparacoes;
        
        public ResultadoQuickSort(int[] vetor, int comparacoes) {
            this.vetor = vetor;
            this.comparacoes = comparacoes;
        }
        
        @Override
        public String toString() {
            return "Comparações: " + comparacoes;
        }
    }
    
    static class ContadorComparacoes {
        int count = 0;
    }
    
    /**
     * QuickSort com pivô fixo (primeiro elemento)
     * Complexidade: O(n log n) médio, O(n²) pior caso
     */
    private static void quickSortFixo(int[] vetor, int esquerda, int direita, 
                                      ContadorComparacoes contador) {
        if (esquerda < direita) {
            int pi = particao(vetor, esquerda, direita, contador);
            quickSortFixo(vetor, esquerda, pi - 1, contador);
            quickSortFixo(vetor, pi + 1, direita, contador);
        }
    }
    
    /**
     * Particiona o vetor usando o primeiro elemento como pivô
     */
    private static int particao(int[] vetor, int esquerda, int direita, 
                               ContadorComparacoes contador) {
        int pivo = vetor[esquerda];
        int i = esquerda + 1;
        int j = direita;
        
        while (i <= j) {
            while (i <= j && vetor[i] < pivo) {
                contador.count++;
                i++;
            }
            while (i <= j && vetor[j] > pivo) {
                contador.count++;
                j--;
            }
            
            if (i < j) {
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
                i++;
                j--;
            }
        }
        
        // Coloca o pivô na posição correta
        vetor[esquerda] = vetor[j];
        vetor[j] = pivo;
        
        return j;
    }
    
    public static ResultadoQuickSort quickSort(int[] vetor) {
        ContadorComparacoes contador = new ContadorComparacoes();
        int[] copia = vetor.clone();
        quickSortFixo(copia, 0, copia.length - 1, contador);
        return new ResultadoQuickSort(copia, contador.count);
    }
    
    public static void main(String[] args) {
        System.out.println("=== EXERCÍCIO 5: QUICKSORT COM PIVÔ FIXO ===\n");
        
        // Melhor caso: elementos espalhados
        System.out.println("MELHOR CASO: Elementos bem distribuídos");
        int[] melhorCaso = {30, 10, 50, 20, 40};
        System.out.println("Antes: " + java.util.Arrays.toString(melhorCaso));
        ResultadoQuickSort resultado = quickSort(melhorCaso);
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        // Pior caso 1: Vetor já ordenado
        System.out.println("PIOR CASO 1: Vetor já ordenado");
        int[] piorCaso1 = {10, 20, 30, 40, 50};
        System.out.println("Antes: " + java.util.Arrays.toString(piorCaso1));
        resultado = quickSort(piorCaso1);
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        // Pior caso 2: Vetor em ordem decrescente
        System.out.println("PIOR CASO 2: Vetor em ordem decrescente");
        int[] piorCaso2 = {50, 40, 30, 20, 10};
        System.out.println("Antes: " + java.util.Arrays.toString(piorCaso2));
        resultado = quickSort(piorCaso2);
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        System.out.println("ANÁLISE:");
        System.out.println("- Pior caso: Vetor já ordenado ou em ordem decrescente");
        System.out.println("- Complexidade no pior caso: O(n²)");
        System.out.println("- Causa: Pivô fixo (primeiro elemento) causa divisões desbalanceadas");
        System.out.println("- Comparações: 4 + 3 + 2 + 1 = 10 comparações para 5 elementos");
        System.out.println("- Nota: Usar pivô aleatório ou mediana-de-três reduz chance do pior caso");
    }
}
