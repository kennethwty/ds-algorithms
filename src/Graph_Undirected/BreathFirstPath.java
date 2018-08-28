package Graph_Undirected;

import LinkedList_Stack_Queue.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/* using the BFS to find a paths from source in a graph */
public class BreathFirstPath {
    private boolean[] visited;
    private int[] fromVertex;
    private final int source;

    public BreathFirstPath(Graph g, int source) {
        this.source = source;
        visited = new boolean[g.getV()];
        fromVertex = new int[g.getV()];
        search(g, source);
    }

    // BFS
    public void search(Graph g, int s) {
        // using a queue to keep track of unprocessed vertices
        // once the vertex is processed, dequeue from queue
        Queue<Integer> queue = new Queue<>();
        visited[s] = true; // mark the vertex as visited
        queue.enqueue(s);
        while(queue.isEmpty() == false) {
            // while there is a vertex left in the queue, dequeue and mark as visited
            int v = queue.dequeue();
            // add all the neighbors of s to the queue
            for(int neighbor : g.adjacencyList(v)) {
                if(!visited[neighbor]) {
                    fromVertex[neighbor] = v;
                    visited[neighbor] = true;
                    queue.enqueue(neighbor);
                }
            }
        }
    }

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
        BreathFirstPath path = new BreathFirstPath(undirectedGraph, source);

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
