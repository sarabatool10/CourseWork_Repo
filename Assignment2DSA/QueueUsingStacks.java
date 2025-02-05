import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (efficient)
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation
    public Integer dequeue() {
        transferStacks();
        if (stack2.isEmpty()) {
            return null;
        } else {
            return stack2.pop();
        }
    }

    // Peek operation
    public Integer peek() {
        transferStacks();
        if (stack2.isEmpty()) {
            return null;
        } else {
            return stack2.peek();
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Transfer elements from stack1 to stack2
    private void transferStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("First element dequeued: " + queue.dequeue()); // Output: 1
        System.out.println("Next element to be dequeued: " + queue.peek()); // Output: 2
        System.out.println("Second element dequeued: " + queue.dequeue()); // Output: 2
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: false
        System.out.println("Third element dequeued: " + queue.dequeue()); // Output: 3
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: true
    }
}
