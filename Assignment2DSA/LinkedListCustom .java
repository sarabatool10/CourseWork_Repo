class Node {
    String value;
    Node next;

    Node(String v) {
        this.value = v;
        this.next = null;
    }
}

// LinkedList implementation
class LinkedListCustom {
    Node head;

    public void append(String value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }

    public int search(String value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Not found
    }
}

// HashTable with Chaining
class HashTable {
    private LinkedListCustom[] table;

    public HashTable() {
        table = new LinkedListCustom[10000]; // Fixed size table
    }

    private int calculateHashValue(String str) {
        return (str.charAt(0) * 100 + str.charAt(1)) % table.length;
    }

    public void store(String str) {
        int hashCode = calculateHashValue(str);
        if (table[hashCode] == null) {
            table[hashCode] = new LinkedListCustom();
        }
        table[hashCode].append(str);
    }

    public int lookup(String str) {
        int hashCode = calculateHashValue(str);
        if (table[hashCode] != null) {
            return table[hashCode].search(str);
        }
        return -1;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        // Test hash calculation
        System.out.println(hashTable.calculateHashValue("SAAD")); // Should be 8568

        // Test lookup (not found)
        System.out.println(hashTable.lookup("SAAD")); // Should be -1

        // Test store
        hashTable.store("SAAD");
        System.out.println(hashTable.lookup("SAAD")); // Should be 1

        // Test collision handling
        System.out.println(hashTable.calculateHashValue("SAMP")); // Same hash as "SAAD"
        hashTable.store("SAMP");
        System.out.println(hashTable.lookup("SAMP")); // Should be 2
    }
}
