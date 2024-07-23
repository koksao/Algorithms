import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Node, List<Edge>> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.put(node, new ArrayList<>());
    }

    public void addEdge(Edge edge) {
        nodes.get(edge.startNode).add(edge);
    }

    public void print() {
        for (Map.Entry<Node, List<Edge>> entry : nodes.entrySet()) {
            Node temp = entry.getKey();
            List<Edge> edges = entry.getValue();

            System.out.println();
            for (Edge edge : edges) {
                System.out.print(temp.data + " " + "-> " + edge.endNode.data + " " + edge.weight + "| ");
            }
        }

    }


}

