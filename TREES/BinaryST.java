class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinaryST {
    Node root;
    public boolean search(Node root, int key) {
        while(root != null) {
            if(root.data == key) {
                return true;
                }
                else if(root.data > key) {
                    root = root.left;
                    }
                    else {
                        root = root.right;
                        }
                        }
                        return false;

    }
    public static void main(String[] args) {
        BinaryST bst = new BinaryST();
        bst.root = new Node(50);
        bst.root.left = new Node(30);
        bst.root.right = new Node(70);
        bst.root.left.left = new Node(20);
        bst.root.left.right = new Node(40);
        System.out.println(bst.search(bst.root, 60));
        
    }
}
