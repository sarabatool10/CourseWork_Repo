import java.util.ArrayList;

class hashTable {
    private ArrayList<String>[] table;

    // Constructor: Create an array of lists
    public hashTable() {
        table = new ArrayList[9000]; // ASCII values 6500 to 9090 possible
        for (int i = 0; i < 9000; i++) {
            table[i] = new ArrayList<>(); // Initialize each bucket as a list
        }
    }

    // Hash Function: (ASCII of First Letter * 100) + ASCII of Second Letter
    private int calculateHashValue(String word) {
        if (word.length() < 2) return -1; // Ensure word has at least 2 characters
        int hashValue = (word.charAt(0) * 100) + word.charAt(1);
        return hashValue;
    }

    // Store Function: Adds the word to the calculated bucket
    public void store(String word) {
        int index = calculateHashValue(word);
        if (!table[index].contains(word)) { // Avoid duplicates
            table[index].add(word);
        }
    }

    // Lookup Function: Returns hash value if found, else -1
    public int lookup(String word) {
        int index = calculateHashValue(word);
        return table[index].contains(word) ? index : -1;
    }

    // Display Function: Prints all stored words
    public void display() {
        System.out.println("Hash Table Contents:");
        for (int i = 6500; i < 9090; i++) { // Check only valid range
            if (!table[i].isEmpty()) {
                System.out.println("Index " + i + ": " + table[i]);
            }
        }
    }

    public static void main(String[] args) {
        hashTable hashTable = new hashTable();

        // Storing words
        hashTable.store("UDOMETER");
        hashTable.store("HELLO");
        hashTable.store("WORLD");
        hashTable.store("APPLE");

        hashTable.display();

        // Looking up words
        System.out.println("\nLookup 'UDOMETER': " + hashTable.lookup("UDOMETER")); // 8568
        System.out.println("Lookup 'HELLO': " + hashTable.lookup("HELLO")); // 7285
        System.out.println("Lookup 'JAVA': " + hashTable.lookup("JAVA")); // -1 (Not stored)
    }
}
