import java.util.LinkedList;

class HashMap<K, V> {
    private static final int SIZE = 10; // Table size
    private LinkedList<Entry<K, V>>[] table; // Array of linked lists

    boolean containsKey(String indonesia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Entry class for key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public HashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insert key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
    }

    // Search function
    public V search(K key) {
        int index = hash(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value; // Return value if found
            }
        }
        return null; // Key not found
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);

        System.out.println(map.search("Alice")); // Output: 25
        System.out.println(map.search("Bob"));   // Output: 30
        System.out.println(map.search("Charlie")); // Output: null
    }
}
