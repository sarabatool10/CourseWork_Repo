class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head;

    // Method to make the list circular
    public void makeCircular(int position) {
        if (head == null || position < 0) return;

        Node current = head;
        Node target = null;
        int count = 0;

        // Traverse the list to find the target node and the last node
        while (current.next != null) {
            if (count == position) {
                target = current;
            }
            current = current.next;
            count++;
        }

        // Connect the last node to the target node
        if (target != null) {
            current.next = target;
        } else {
            System.out.println("Position out of bounds");
        }
    }

    // Detects if a cycle is present
    public boolean isCircular() {
        if (head == null) return false;
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Utility method to add a node to the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Utility method to print the list safely
    public void printList() {
        if (head == null) return;

        Node current = head;
        Node slow = head, fast = head;
        boolean loopDetected = false;

        while (current != null) {
            System.out.print(current.data + " -> ");
            
            // Move slow one step, fast two steps
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // If slow meets fast, cycle detected
            if (slow == fast && fast != head) {
                loopDetected = true;
                break;
            }

            current = current.next;
        }

        if (loopDetected) {
            System.out.print("(loop detected, stopping print)");
        } else {
            System.out.print("null");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Original list:");
        list.printList();

        list.makeCircular(2); // Making the list circular at position 2

        System.out.println("Circular list:");
        list.printList(); // No infinite loop
    }
}
