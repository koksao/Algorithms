import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    ArrayList<LinkedList<Node>> lists;

    Graph() {
        lists = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        lists.add(currentList);
    }

    public void addEdge(int src, int dst) {
        lists.get(src).add(lists.get(dst).get(0));
    }

    public void print() {
        for (LinkedList<Node> list : lists) {
            for (Node node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }
}
