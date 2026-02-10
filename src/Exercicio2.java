/**
 * Exercício 2 - Busca Binária Recursiva
 * Pior caso: Elemento não está no vetor - O(log n)
 */
public class Exercicio2 {
    
    static class ResultadoBuscaBinaria {
        int indice;
        int iteracoes;
        
        public ResultadoBuscaBinaria(int indice, int iteracoes) {
            this.indice = indice;
            this.iteracoes = iteracoes;
        }
        
        @Override
        public String toString() {
            return "Índice: " + indice + ", Iterações: " + iteracoes;
        }
    }
    
    static class ContadorIteracoes {
        int count = 0;
    }
    
    /**
     * Busca binária recursiva em vetor ordenado
     * Complexidade: O(log n) no pior caso
     */
    private static int buscaBinariaRecursiva(int[] vetor, int esquerda, int direita, 
                                             int x, ContadorIteracoes contador) {
        if (esquerda > direita) {
            return -1;
        }
        
        int meio = esquerda + (direita - esquerda) / 2;
        contador.count++;
        
        if (vetor[meio] == x) {
            return meio;
        } else if (vetor[meio] < x) {
            return buscaBinariaRecursiva(vetor, meio + 1, direita, x, contador);
        } else {
            return buscaBinariaRecursiva(vetor, esquerda, meio - 1, x, contador);
        }
    }
    
    public static ResultadoBuscaBinaria busca(int[] vetor, int x) {
        ContadorIteracoes contador = new ContadorIteracoes();
        int indice = buscaBinariaRecursiva(vetor, 0, vetor.length - 1, x, contador);
        return new ResultadoBuscaBinaria(indice, contador.count);
    }
    
    public static void main(String[] args) {
        int[] vetor = {10, 20, 30, 40, 50, 60, 70, 80}; // tamanho = 8 (2³)
        
        System.out.println("=== EXERCÍCIO 2: BUSCA BINÁRIA RECURSIVA ===\n");
        System.out.println("Vetor: " + java.util.Arrays.toString(vetor) + "\n");
        
        // Melhor caso: elemento no meio
        System.out.println("Melhor caso (elemento no meio):");
        ResultadoBuscaBinaria resultado = busca(vetor, 40);
        System.out.println("Procurando 40: " + resultado + "\n");
        
        // Pior caso: elemento não existe
        System.out.println("Pior caso (elemento não existe):");
        resultado = busca(vetor, 25);
        System.out.println("Procurando 25: " + resultado + "\n");
        
        System.out.println("Procurando 5 (antes de todos):");
        resultado = busca(vetor, 5);
        System.out.println("Procurando 5: " + resultado + "\n");
        
        System.out.println("Procurando 100 (depois de todos):");
        resultado = busca(vetor, 100);
        System.out.println("Procurando 100: " + resultado + "\n");
        
        System.out.println("ANÁLISE:");
        System.out.println("- Pior caso: Elemento não está no vetor");
        System.out.println("- Complexidade no pior caso: O(log n)");
        System.out.println("- Justificação: A cada chamada recursiva, o espaço de busca é reduzido pela metade");
        System.out.println("  Para um vetor com 8 elementos: log₂(8) = 3 iterações máximo");
    }
}
