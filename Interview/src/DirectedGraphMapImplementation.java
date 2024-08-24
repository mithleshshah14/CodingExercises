import java.util.*;

public class DirectedGraphMapImplementation {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B","C"));
        graph.put("B",Arrays.asList("C","D"));
        graph.put("C",Arrays.asList("D"));
        graph.put("D",Arrays.asList("E"));
        graph.put("E",Arrays.asList("E"));

        getDirectedgraph(graph, "A", "E");
    }


    public static void getDirectedgraph(Map<String, List<String>> graph, String start, String  end) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> links = new HashMap<>();
        List<String> path = new ArrayList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String curr = queue.remove();

            if(curr.equals(end)) {
              //  path.add(curr);
                while(!curr.equals(start)) {
                    path.add(curr);
                    curr = links.get(curr);
                }
                path.add(curr);
            }

            for(String val : graph.get(curr)) {
                if(visited.add(val)) {
                    queue.add(val);
                    links.put(val, curr);
                }
            }

        }
        Collections.reverse(path);
        path.stream().forEach(System.out::println);
    }



    class Node {
        String name;
        LinkedList<String> adjacent;

        Node(String name) {
            this.name = name;
            adjacent = new LinkedList<>();
        }
    }

    public void createNodes() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.adjacent.add("B");
        nodeA.adjacent.add("C");
        nodeB.adjacent.add("C");
        nodeB.adjacent.add("D");
        nodeC.adjacent.add("D");
        nodeD.adjacent.add("E");

        return;

    }

}
