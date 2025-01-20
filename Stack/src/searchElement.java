import java.util.Stack;

class SearchElementInStack {

    // Search an element in a stack and return its position (index)
    public static int searchElement(Stack<Integer> stack, int element) {
        // Temporary stack to hold the elements while searching
        Stack<Integer> tempStack = new Stack<>();
        int index = -1;
        int currentIndex = 0;

        // Iterate through the stack to search for the element
        while (!stack.isEmpty()) {
            int top = stack.pop();
            tempStack.push(top);
            if (top == element) {
                index = currentIndex;
            }
            currentIndex++;
        }

        // Restore the original stack by transferring elements back
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        // Return the index or -1 if element was not found
        return index;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        int element = 30;
        int position = searchElement(stack, element);
        System.out.println("Element " + element + " found at index: " + position); // Output: 2
    }
}
