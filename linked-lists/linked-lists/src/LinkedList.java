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
}
