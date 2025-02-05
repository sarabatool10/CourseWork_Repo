class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    // Recursive method to find height of a node
    public int findHeight(TreeNode node) {
        if (node == null) return -1; // Base case: empty tree or end of branch

        int leftHeight = findHeight(node.left);   // Height of left subtree
        int rightHeight = findHeight(node.right); // Height of right subtree

        return 1 + Math.max(leftHeight, rightHeight); // Max of left & right subtree heights
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Constructing the tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        tree.root.left.left.left = new TreeNode(7);

        // Find height of the root node (entire tree height)
        System.out.println("Height of the tree: " + tree.findHeight(tree.root)); // Output: 3

        // Find height of node with value 2
        System.out.println("Height of node 2: " + tree.findHeight(tree.root.left)); // Output: 2
    }
}
