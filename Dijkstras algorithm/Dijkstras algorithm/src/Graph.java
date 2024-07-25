import java.util.*;

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

            for (Edge edge : edges) {
                System.out.print(temp.data + " " + "-> " + edge.endNode.data + " " + edge.weight + "| ");
            }
            System.out.println();
        }

    }

    public Map<String, Integer> dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        for (Node node : nodes.keySet()) {
            distances.put(node.data, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            String currentNode = priorityQueue.poll();
            for (Map.Entry<Node, List<Edge>> entry : nodes.entrySet()) {
                Node temp = entry.getKey();

                if (temp.data.equals(currentNode)) {
                    for (Edge neighborEdge : nodes.get(temp)) {
                        String neighbor = neighborEdge.endNode.data;
                        int newDistance = distances.get(currentNode) + neighborEdge.weight;

                        if (newDistance < distances.get(neighbor)) {
                            distances.put(neighbor, newDistance);
                            priorityQueue.add(neighbor);
                        }
                    }

                }
            }
        }
        return distances;
    }


}

