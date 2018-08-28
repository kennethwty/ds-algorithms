package Graph_Undirected;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DepthFirstSearch {
    private boolean[] visited; // marks visited vertices
    private int counter; // counts the # of connected vertices

    /**
     * Given a graph and source, we traverse the graph by visiting all the vertices and mark them as visited (true)
     * @param graph Graph object
     * @param source Starting point
     */
    public DepthFirstSearch(Graph graph, int source) {
        // initialize the fields
        visited = new boolean[graph.getV()];
        search(graph, source);
    }

    // DFS to go through all the vertices on the graph
    private void search(Graph graph, int source) {
        // mark the vertex as visited first
        visited[source] = true;
        counter++;
        // go through the adjacency list
        for(int v : graph.adjacencyList(source)) {
            // if it hasn't been visited, mark it as visited
            if(!visited[v])
                // visit the adjacent vertices of that vertex
                search(graph, v);
        }
    }

    // check whether a vertex has been visited (marked)
    public boolean visited(int v) {
        return visited[v];
    }

    public int count() {
        return counter;
    }

    public static void main(String[] args) throws IOException {
        // for user input
        Scanner keyboard = new Scanner(System.in);
        // read the file and create a Graph object
        Scanner scanner = new Scanner(new File("src/Graph_Undirected/test.txt"));
        Graph undirectedGraph = new Graph(scanner);
        System.out.print(undirectedGraph.toString());

        // traversal from source entered by user, pass it the DepthFirstSearch class
        System.out.println();
        System.out.print("Please Enter a Source: ");
        DepthFirstSearch dfs = new DepthFirstSearch(undirectedGraph, keyboard.nextInt());

        for(int v = 0; v < undirectedGraph.getV(); v++) {
            if (dfs.visited(v))
                System.out.print(v + " ");
        }
        System.out.println();

        // if the counter is different from the # of vertices, that means unconnected graph
        if(dfs.count() != undirectedGraph.getV()) {
                System.out.println("Not Connected");
        }
    }
}
