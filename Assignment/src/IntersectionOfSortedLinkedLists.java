// Node class representing each element in the linked list
class node {
    int data;
    node next;

    public node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Main class for the solution
public class IntersectionOfSortedLinkedLists {

    // Function to find the intersection of two sorted linked lists
    public static Node findIntersection(Node list1, Node list2) {
        Node dummy = new Node(0); // Dummy node for the intersection list
        Node tail = dummy;       // Tail pointer for the intersection list

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.data == list2.data) {
                tail.next = new Node(list1.data); // Add common element to the intersection list
                tail = tail.next;                // Move the tail pointer
                list1 = list1.next;              // Move both pointers forward
                list2 = list2.next;
            } else if (list1.data < list2.data) {
                list1 = list1.next;              // Move the pointer in the first list
            } else {
                list2 = list2.next;              // Move the pointer in the second list
            }
        }

        return dummy.next; // Return the head of the intersection list
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
        Node list1 = new Node(10);
        list1.next = new Node(20);
        list1.next.next = new Node(30);

        Node list2 = new Node(15);
        list2.next = new Node(20);
        list2.next.next = new Node(25);
        list2.next.next.next = new Node(30);

        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);

        Node intersection1 = findIntersection(list1, list2);
        System.out.print("Intersection List: ");
        printList(intersection1);

        // Test Case 2
        Node list3 = new Node(5);
        list3.next = new Node(10);
        list3.next.next = new Node(15);

        Node list4 = new Node(1);
        list4.next = new Node(2);
        list4.next.next = new Node(3);

        System.out.print("\nList 3: ");
        printList(list3);
        System.out.print("List 4: ");
        printList(list4);

        Node intersection2 = findIntersection(list3, list4);
        System.out.print("Intersection List: ");
        printList(intersection2);
    }
}
