import java.util.Arrays;

class HashMapProbing {
    int size;
    int[] table;

    public HashMapProbing(int size) {
        this.size = size;
        table = new int[size];
        Arrays.fill(table, -1); // -1 represents empty slot
    }

    // Hash function
    private int hash(int key) {
        return key % size;
    }

    // Insert using Linear Probing
    public void insert(int key) {
        int index = hash(key);
        int originalIndex = index;
        int i = 0;

        // Find an empty slot
        while (table[index] != -1) {
            index = (originalIndex + i) % size; // Linear probing
            i++;
            if (i == size) {
                System.out.println("Table is full!");
                return;
            }
        }
        table[index] = key;
    }

    // Display hash table
    public void display() {
        System.out.println("Hash Table: " + Arrays.toString(table));
    }

    public static void main(String[] args) {
        HashMapProbing hashTable = new HashMapProbing(10);

        int[] keys = {10, 22, 31, 4, 15, 28, 17, 88, 59};
        for (int key : keys) {
            hashTable.insert(key);
        }

        hashTable.display();
    }
}
