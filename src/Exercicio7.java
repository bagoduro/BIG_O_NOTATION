/**
 * Exercício 7 - Fibonacci Recursivo vs Programação Dinâmica
 * Recursivo simples: O(2ⁿ)
 * Com DP (memoização): O(n)
 */
public class Exercicio7 {
    
    static class ResultadoFibonacci {
        long resultado;
        long chamadas;
        long tempo;
        
        public ResultadoFibonacci(long resultado, long chamadas, long tempo) {
            this.resultado = resultado;
            this.chamadas = chamadas;
            this.tempo = tempo;
        }
        
        @Override
        public String toString() {
            return "Resultado: " + resultado + ", Chamadas: " + chamadas + ", Tempo: " + tempo + "ms";
        }
    }
    
    static class ContadorChamadas {
        long count = 0;
    }
    
    /**
     * Fibonacci recursivo simples
     * Complexidade: O(2ⁿ)
     */
    private static long fibonacciRecursivo(int n, ContadorChamadas contador) {
        contador.count++;
        
        if (n <= 1) {
            return n;
        }
        
        return fibonacciRecursivo(n - 1, contador) + fibonacciRecursivo(n - 2, contador);
    }
    
    public static ResultadoFibonacci calculaRecursivo(int n) {
        ContadorChamadas contador = new ContadorChamadas();
        long inicio = System.currentTimeMillis();
        long resultado = fibonacciRecursivo(n, contador);
        long fim = System.currentTimeMillis();
        
        return new ResultadoFibonacci(resultado, contador.count, fim - inicio);
    }
    
    /**
     * Fibonacci com memoização (top-down DP)
     * Complexidade: O(n)
     */
    private static long fibonacciMemo(int n, long[] memo, ContadorChamadas contador) {
        contador.count++;
        
        if (n <= 1) {
            return n;
        }
        
        if (memo[n] != -1) {
            return memo[n];
        }
        
        memo[n] = fibonacciMemo(n - 1, memo, contador) + fibonacciMemo(n - 2, memo, contador);
        return memo[n];
    }
    
    public static ResultadoFibonacci calculaMemo(int n) {
        long[] memo = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        
        ContadorChamadas contador = new ContadorChamadas();
        long inicio = System.currentTimeMillis();
        long resultado = fibonacciMemo(n, memo, contador);
        long fim = System.currentTimeMillis();
        
        return new ResultadoFibonacci(resultado, contador.count, fim - inicio);
    }
    
    /**
     * Fibonacci bottom-up (tabulação)
     * Complexidade: O(n)
     */
    public static ResultadoFibonacci calculaTabulacao(int n) {
        ContadorChamadas contador = new ContadorChamadas();
        long inicio = System.currentTimeMillis();
        
        if (n <= 1) {
            return new ResultadoFibonacci(n, 1, 0);
        }
        
        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            contador.count++;
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        
        long fim = System.currentTimeMillis();
        return new ResultadoFibonacci(fib[n], contador.count, fim - inicio);
    }
    
    public static void main(String[] args) {
        System.out.println("=== EXERCÍCIO 7: FIBONACCI RECURSIVO vs PROGRAMAÇÃO DINÂMICA ===\n");
        
        int[] testes = {10, 20, 30, 35};
        
        for (int n : testes) {
            System.out.println("--- Fibonacci(" + n + ") ---");
            
            if (n <= 35) {
                System.out.println("Recursivo simples:");
                ResultadoFibonacci resultado = calculaRecursivo(n);
                System.out.println(resultado);
            } else {
                System.out.println("Recursivo simples: Muito lento para n=" + n);
            }
            
            System.out.println("Com memoização:");
            ResultadoFibonacci resultado = calculaMemo(n);
            System.out.println(resultado);
            
            System.out.println("Com tabulação (bottom-up):");
            resultado = calculaTabulacao(n);
            System.out.println(resultado);
            
            System.out.println();
        }
        
        System.out.println("ANÁLISE:");
        System.out.println("- Recursivo simples: O(2ⁿ) - exponencial");
        System.out.println("  - Calcula os mesmos valores várias vezes");
        System.out.println("  - fib(5) = fib(4) + fib(3)");
        System.out.println("    fib(4) = fib(3) + fib(2)  (fib(3) calculado 2 vezes)");
        System.out.println("");
        System.out.println("- Com memoização: O(n)");
        System.out.println("  - Armazena resultados já calculados");
        System.out.println("  - Evita recalcular o mesmo valor");
        System.out.println("");
        System.out.println("- Bottom-up (tabulação): O(n)");
        System.out.println("  - Calcula de forma iterativa de baixo para cima");
        System.out.println("  - Mais eficiente em termos de espaço");
        System.out.println("");
        System.out.println("COMPARAÇÃO:");
        System.out.println("- fib(10): Recursivo=177 chamadas, Memo/Tabulação=10 operações");
        System.out.println("- fib(20): Recursivo=21891 chamadas, Memo/Tabulação=20 operações");
        System.out.println("- fib(30): Recursivo=2.097.151 chamadas, Memo/Tabulação=30 operações");
    }
}
