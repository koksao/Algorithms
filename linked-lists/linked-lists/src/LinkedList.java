public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public Node mergeLists(LinkedList list) {
        Node list2head = list.head;
        Node list1head = head;
        Node newHead;
        Node temp;

        if (list1head.data <= list2head.data) {
            newHead = list1head;
            list1head = list1head.next;
        } else {
            newHead = list2head;
            list2head = list2head.next;
        }

        temp = newHead;
        while (list1head != null && list2head != null) {
            if (list1head.data <= list2head.data) {
                temp.next = list1head;
                list1head = list1head.next;
                temp = temp.next;
            } else {
                temp.next = list2head;
                list2head = list2head.next;
                temp = temp.next;
            }
        }
        if (list1head != null) temp.next = list1head;
        else {
            temp.next = list2head;
        }
        head = newHead;
        return head;

    }

    public void reverseList() {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void insertNodeAtPosition(Node newNode, int position) {

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        int currentPosition = 0;

        while (temp != null && currentPosition < position - 1) {
            temp = temp.next;
            currentPosition++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteNodeAtPosition(int position) {
        if (head == null) {
            return;
        }
        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            Node next = temp.next.next;
            temp.next = next;
        }
    }

}
