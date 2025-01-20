import java.util.Stack;

class PeekStack {

    // Peek method to return but not remove the top of the stack
    public static int peek(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Indicate an empty stack
        }
        return stack.peek(); // Return the top element without removing it
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element (peek): " + peek(stack)); // Output: 30
    }
}
