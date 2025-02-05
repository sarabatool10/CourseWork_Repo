import java.util.LinkedList;

class HashMapChaining {
    private static class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMapChaining(int capacity) {
        this.size = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size; // Simple Modulo Hash Function
    }

    public void put(int key, int value) {
        int index = hash(key);
        for (Node node : table[index]) {
            if (node.key == key) {
                node.value = value; // Update if key exists
                return;
            }
        }
        table[index].add(new Node(key, value)); // Add new node
    }

    public Integer get(int key) {
        int index = hash(key);
        for (Node node : table[index]) {
            if (node.key == key) {
                return node.value; // Key found, return value
            }
        }
        return null; // Key not found
    }

    public boolean remove(int key) {
        int index = hash(key);
        for (Node node : table[index]) {
            if (node.key == key) {
                table[index].remove(node);
                return true;
            }
        }
        return false; // Key not found
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Node node : table[i]) {
                System.out.print("[" + node.key + " -> " + node.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashMapChaining map = new HashMapChaining(5);
        map.put(10, 100);
        map.put(15, 200);
        map.put(20, 300);
        map.put(25, 400); // These all collide at index (key % 5)
        map.display();

        System.out.println("Search 15: " + map.get(15)); // Output: 200
        System.out.println("Removing 15: " + map.remove(15));
        map.display();
    }
}
