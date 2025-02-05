public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    // Insert a node into the BST
    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Inorder traversal of the BST
    public static void inorder(Node root) {
        if (root == null) {
            return; // Correct condition to terminate recursion
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root==null){
            return false;
            }
        if(root.data > key){
            return search(root.left,key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return search(root.right,key);
        }
    }

    public static void main(String[] args) {
        int data[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        // Build the BST
        for (int i = 0; i < data.length; i++) {
            root = insert(root, data[i]);
        }

        // Perform inorder traversal
        inorder(root);
        System.out.println();
        if(search(root, 7 )){
            System.out.println("Element found");
        }
        else{
            System.out.println("Element not found");
        }
    }
}
