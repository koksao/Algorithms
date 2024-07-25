import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);

        graph.addEdge(new Edge(node1, node2, 5));
        graph.addEdge(new Edge(node1, node3, 1));
        graph.addEdge(new Edge(node2, node3, 5));
        graph.addEdge(new Edge(node3, node5, 2));
        graph.addEdge(new Edge(node4, node5, 1));
        graph.addEdge(new Edge(node2, node4, 10));
        graph.addEdge(new Edge(node5, node2, 2));
        graph.addEdge(new Edge(node5, node1, 1));

        graph.print();
        Map<String, Integer> dist = graph.dijkstra("C");
        System.out.println(dist);

    }
}