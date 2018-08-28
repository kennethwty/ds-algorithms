package Graph_Directed;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

// A Simple Directed Graph ADT
public class DirectedGraph {
    private final int V;
    private int E;
    private LinkedList<Integer>[] adjList;

    public DirectedGraph(int V) {
        if(V < 0) throw new IllegalArgumentException("Negative number of vertices unaccepted.");

        this.V = V;
        this.E = 0;
        adjList = (LinkedList<Integer>[]) new LinkedList[V];
        for(int v = 0; v < V; v++) {
            adjList[v] = new LinkedList<>();
        }
    }

    // this constructor takes a file as input
    // the first element is the number of vertices
    // the second element is the number of edges
    // following that is a list of pairs of edges
    public DirectedGraph(Scanner input) throws IOException {
        this(input.nextInt());
        int edges = input.nextInt();
        for(int i = 0; i < edges; i++) {
            // input vertices will be in the format of v1 v2
            // starting from 0 to V-1
            int v1 = input.nextInt();
            int v2 = input.nextInt();
            // add the edge to the list
            addEdge(v1, v2);
        }
    }

    // for a directed edge v1 -> v2
    // add v2 to v1's adjacency list
    public void addEdge(int v1, int v2) {
        adjList[v1].addFirst(v2);
        E++;
    }

    // return number of outgoing edges
    public int outdegree(int v) {
        return adjList[v].size();
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Iterable<Integer> adjacencyList(int vertex) {
        return adjList[vertex];
    }
}
