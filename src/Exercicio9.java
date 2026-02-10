/**
 * Exercício 9 - Substring por Força Bruta
 * Pior caso: Falha apenas no último caractere do padrão, repetidamente - O(n · m)
 */
public class Exercicio9 {
    
    static class ResultadoBuscaSubstring {
        int posicao;
        int comparacoes;
        
        public ResultadoBuscaSubstring(int posicao, int comparacoes) {
            this.posicao = posicao;
            this.comparacoes = comparacoes;
        }
        
        @Override
        public String toString() {
            return "Posição: " + posicao + ", Comparações: " + comparacoes;
        }
    }
    
    /**
     * Busca de padrão por força bruta
     * Texto T com tamanho n, Padrão P com tamanho m
     * Complexidade: O(n · m) no pior caso
     */
    public static ResultadoBuscaSubstring buscaForcaBruta(String texto, String padrao) {
        int n = texto.length();
        int m = padrao.length();
        int comparacoes = 0;
        
        if (m > n) {
            return new ResultadoBuscaSubstring(-1, 0);
        }
        
        // Tenta encontrar o padrão em cada posição do texto
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            
            // Compara caractere a caractere
            while (j < m && texto.charAt(i + j) == padrao.charAt(j)) {
                comparacoes++;
                j++;
            }
            
            // Se conseguiu encontrar o padrão inteiro
            if (j == m) {
                return new ResultadoBuscaSubstring(i, comparacoes);
            }
            
            // Conta a comparação que falhou
            if (j < m) {
                comparacoes++;
            }
        }
        
        return new ResultadoBuscaSubstring(-1, comparacoes);
    }
    
    public static void main(String[] args) {
        System.out.println("=== EXERCÍCIO 9: BUSCA DE PADRÃO (SUBSTRING) ===\n");
        
        // Melhor caso: padrão no início
        System.out.println("MELHOR CASO: Padrão no início");
        ResultadoBuscaSubstring resultado = buscaForcaBruta("ABCDEF", "ABC");
        System.out.println("Texto: \"ABCDEF\", Padrão: \"ABC\"");
        System.out.println("Resultado: " + resultado + "\n");
        
        // Caso médio: padrão no meio
        System.out.println("CASO MÉDIO: Padrão no meio");
        resultado = buscaForcaBruta("ABCDEF", "CDE");
        System.out.println("Texto: \"ABCDEF\", Padrão: \"CDE\"");
        System.out.println("Resultado: " + resultado + "\n");
        
        // Pior caso: falha no último caractere
        System.out.println("PIOR CASO: Padrão não encontrado (falha no último caractere)");
        resultado = buscaForcaBruta("AAAAAAB", "AAAB");
        System.out.println("Texto: \"AAAAAAB\", Padrão: \"AAAB\"");
        System.out.println("Resultado: " + resultado);
        System.out.println("Explicação: Compara AAA com AAB (falha no último caractere) 4 vezes");
        System.out.println();
        
        // Outro pior caso: muitas repetições
        System.out.println("OUTRO PIOR CASO: Muitas repetições");
        String texto = "AAAAAAAAAB";
        String padrao = "AAAB";
        resultado = buscaForcaBruta(texto, padrao);
        System.out.println("Texto: \"" + texto + "\", Padrão: \"" + padrao + "\"");
        System.out.println("Resultado: " + resultado);
        System.out.println("Comparações: (10-4+1) * 4 = 28 comparações no pior caso");
        System.out.println();
        
        // Padrão encontrado
        System.out.println("PADRÃO ENCONTRADO:");
        resultado = buscaForcaBruta("ABCDEFG", "CDE");
        System.out.println("Texto: \"ABCDEFG\", Padrão: \"CDE\"");
        System.out.println("Resultado: " + resultado + "\n");
        
        System.out.println("ANÁLISE:");
        System.out.println("- Texto T com tamanho n, Padrão P com tamanho m");
        System.out.println("- Tenta encontrar o padrão em cada posição: (n - m + 1) iterações");
        System.out.println("- Em cada iteração: até m comparações de caracteres");
        System.out.println("- Pior caso: (n - m + 1) · m ≈ O(n · m)");
        System.out.println("");
        System.out.println("Exemplo do pior caso:");
        System.out.println("- Texto: \"AAAAAAAAAB\" (n=10)");
        System.out.println("- Padrão: \"AAAB\" (m=4)");
        System.out.println("- Comparações: 7 posições × 4 caracteres = 28 comparações");
        System.out.println("");
        System.out.println("Otimizações possíveis:");
        System.out.println("- KMP (Knuth-Morris-Pratt): O(n + m)");
        System.out.println("- Boyer-Moore: Frequentemente mais rápido na prática");
        System.out.println("- Rabin-Karp: O(n + m) em média");
    }
}
