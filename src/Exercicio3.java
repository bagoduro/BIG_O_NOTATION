/**
 * Exercício 3 - Ordenação por Bubble Sort Otimizado
 * Pior caso: Vetor ordenado em ordem decrescente - O(n²)
 */
public class Exercicio3 {
    
    static class ResultadoBubbleSort {
        int[] vetor;
        int comparacoes;
        int trocas;
        int iteracoes;
        
        public ResultadoBubbleSort(int[] vetor, int comparacoes, int trocas, int iteracoes) {
            this.vetor = vetor;
            this.comparacoes = comparacoes;
            this.trocas = trocas;
            this.iteracoes = iteracoes;
        }
        
        @Override
        public String toString() {
            return "Comparações: " + comparacoes + ", Trocas: " + trocas + ", Iterações: " + iteracoes;
        }
    }
    
    /**
     * Bubble Sort otimizado com flag
     * Interrompe se o vetor já está ordenado
     * Complexidade: O(n) melhor caso, O(n²) pior caso
     */
    public static ResultadoBubbleSort bubbleSortOtimizado(int[] vetor) {
        int n = vetor.length;
        int comparacoes = 0;
        int trocas = 0;
        int iteracoes = 0;
        
        for (int i = 0; i < n - 1; i++) {
            boolean trocouAlgo = false;
            iteracoes++;
            
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                
                if (vetor[j] > vetor[j + 1]) {
                    // Troca
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocas++;
                    trocouAlgo = true;
                }
            }
            
            // Se nenhuma troca foi feita, o vetor está ordenado
            if (!trocouAlgo) {
                break;
            }
        }
        
        return new ResultadoBubbleSort(vetor, comparacoes, trocas, iteracoes);
    }
    
    public static void main(String[] args) {
        System.out.println("=== EXERCÍCIO 3: BUBBLE SORT OTIMIZADO ===\n");
        
        // Melhor caso: vetor já ordenado
        System.out.println("MELHOR CASO: Vetor já ordenado");
        int[] melhorCaso = {10, 20, 30, 40, 50};
        System.out.println("Antes: " + java.util.Arrays.toString(melhorCaso));
        ResultadoBubbleSort resultado = bubbleSortOtimizado(melhorCaso.clone());
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        // Caso médio: vetor aleatório
        System.out.println("CASO MÉDIO: Vetor aleatório");
        int[] casoMedio = {30, 10, 50, 20, 40};
        System.out.println("Antes: " + java.util.Arrays.toString(casoMedio));
        resultado = bubbleSortOtimizado(casoMedio.clone());
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        // Pior caso: vetor em ordem decrescente
        System.out.println("PIOR CASO: Vetor em ordem decrescente");
        int[] piorCaso = {50, 40, 30, 20, 10};
        System.out.println("Antes: " + java.util.Arrays.toString(piorCaso));
        resultado = bubbleSortOtimizado(piorCaso.clone());
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        System.out.println("ANÁLISE:");
        System.out.println("- Melhor caso: O(n) - quando o vetor já está ordenado (1 iteração)");
        System.out.println("- Pior caso: O(n²) - quando o vetor está em ordem decrescente");
        System.out.println("- Justificação do pior caso: (n-1) + (n-2) + ... + 1 = n(n-1)/2 comparações");
        System.out.println("- A flag otimização reduz iterações desnecessárias");
    }
}
