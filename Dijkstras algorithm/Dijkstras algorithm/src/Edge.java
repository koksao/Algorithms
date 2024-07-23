public class Edge {
    Node startNode;
    Node endNode;
    int weight;

    public Edge(Node startnode, Node endnode, int weight) {
        this.startNode = startnode;
        this.endNode = endnode;
        this.weight = weight;
    }
}
