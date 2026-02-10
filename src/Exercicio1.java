/**
 * Exercício 1 - Busca Linear com Contagem de Comparações
 * Pior caso: Elemento inexistente ou na última posição - O(n)
 */
public class Exercicio1 {
    
    static class ResultadoBuscaLinear {
        int posicao;
        int comparacoes;
        
        public ResultadoBuscaLinear(int posicao, int comparacoes) {
            this.posicao = posicao;
            this.comparacoes = comparacoes;
        }
        
        @Override
        public String toString() {
            return "Posição: " + posicao + ", Comparações: " + comparacoes;
        }
    }
    
    /**
     * Busca linear que conta o número de comparações
     * Complexidade: O(n) no pior caso
     */
    public static ResultadoBuscaLinear buscaLinear(int[] vetor, int x) {
        int comparacoes = 0;
        
        for (int i = 0; i < vetor.length; i++) {
            comparacoes++;
            if (vetor[i] == x) {
                return new ResultadoBuscaLinear(i, comparacoes);
            }
        }
        
        return new ResultadoBuscaLinear(-1, comparacoes);
    }
    
    public static void main(String[] args) {
        int[] vetor = {10, 25, 30, 45, 50, 65, 75, 90};
        
        System.out.println("=== EXERCÍCIO 1: BUSCA LINEAR ===\n");
        
        // Melhor caso: elemento no início
        System.out.println("Melhor caso (elemento no início):");
        ResultadoBuscaLinear resultado = buscaLinear(vetor, 10);
        System.out.println("Procurando 10: " + resultado + "\n");
        
        // Caso médio: elemento no meio
        System.out.println("Caso médio (elemento no meio):");
        resultado = buscaLinear(vetor, 45);
        System.out.println("Procurando 45: " + resultado + "\n");
        
        // Pior caso: elemento inexistente
        System.out.println("Pior caso (elemento inexistente):");
        resultado = buscaLinear(vetor, 100);
        System.out.println("Procurando 100: " + resultado + "\n");
        
        // Pior caso: elemento na última posição
        System.out.println("Pior caso (elemento na última posição):");
        resultado = buscaLinear(vetor, 90);
        System.out.println("Procurando 90: " + resultado + "\n");
        
        System.out.println("ANÁLISE:");
        System.out.println("- Pior caso: Elemento inexistente ou na última posição");
        System.out.println("- Complexidade no pior caso: O(n)");
        System.out.println("- Justificação: Precisa verificar cada elemento do vetor");
    }
}
