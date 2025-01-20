class QueueArray {
    private int front, rear, capacity;
    private int[] queue;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        front = rear = 0;
        queue = new int[capacity];
    }

    public void enqueue(int data) {
        if (capacity == rear) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear] = data;
        rear++;
    }

    public void dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
    }

    public void display() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public int front() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }
}

public class Main {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // This should print "Queue is full"

        System.out.print("Queue after enqueuing: ");
        queue.display();

        queue.dequeue();
        queue.dequeue();

        System.out.print("Queue after dequeuing two elements: ");
        queue.display();

        System.out.println("Front element of the queue: " + queue.front());
    }
}
