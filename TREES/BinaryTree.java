class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
}
}
public class BinaryTree {
    Node root;
    public int calculateLevel(Node root){
        if(root == null){
            return 0;
            }
            int leftHeight = calculateLevel(root.left);
            int rightHeight = calculateLevel(root.right);
            return Math.max(leftHeight, rightHeight)+1;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Height of tree is "+ tree.calculateLevel(tree.root));

    }

    
}
