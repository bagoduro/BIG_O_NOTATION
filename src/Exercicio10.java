import java.util.*;

/**
 * Exercício 10 - Percurso Completo em Grafo (DFS e BFS)
 * Pior caso: Todos os vértices e arestas precisam ser visitados - O(V + E)
 */
public class Exercicio10 {
    
    /**
     * Classe para representar um grafo usando lista de adjacência
     */
    static class Grafo {
        private int vertices;
        private List<Integer>[] adjacencia;
        private int comparacoes;
        private int arestasCaminhadas;
        
        @SuppressWarnings("unchecked")
        public Grafo(int v) {
            this.vertices = v;
            this.adjacencia = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjacencia[i] = new LinkedList<>();
            }
            this.comparacoes = 0;
            this.arestasCaminhadas = 0;
        }
        
        /**
         * Adiciona uma aresta ao grafo (direcionado)
         */
        public void adicionaAresta(int u, int v) {
            adjacencia[u].add(v);
            adjacencia[v].add(u); // Para grafo não-direcionado
        }
        
        /**
         * DFS (Depth-First Search) - Busca em Profundidade
         * Complexidade: O(V + E)
         */
        public void dfs(int inicio) {
            System.out.println("\n--- DFS a partir do vértice " + inicio + " ---");
            boolean[] visitado = new boolean[vertices];
            List<Integer> ordem = new ArrayList<>();
            
            resetaEstatisticas();
            long tempoInicio = System.currentTimeMillis();
            
            dfsAuxiliar(inicio, visitado, ordem);
            
            long tempoFim = System.currentTimeMillis();
            
            System.out.println("Ordem de visitação: " + ordem);
            System.out.println("Vértices visitados: " + ordem.size());
            System.out.println("Arestas caminhadas: " + arestasCaminhadas);
            System.out.println("Tempo: " + (tempoFim - tempoInicio) + "ms");
        }
        
        /**
         * Função auxiliar para DFS (recursiva)
         */
        private void dfsAuxiliar(int u, boolean[] visitado, List<Integer> ordem) {
            visitado[u] = true;
            ordem.add(u);
            
            for (int v : adjacencia[u]) {
                comparacoes++;
                if (!visitado[v]) {
                    arestasCaminhadas++;
                    dfsAuxiliar(v, visitado, ordem);
                }
            }
        }
        
        /**
         * BFS (Breadth-First Search) - Busca em Largura
         * Complexidade: O(V + E)
         */
        public void bfs(int inicio) {
            System.out.println("\n--- BFS a partir do vértice " + inicio + " ---");
            boolean[] visitado = new boolean[vertices];
            List<Integer> ordem = new ArrayList<>();
            Queue<Integer> fila = new LinkedList<>();
            
            resetaEstatisticas();
            long tempoInicio = System.currentTimeMillis();
            
            visitado[inicio] = true;
            fila.add(inicio);
            
            while (!fila.isEmpty()) {
                int u = fila.poll();
                ordem.add(u);
                
                for (int v : adjacencia[u]) {
                    comparacoes++;
                    if (!visitado[v]) {
                        visitado[v] = true;
                        arestasCaminhadas++;
                        fila.add(v);
                    }
                }
            }
            
            long tempoFim = System.currentTimeMillis();
            
            System.out.println("Ordem de visitação: " + ordem);
            System.out.println("Vértices visitados: " + ordem.size());
            System.out.println("Arestas caminhadas: " + arestasCaminhadas);
            System.out.println("Tempo: " + (tempoFim - tempoInicio) + "ms");
        }
        
        /**
         * Verifica conectividade: todos os vértices podem ser alcançados do vértice inicial
         */
        public boolean ehConectado(int inicio) {
            boolean[] visitado = new boolean[vertices];
            dfsAuxiliar(inicio, visitado, new ArrayList<>());
            
            for (boolean v : visitado) {
                if (!v) {
                    return false;
                }
            }
            return true;
        }
        
        /**
         * Conta o número de componentes conectadas
         */
        public int contaComponentesConectadas() {
            boolean[] visitado = new boolean[vertices];
            int componentes = 0;
            
            for (int i = 0; i < vertices; i++) {
                if (!visitado[i]) {
                    dfsAuxiliar(i, visitado, new ArrayList<>());
                    componentes++;
                }
            }
            
            return componentes;
        }
        
        private void resetaEstatisticas() {
            comparacoes = 0;
            arestasCaminhadas = 0;
        }
        
        public int getVertices() {
            return vertices;
        }
        
        public void exibeAdjacencia() {
            System.out.println("\nLista de adjacência:");
            for (int i = 0; i < vertices; i++) {
                System.out.print("Vértice " + i + ": ");
                for (int v : adjacencia[i]) {
                    System.out.print(v + " ");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== EXERCÍCIO 10: PERCURSO EM GRAFO (DFS e BFS) ===\n");
        
        // Exemplo 1: Grafo simples
        System.out.println("--- EXEMPLO 1: Grafo Simples (conectado) ---");
        Grafo grafo1 = new Grafo(6);
        grafo1.adicionaAresta(0, 1);
        grafo1.adicionaAresta(0, 2);
        grafo1.adicionaAresta(1, 3);
        grafo1.adicionaAresta(2, 3);
        grafo1.adicionaAresta(3, 4);
        grafo1.adicionaAresta(4, 5);
        
        grafo1.exibeAdjacencia();
        grafo1.dfs(0);
        grafo1.bfs(0);
        
        System.out.println("\nConectado a partir do vértice 0? " + grafo1.ehConectado(0));
        
        // Exemplo 2: Grafo com múltiplas componentes
        System.out.println("\n\n--- EXEMPLO 2: Grafo com Múltiplas Componentes ---");
        Grafo grafo2 = new Grafo(8);
        // Primeira componente
        grafo2.adicionaAresta(0, 1);
        grafo2.adicionaAresta(0, 2);
        grafo2.adicionaAresta(1, 2);
        // Segunda componente
        grafo2.adicionaAresta(3, 4);
        grafo2.adicionaAresta(4, 5);
        // Terceira componente
        grafo2.adicionaAresta(6, 7);
        
        grafo2.exibeAdjacencia();
        grafo2.dfs(0);
        grafo2.bfs(0);
        
        System.out.println("\nNúmero de componentes conectadas: " + grafo2.contaComponentesConectadas());
        
        // Exemplo 3: Grafo mais complexo (árvore)
        System.out.println("\n\n--- EXEMPLO 3: Grafo em Forma de Árvore ---");
        Grafo grafo3 = new Grafo(7);
        grafo3.adicionaAresta(0, 1);
        grafo3.adicionaAresta(0, 2);
        grafo3.adicionaAresta(1, 3);
        grafo3.adicionaAresta(1, 4);
        grafo3.adicionaAresta(2, 5);
        grafo3.adicionaAresta(2, 6);
        
        grafo3.exibeAdjacencia();
        grafo3.dfs(0);
        grafo3.bfs(0);
        
        System.out.println("\n\nANÁLISE:");
        System.out.println("- Complexidade DFS: O(V + E)");
        System.out.println("  Onde V = número de vértices, E = número de arestas");
        System.out.println("  Cada vértice é visitado uma vez: O(V)");
        System.out.println("  Cada aresta é verificada uma vez: O(E)");
        System.out.println("");
        System.out.println("- Complexidade BFS: O(V + E)");
        System.out.println("  Mesma complexidade que DFS, mas ordem diferente");
        System.out.println("");
        System.out.println("- Pior caso: Todos os vértices e arestas precisam ser visitados");
        System.out.println("  Exemplo: Grafo completamente conectado");
        System.out.println("  E_max = V(V-1)/2");
        System.out.println("");
        System.out.println("- Espaço:");
        System.out.println("  DFS (recursivo): O(V) - pilha de recursão");
        System.out.println("  BFS: O(V) - fila de espera");
        System.out.println("  Lista de adjacência: O(V + E)");
    }
}
