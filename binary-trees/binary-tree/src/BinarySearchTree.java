import static java.lang.Math.max;

public class BinarySearchTree {
    Node root;

    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;
        if (root == null) {
            root = node;
            return root;
        } else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void inorderTraversal() {
        inorderHelper(root);
    }

    private void inorderHelper(Node root) {
        if (root != null) {
            inorderHelper(root.left);
            System.out.println(root.data);
            inorderHelper(root.right);
        }
    }

    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preorderHelper(root.left);
            preorderHelper(root.right);
        }
    }

    public void postorderTraversal() {
        postorderHelper(root);
    }

    private void postorderHelper(Node root) {
        if (root != null) {
            postorderHelper(root.left);
            postorderHelper(root.right);
            System.out.println(root.data);
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (root.data > data) {
            return searchHelper(root.left, data);
        } else {
            return searchHelper(root.right, data);
        }
    }

    public void deleteNode(int data) {
        root = deleteHelper(root, data);
    }

    private Node deleteHelper(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleteHelper(root.left, data);
        } else if (data > root.data) {
            root.right = deleteHelper(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteHelper(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public int maxDepth() {
        return maxDepthHelper(root);
    }

    private int maxDepthHelper(Node node) {
        if (node == null) {
            return -1;
        } else {
            int lDepth = maxDepthHelper(node.left);
            int rDepth = maxDepthHelper(node.right);

            return max(lDepth, rDepth) + 1;
        }
    }

    public int getNodeLevel(int data) {
        return getNodeLevelHelper(data, root, 0);
    }

    private int getNodeLevelHelper(int data, Node node, int level) {
        if (node == null) {
            return -1;
        }
        if (node.data == data) {
            return level;
        }

        int leftLvl = getNodeLevelHelper(data, node.left, level + 1);
        if (leftLvl != -1) {
            return leftLvl;
        }

        return getNodeLevelHelper(data, node.right, level + 1);
    }
}
