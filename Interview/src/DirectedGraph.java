

import java.util.*;

class DGraph {
    private int V; // Number of vertices
    private List<Integer>[] adjList; // Adjacency list

    @SuppressWarnings("unchecked")
    DGraph(int V) {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    List<Integer> findPath(int source, int destination) {
        if (source == destination) {
            // Return a single-element list if source and destination are the same
            List<Integer> path = new ArrayList<>();
            path.add(source);
            return path;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        Map<Integer, Integer> parentMap = new HashMap<>();
        parentMap.put(source, -1); // Using -1 to represent that the source has no parent

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                // Found the destination, construct the path
                return constructPath(parentMap, source, destination);
            }

            for (int neighbor : adjList[current]) {
                if (!parentMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        // No path found
        return new ArrayList<>();
    }

    private List<Integer> constructPath(Map<Integer, Integer> parentMap, int source, int destination) {
        List<Integer> path = new ArrayList<>();
        int current = destination;
        while (current != -1) { // Check for the special value -1 representing no parent
            path.add(0, current);
            current = parentMap.get(current);
        }
        return path;
    }
}

public class DirectedGraph {
    public static void main(String[] args) {
        int V = 7; // Number of vertices
        DGraph graph = new DGraph(V);

        // Adding edges to the graph (Directed edges)
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        int source = 0;
        int destination = 6;

        List<Integer> path = graph.findPath(source, destination);

        if (!path.isEmpty()) {
            System.out.println("Path from " + source + " to " + destination + ": " + path);
        } else {
            System.out.println("No path found from " + source + " to " + destination);
        }
    }
}

