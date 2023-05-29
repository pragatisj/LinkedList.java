class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class SizeOfLoopInLl {
    Node head;

    // Function to detect and find the size of a loop in a linked list
    int detectLoopSize() {
        Node slow = head;
        Node fast = head;
        boolean loopExists = false;

        // Detect the loop using the Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        // If loop exists, find the size of the loop
        if (loopExists) {
            int size = 1;
            slow = slow.next;

            while (slow != fast) {
                slow = slow.next;
                size++;
            }

            return size;
        }

        return 0; // No loop found
    }

    public static void main(String[] args) {
        SizeOfLoopInLl list = new SizeOfLoopInLl();

        // Creating a linked list with a loop
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = list.head.next; // Creating a loop

        int loopSize = list.detectLoopSize();
        System.out.println("Size of the loop: " + loopSize);
    }
}
