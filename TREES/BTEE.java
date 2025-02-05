import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
        }
}
public class BTEE {
    Node root;
      // Check if the tree is a complete binary tree
    public boolean isComplete(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean encounteredNull = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                encounteredNull = true;
            } else {
                if (encounteredNull) return false; // If a null was encountered earlier, it cannot be complete
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return true;
    }
    //check if the tree is a full binary tree
    public boolean isFull(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
        return false;
        }
        return isFull(root.left) && isFull(root.right); 
    }
     // Function to check the children sum property
    public boolean checkChildrenSumProperty(Node root) {
        // Base case: if the node is null or a leaf node, return true
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int leftData = (root.left != null) ? root.left.data : 0;
        int rightData = (root.right != null) ? root.right.data : 0;

        // Check if the current node satisfies the property
        if (root.data == leftData + rightData) {
            // Recursively check for left and right subtrees
            return checkChildrenSumProperty(root.left) && checkChildrenSumProperty(root.right);
        }

        return false; // Property is violated
    }

    public static void main(String[] args) {
        BTEE tree = new BTEE();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("Is Complete: " + tree.isComplete(tree.root));
        System.out.println("Is Full: " + tree.isFull(tree.root));
        System.out.println("Check Children Sum Property: " + tree.checkChildrenSumProperty(tree.root));
        

    }
    
}
