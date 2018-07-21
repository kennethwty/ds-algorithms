package Trees;

public class BST {
    private TreeNode root;

    public void insert(int data) {
        if(root == null) {
            root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(35);
        tree.insert(25);
        tree.insert(15);
        tree.insert(55);
        tree.insert(85);
        tree.insert(75);
        tree.insert(95);
        tree.insert(5);
        tree.insert(65);
        tree.insert(65);
        tree.insert(105);
    }
}
