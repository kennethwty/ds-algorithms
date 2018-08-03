package UndirectedGraph;

import LinkedList_Stack_Queue.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ConnectedComponent {
    private int counter;
    private int[] id;
    private boolean[] visited;

    public ConnectedComponent(Graph g) {
        visited = new boolean[g.getV()];
        // there will only be #ofV different identifiers at most
        id = new int[g.getV()];
        for(int v = 0; v < g.getV(); v++) {
            if(!visited[v]) {
                dfs(g, v);
                counter++;
            }
        }
    }

    public void dfs(Graph g, int v) {
        visited[v] = true;
        id[v] = counter;
        for(int neighbor : g.adjacencyList(v)) {
            if(!visited[neighbor]) {
                dfs(g, neighbor);
            }
        }
    }

    public boolean connected(int v1, int v2) {
        return id[v1] == id[v2];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return counter;
    }

    public static void main(String[] args) throws IOException {
        // read the file and create a Graph object
        Scanner scanner = new Scanner(new File("src/UndirectedGraph/test.txt"));
        Graph undirectedGraph = new Graph(scanner);
        System.out.print(undirectedGraph.toString());
        System.out.println();

        // following code from Sedgewick's Algorithm book
        ConnectedComponent cc = new ConnectedComponent(undirectedGraph);
        int components = cc.count();
        System.out.println(components + " components");

        Queue<Integer>[] queue = new Queue[components];
        for(int i = 0; i < components; i++) {
            queue[i] = new Queue<>();
        }
        for(int v = 0; v < undirectedGraph.getV(); v++) {
            queue[cc.id(v)].enqueue(v);
        }
        for(int i = 0; i < components; i++) {
            for(int vertex : queue[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}