class QueueUsingLinkedList {
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head, tail;
    private int count;

    public QueueUsingLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.count++;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        this.count--;
        return temp.data;
    }

    public void print() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int size() {
        return this.count;
    }
}

class QueueUsingArray {
    private int[] array;
    private int startIndex, endIndex;

    public QueueUsingArray(int length) {
        this.array = new int[length];
        this.startIndex = -1;
        this.endIndex = -1;
    }

    public boolean isEmpty() {
        return this.startIndex == -1 && this.endIndex == -1;
    }

    public boolean isFull() {
        return this.startIndex == (this.endIndex + 1) % this.array.length;
    }

    public void enqueue(int value) {
        if (this.isFull()) {
            System.out.println("Array is full");
            return;
        }
        if (this.isEmpty()) {
            this.startIndex = 0;
        }
        this.endIndex = (this.endIndex + 1) % this.array.length;
        this.array[this.endIndex] = value;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            System.out.println("Array is empty");
            return -1;
        }
        int result = this.array[this.startIndex];
        if (this.startIndex == this.endIndex) {
            this.startIndex = -1;
            this.endIndex = -1;
        } else {
            this.startIndex = (this.startIndex + 1) % this.array.length;
        }
        return result;
    }

    public void print() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = this.startIndex;
        while (true) {
            System.out.print(this.array[i] + " ");
            if (i == this.endIndex) {
                break;
            }
            i = (i + 1) % this.array.length;
        }
        System.out.println();
    }
}

public class QueueDemo {
    public static void main(String[] args) {

        QueueUsingLinkedList queueLL = new QueueUsingLinkedList();
        queueLL.enqueue(1);
        queueLL.enqueue(2);
        queueLL.enqueue(3);
        queueLL.enqueue(4);
        System.out.println("Count: " + queueLL.size());
        queueLL.print();
        System.out.println(queueLL.dequeue());
        System.out.println(queueLL.dequeue());
        queueLL.print();


    }
}
