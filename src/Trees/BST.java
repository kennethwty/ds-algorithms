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

    public TreeNode get(int target) {
        if(root == null) {
            return null;
        } else {
            return root.get(target);
        }
    }

    public int getMin() {
        if(root != null) {
            return root.getMin();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int getMax() {
        if(root != null) {
            return root.getMax();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void traverse() {
        if(root == null) {
            return;
        } else {
            root.traverse();
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
        tree.insert(65); // should be omitted
        tree.insert(105);

        tree.traverse();

        System.out.println();
        System.out.println(tree.get(105));

        System.out.println("Minimum: " + tree.getMin());
        System.out.print("Maximum: " + tree.getMax());
    }
}
