import java.util.LinkedList;
import java.util.Queue;

public class StackQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int size;

    public StackQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        size = 0;
    }

    // Push operation (efficient)
    public void push(int x) {
        queue1.add(x);
        size++;
    }

    // Pop operation
    public Integer pop() {
        if (isEmpty()) {
            return null; // Return null if stack is empty
        }
        
        // Transfer elements from queue1 to queue2, leaving the last element
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        // The last element in queue1 is the top of the stack
        int topElement = queue1.remove();
        size--;
        
        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return topElement;
    }

    // Peek operation
    public int top() {
        // Transfer elements from queue1 to queue2, leaving the last element
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        // The last element in queue1 is the top of the stack
        int topElement = queue1.remove();
        queue2.add(topElement);
        
        // Swap the references of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Size operation
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Current size: " + stack.size()); // Output: 3
        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Popped element: " + stack.pop()); // Output: 3
        System.out.println("Current size: " + stack.size()); // Output: 2
        System.out.println("Top element: " + stack.top()); // Output: 2
        System.out.println("Popped element: " + stack.pop()); // Output: 2
        System.out.println("Current size: " + stack.size()); // Output: 1
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
        System.out.println("Popped element: " + stack.pop()); // Output: 1
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
        System.out.println("Popped element: " + stack.pop()); // Output: null
    }
}
