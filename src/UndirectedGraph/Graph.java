package UndirectedGraph;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

// Undirected Graph API
public class Graph {
    private final int V; // number of vertices
    private int E; // number of edges
    private LinkedList<Integer>[] adjList; // adjacency list backed by a linked list (could use a Bag ADT)

    public Graph(int V) {
        // initializing the field and create empty lists for each vertex
        this.V = V;
        this.E = 0;
        adjList = (LinkedList<Integer>[]) new LinkedList[V];
        for(int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    // this constructor takes a file as input
    // the first element is the number of vertices
    // the second element is the number of edges
    // following that is a list of pairs of edges
    public Graph(DataInputStream input) throws IOException {
        this(input.readInt());
        int edges = input.readInt();
        for(int i = 0; i < edges; i++) {
            // input vertices will be in the format of v1 v2
            // starting from 0 to V-1
            int v1 = input.readInt();
            int v2 = input.readInt();
            // add the edge to the list
            addEdge(v1, v2);
        }
    }

    // add v2 to v1's adjacency list
    // add v1 to v2's adjacency list
    public void addEdge(int v1, int v2) {
        adjList[v1].addFirst(v2);
        adjList[v2].addFirst(v1);
        E++;
    }

    // compute the degree of a vertex
    public int calcDegree(int vertex) {
        return adjList[vertex].size();
    }

    // find the maximum degree
    public int maxDegree() {
        int max = 0;
        for(int i = 0; i < V; i++) {
            if(calcDegree(i) > 0)
                max = calcDegree(i);
        }
        return max;
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

    public String toString() {
        String str = V + " vertices, " + E + "edges.\n";
        for(int i = 0; i < V; i++) {
            str = str + i + ": ";
            for(int v2 : this.adjacencyList(i)) {
                str = str + v2 + " ";
            }
            str = str + "\n";
        }
        return str;
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fstream = new FileInputStream(args[0]);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        Graph undirectedGraph = new Graph(in);
        System.out.println(undirectedGraph.toString());
    }
}
