public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head; // Head of the list
    Node tail; // Tail of the list

    // Add a node to the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Print the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Remove a specified node from the list
    public void removeNode(Node node) {
        if (node == null) {
            System.out.println("The node to be removed is null.");
            return;
        }

        // Case 1: The node is the head
        if (node == head) {
            head = head.next; // Update head
            if (head != null) {
                head.prev = null; // Update the previous pointer of the new head
            } else {
                tail = null; // If the list becomes empty
            }
        }
        // Case 2: The node is the tail
        else if (node == tail) {
            tail = tail.prev; // Update tail
            if (tail != null) {
                tail.next = null; // Update the next pointer of the new tail
            } else {
                head = null; // If the list becomes empty
            }
        }
        // Case 3: The node is in the middle
        else {
            node.prev.next = node.next; // Update the next pointer of the previous node
            node.next.prev = node.prev; // Update the previous pointer of the next node
        }

        System.out.println("Node with value " + node.data + " removed.");
    }

    // Find a node by value (for testing purposes)
    public Node findNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null; // Node not found
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Add elements to the list
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.print("Original List: ");
        list.printList();

        // Remove the head node
        list.removeNode(list.head);
        System.out.print("After removing head: ");
        list.printList();

        // Remove the tail node
        list.removeNode(list.tail);
        System.out.print("After removing tail: ");
        list.printList();

        // Remove a middle node
        Node nodeToRemove = list.findNode(30);
        if (nodeToRemove != null) {
            list.removeNode(nodeToRemove);
        }
        System.out.print("After removing middle node (30): ");
        list.printList();

        // Attempt to remove a non-existent node
        Node nonExistent = list.findNode(100);
        list.removeNode(nonExistent); // Should handle gracefully
    }
}
