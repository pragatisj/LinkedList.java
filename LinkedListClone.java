class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        next = null;
        random = null;
    }
}

public class LinkedListClone {
    Node head;

    // Function to clone the given linked list
    public LinkedListClone cloneLinkedList() {
        if (head == null) {
            return null;
        }

        // Step 1: Create a new list and insert cloned nodes
        Node current = head;
        while (current != null) {
            Node cloneNode = new Node(current.data);
            cloneNode.next = current.next;
            current.next = cloneNode;
            current = cloneNode.next;
        }

        // Step 2: Set the random pointers of the cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and cloned lists
        current = head;
        Node clonedHead = head.next;
        Node clonedCurrent = clonedHead;

        while (current != null) {
            current.next = current.next.next;
            current = current.next;

            if (clonedCurrent.next != null) {
                clonedCurrent.next = clonedCurrent.next.next;
                clonedCurrent = clonedCurrent.next;
            }
        }

        return new LinkedListClone(clonedHead);
    }

    // Constructor to create a linked list
    LinkedListClone(Node head) {
        this.head = head;
    }

    // Function to display the linked list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node1;
        node3.random = node5;
        node4.random = node2;
        node5.random = node4;

        LinkedListClone originalList = new LinkedListClone(node1);

        System.out.println("Original Linked List:");
        originalList.display();

        LinkedListClone clonedList = originalList.cloneLinkedList();

        System.out.println("Cloned Linked List:");
        clonedList.display();
    }
}
