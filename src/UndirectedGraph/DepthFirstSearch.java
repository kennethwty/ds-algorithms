package UndirectedGraph;

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
        visited[source] == true;
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
}
