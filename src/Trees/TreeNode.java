package Trees;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public  TreeNode(int data) {
        this.data = data;
    }

    // this insertion algorithm doesn't handle duplicate values
    public void insert(int val) {
        if(val == data) {
            return;
        }

        if(val < data) {
            // go to the left sub-tree
            if(leftChild == null) {
                // if the left node is null, insert here
                leftChild = new TreeNode(val);
            } else {
                // keep searching for the right spot
                leftChild.insert(val);
            }
        } else { // go to right sub-tree
            if(rightChild == null) {
                rightChild = new TreeNode(val);
            } else {
                rightChild.insert(val);
            }
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
