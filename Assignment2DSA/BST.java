class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BST {
    TreeNode root;

    // Insert method
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Delete method
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private TreeNode deleteRec(TreeNode root, int data) {
        if (root == null) return root;

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else { // Node found
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children → Replace with in-order successor
            TreeNode successor = findMin(root.right);
            root.data = successor.data;
            root.right = deleteRec(root.right, successor.data);
        }
        return root;
    }

    // Find minimum value (used for in-order successor)
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // In-order Traversal (for testing)
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        // Insert elements
        tree.insert(50);
        tree.insert(30);
        // tree.insert(70);
        tree.insert(20);
        // tree.insert(40);
        // tree.insert(60);
        // tree.insert(80);

        System.out.println("Original BST (In-order):");
        tree.inorder();

        // Delete leaf node (20)
        tree.delete(20);
        System.out.println("After deleting leaf node (20):");
        tree.inorder();

        // Delete node with one child (30)
        tree.delete(30);
        System.out.println("After deleting node with one child (30):");
        tree.inorder();

        // Delete node with two children (50)
        tree.delete(50);
        System.out.println("After deleting node with two children (50):");
        tree.inorder();
    }
}
