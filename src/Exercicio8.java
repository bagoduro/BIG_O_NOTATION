/**
 * Exercício 8 - Verificação de Palíndromo
 * Pior caso: Todos os caracteres precisam ser comparados - O(n)
 */
public class Exercicio8 {
    
    static class ResultadoPalindromo {
        boolean ehPalindromo;
        int comparacoes;
        
        public ResultadoPalindromo(boolean ehPalindromo, int comparacoes) {
            this.ehPalindromo = ehPalindromo;
            this.comparacoes = comparacoes;
        }
        
        @Override
        public String toString() {
            return "É palíndromo: " + ehPalindromo + ", Comparações: " + comparacoes;
        }
    }
    
    /**
     * Verifica se uma string é palíndromo
     * Complexidade: O(n) - n/2 comparações
     */
    public static ResultadoPalindromo verificaPalindromo(String s) {
        int comparacoes = 0;
        int esquerda = 0;
        int direita = s.length() - 1;
        
        while (esquerda < direita) {
            comparacoes++;
            if (s.charAt(esquerda) != s.charAt(direita)) {
                return new ResultadoPalindromo(false, comparacoes);
            }
            esquerda++;
            direita--;
        }
        
        return new ResultadoPalindromo(true, comparacoes);
    }
    
    /**
     * Verifica palíndromo ignorando espaços e maiúsculas/minúsculas
     */
    public static ResultadoPalindromo verificaPalindromomIgnorando(String s) {
        // Remove espaços e converte para minúsculas
        s = s.replaceAll(" ", "").toLowerCase();
        
        int comparacoes = 0;
        int esquerda = 0;
        int direita = s.length() - 1;
        
        while (esquerda < direita) {
            comparacoes++;
            if (s.charAt(esquerda) != s.charAt(direita)) {
                return new ResultadoPalindromo(false, comparacoes);
            }
            esquerda++;
            direita--;
        }
        
        return new ResultadoPalindromo(true, comparacoes);
    }
    
    public static void main(String[] args) {
        System.out.println("=== EXERCÍCIO 8: VERIFICAÇÃO DE PALÍNDROMO ===\n");
        
        String[] testes = {
            "aba",
            "racecar",
            "hello",
            "a",
            "ab",
            "abcdefedcba",
            "abcdefghijihgfedcba"
        };
        
        System.out.println("Teste com verificação básica:");
        for (String s : testes) {
            ResultadoPalindromo resultado = verificaPalindromo(s);
            System.out.println("\"" + s + "\": " + resultado);
        }
        
        System.out.println("\n--- Versão com ignoração de espaços e maiúsculas ---\n");
        
        String[] testesAvancados = {
            "A man a plan a canal Panama",
            "Socorram me subi no onibus em Marrocos",
            "race a car",
            "hello world"
        };
        
        System.out.println("Teste com ignoração de espaços e maiúsculas:");
        for (String s : testesAvancados) {
            ResultadoPalindromo resultado = verificaPalindromomIgnorando(s);
            System.out.println("\"" + s + "\": " + resultado);
        }
        
        System.out.println("\nANÁLISE:");
        System.out.println("- Pior caso: Todos os caracteres precisam ser comparados");
        System.out.println("- Exemplo: 'abcdefedcba' (palíndromo verdadeiro)");
        System.out.println("- Comparações: n/2 (onde n é o comprimento da string)");
        System.out.println("- Complexidade no pior caso: O(n)");
        System.out.println("- Melhor caso: O(1) - primeira comparação falha");
        System.out.println("- Caso médio: O(n/2) = O(n)");
        System.out.println("");
        System.out.println("Justificação:");
        System.out.println("- Precisamos verificar cada par (esquerda, direita)");
        System.out.println("- No pior caso, todos os caracteres correspondem");
        System.out.println("- Fazemos n/2 comparações antes de concluir que é palíndromo");
    }
}
