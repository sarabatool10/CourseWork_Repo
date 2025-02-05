import java.util.Arrays;

class BinaryTreeArray {
    int[] tree;  // Array to store tree nodes
    int size;    // Current number of elements

    // Constructor to initialize array
    public BinaryTreeArray(int capacity) {
        tree = new int[capacity]; // Initialize array
        Arrays.fill(tree, -1);    // Fill with -1 (empty)
        size = 0;
    }

    // Insert a node in level order
    public void insert(int value) {
        if (size >= tree.length) {
            System.out.println("Tree is full!");
            return;
        }
        tree[size] = value; // Insert at next position
        size++;
    }

    // Print tree as array
    public void printTree() {
        int[] result = new int[size]; // Create a new array with only used elements
        for (int i = 0; i < size; i++) {
            result[i] = tree[i];
        }
        System.out.println("Tree: " + Arrays.toString(result));
    }

    public static void main(String[] args) {
        BinaryTreeArray tree = new BinaryTreeArray(10);

        // Insert elements
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        // Print tree
        tree.printTree();
    }
}
