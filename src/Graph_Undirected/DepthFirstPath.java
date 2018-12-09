package Graph_Undirected;

import Stack_Queue.LinkedList_Stack_Queue.Stack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/* Depth-First Search to find paths in a graph */
public class DepthFirstPath {
    private boolean[] visited;
    private int[] fromVertex; // previous vertex to this vertex
    private final int source; // find a find from s to vertex v

    public DepthFirstPath(Graph graph, int source) {
        this.source = source;
        visited = new boolean[graph.getV()];
        fromVertex = new int[graph.getV()];
        search(graph, source);
    }

    // similar to the dfs method in DepthFirstSearch.java
    // mark visited vertices and record the current vertex as next vertex's previous node
    public void search(Graph g, int v) {
        visited[v] = true;
        for(int neighbor : g.adjacencyList(v)) {
            if(!visited[neighbor]) {
                // record and search
                fromVertex[neighbor] = v;
                search(g, neighbor);
            }
        }
    }

    // if there is a path to v from source vertex, then it must have been marked as visited
    public boolean hasPath(int v) {
        return visited[v];
    }

    public Iterable<Integer> path(int v) {
        if(hasPath(v) == false) return null;
        // use a stack to push all the vertices on that path in to and return the stack
        Stack<Integer> path = new Stack<>();
        for(int i = v; i != source; i = fromVertex[i]) {
            path.push(i);
        }
        // it is the source, push the source vertex into the stack and then return
        path.push(source);
        return path;
    }

    public static void main(String[] args) throws IOException {
        // for user input
        Scanner keyboard = new Scanner(System.in);
        // read the file and create a Graph object
        Scanner scanner = new Scanner(new File("src/Graph_Undirected/test2.txt"));
        Graph undirectedGraph = new Graph(scanner);
        System.out.print(undirectedGraph.toString());

        // traversal from source entered by user, pass it the DepthFirstPath class
        System.out.println();
        System.out.print("Please enter a source: ");
        int source = keyboard.nextInt();
        DepthFirstPath path = new DepthFirstPath(undirectedGraph, source);

        System.out.print("Please enter a vertex to find the path from " + source + ": ");
        int target = keyboard.nextInt();
        for(int v : path.path(target)) {
            if(v == source) {
                System.out.print(v);
            } else {
                System.out.print("-" + v);
            }
        }
    }
}
