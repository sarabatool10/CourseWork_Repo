class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (this.rear == null) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
    }

    public int dequeue() {
        if (this.front == null) return -1;
        int value = this.front.data;
        this.front = this.front.next;
        if (this.front == null) this.rear = null;
        return value;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public int peek() {
        return (this.front != null) ? this.front.data : -1;
    }

    public int getMinimum() {
        if (this.front == null) return -1;
        int min = this.front.data;
        for (Node current = this.front; current != null; current = current.next) {
            if (current.data < min) min = current.data;
        }
        return min;
    }

    public void reverseFirstK(int k) {
        if (k <= 0 || this.isEmpty()) return;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < k && !this.isEmpty(); i++) {
            stack.push(this.dequeue());
        }
        while (!stack.isEmpty()) {
            this.enqueue(stack.pop());
        }
        int remaining = size() - k;
        for (int i = 0; i < remaining; i++) {
            this.enqueue(this.dequeue());
        }
    }

    public int size() {
        int count = 0;
        for (Node current = this.front; current != null; current = current.next) {
            count++;
        }
        return count;
    }
}

public class QueueOperations {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.reverseFirstK(3);

        System.out.print("Queue after reversing first 3 elements: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        queue.enqueue(7);
        queue.enqueue(3);
        queue.enqueue(10);

        System.out.println("Minimum element in the queue: " + queue.getMinimum());
    }
}
