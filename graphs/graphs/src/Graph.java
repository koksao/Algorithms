import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {

    ArrayList<LinkedList<Node>> lists;
    int[][] matrix;

    Graph(int size) {
        lists = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        lists.add(currentList);
    }

    public void addEdge(int src, int dst) {
        lists.get(src).add(lists.get(dst).get(0));
        matrix[src][dst] = 1;
    }

    public void printList() {
        for (LinkedList<Node> list : lists) {
            for (Node node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    public void printMatrix() {
        System.out.print("  ");
        for (LinkedList<Node> list : lists) {
            System.out.print(list.get(0).data + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(lists.get(i).get(0).data + " ");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
