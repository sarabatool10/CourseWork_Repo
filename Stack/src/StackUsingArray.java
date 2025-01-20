// Node class representing each element in the stack
class Node {
    int data;
    node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class using linked list
class StackUsingLinkedList {
    private node top;

    public StackUsingLinkedList() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int data) {
        node newNode = new node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop an element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack underflow");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    // Peek at the top element of the stack
    public int peek() {
        if (top == null) {
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
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Top element after pop: " + stack.peek()); // Output: 20
    }
}
