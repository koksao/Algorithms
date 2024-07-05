public class Main {
    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.insert(6);
        list1.insert(7);
        list1.insert(7);
        list1.insert(9);
        list1.insert(12);

        list2.insert(3);
        list2.insert(3);
        list2.insert(5);
        list2.insert(15);
        list2.insert(19);

        list1.printList();
        System.out.println();
        list2.printList();
        System.out.println();
        list1.insertNodeAtPosition(new Node(1), 4);
        System.out.println();
        list1.printList();
        list1.deleteNodeAtPosition(2);
        System.out.println();
        list1.printList();
    }

}