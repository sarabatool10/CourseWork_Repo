// Node class representing each element in the stack
class node {
    int data;
    node next;

    public node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class using linked list
 class StackusingLinkedList {
    private node top;

    public StackusingLinkedList() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int data) {
        node newNode = new node(data);
        newNode.next = top; // Link new node to the current top
        top = newNode;      // Update the top to the new node
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) { // Use isEmpty() for better readability
            System.out.println("Stack underflow");
            return -1;
        }
        int value = top.data;
        top = top.next; // Move top to the next node
        return value;
    }

    // Peek at the top element of the stack
    public int peek() {
        if (isEmpty()) { // Use isEmpty() for better readability
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        StackusingLinkedList stack = new StackusingLinkedList();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display top element
        System.out.println("Top element: " + stack.peek()); // Output: 30

        // Pop an element and display it
        System.out.println("Popped element: " + stack.pop()); // Output: 30

        // Display top element after pop
        System.out.println("Top element after pop: " + stack.peek()); // Output: 20

        // Pop all elements
        stack.pop(); // Pop 20
        stack.pop(); // Pop 10

        // Attempt to pop from empty stack
        System.out.println("Popped element from empty stack: " + stack.pop()); // Output: Stack underflow
    }
}
