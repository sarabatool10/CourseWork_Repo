// Node class representing each element in the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Linked list class to handle operations
public class ReverseSinglyLinkedList {

    // Function to reverse the original linked list and return a new reversed linked list
    public static Node reverse(Node head) {
        Node reversedHead = null; // This will be the head of the reversed list

        // Traverse the original list and prepend each node to the reversed list
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.data); // Create a new node with current data
            newNode.next = reversedHead; // Link the new node to the reversed list
            reversedHead = newNode; // Update the head of the reversed list
            current = current.next; // Move to the next node in the original list
        }

        return reversedHead; // Return the head of the reversed list
    }

    // Function to print the elements of a linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Case 1
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);

        System.out.print("Original List 1: ");
        printList(head1);

        Node reversedHead1 = reverse(head1);
        System.out.print("Reversed List 1: ");
        printList(reversedHead1);

        // Test Case 2
        Node head2 = new Node(5);
        head2.next = new Node(10);
        head2.next.next = new Node(15);
        head2.next.next.next = new Node(20);

        System.out.print("\nOriginal List 2: ");
        printList(head2);

        Node reversedHead2 = reverse(head2);
        System.out.print("Reversed List 2: ");
        printList(reversedHead2);

        // Test Case 3
        Node head3 = null;

        System.out.print("\nOriginal List 3 (empty list): ");
        printList(head3);

        Node reversedHead3 = reverse(head3);
        System.out.print("Reversed List 3 (empty list): ");
        printList(reversedHead3);
    }
}
