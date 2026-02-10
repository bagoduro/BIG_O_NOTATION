/**
 * Exercício 4 - Selection Sort e Análise de Trocas
 * Pior caso: Independente da ordem inicial - O(n²)
 */
public class Exercicio4 {
    
    static class ResultadoSelectionSort {
        int[] vetor;
        int comparacoes;
        int trocas;
        
        public ResultadoSelectionSort(int[] vetor, int comparacoes, int trocas) {
            this.vetor = vetor;
            this.comparacoes = comparacoes;
            this.trocas = trocas;
        }
        
        @Override
        public String toString() {
            return "Comparações: " + comparacoes + ", Trocas: " + trocas;
        }
    }
    
    /**
     * Selection Sort com contagem de comparações e trocas
     * Sempre realiza O(n²) comparações
     * Trocas variam de 0 a n-1
     */
    public static ResultadoSelectionSort selectionSort(int[] vetor) {
        int n = vetor.length;
        int comparacoes = 0;
        int trocas = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            // Encontra o menor elemento na parte não ordenada
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Troca se necessário
            if (minIndex != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minIndex];
                vetor[minIndex] = temp;
                trocas++;
            }
        }
        
        return new ResultadoSelectionSort(vetor, comparacoes, trocas);
    }
    
    public static void main(String[] args) {
        System.out.println("=== EXERCÍCIO 4: SELECTION SORT ===\n");
        
        // Caso 1: Vetor já ordenado
        System.out.println("CASO 1: Vetor já ordenado");
        int[] caso1 = {10, 20, 30, 40, 50};
        System.out.println("Antes: " + java.util.Arrays.toString(caso1));
        ResultadoSelectionSort resultado = selectionSort(caso1.clone());
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        // Caso 2: Vetor aleatório
        System.out.println("CASO 2: Vetor aleatório");
        int[] caso2 = {30, 10, 50, 20, 40};
        System.out.println("Antes: " + java.util.Arrays.toString(caso2));
        resultado = selectionSort(caso2.clone());
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        // Caso 3: Vetor em ordem decrescente
        System.out.println("CASO 3: Vetor em ordem decrescente");
        int[] caso3 = {50, 40, 30, 20, 10};
        System.out.println("Antes: " + java.util.Arrays.toString(caso3));
        resultado = selectionSort(caso3.clone());
        System.out.println("Depois: " + java.util.Arrays.toString(resultado.vetor));
        System.out.println(resultado + "\n");
        
        System.out.println("ANÁLISE:");
        System.out.println("- Comparações: Sempre (n-1) + (n-2) + ... + 1 = n(n-1)/2 = O(n²)");
        System.out.println("- Trocas: Variam de 0 (vetor ordenado) a n-1 (ordem decrescente)");
        System.out.println("- O número de comparações NÃO depende da ordem inicial");
        System.out.println("- O número de trocas SIM depende da ordem inicial");
        System.out.println("- Complexidade no pior caso: O(n²) - trocas ou comparações");
    }
}
