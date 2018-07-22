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

    // get data by returning a node
    public TreeNode get(int target) {
        if(data == target) {
            return this;
        }

        // check the left sub-tree
        if(target < data && leftChild != null) {
            return leftChild.get(target);
        } else if(target > data && rightChild != null) {
            return rightChild.get(target);
        }

        // target value not found
        return null;
    }

    public int getMin() {
        // if the left sub-tree of the calling node is null, then itself is the min
        if(leftChild == null) {
            return data;
        } else {
            return leftChild.getMin();
        }
    }

    public int getMax() {
        // if the right sub-tree of the calling node is null, then itself is the min
        if(rightChild == null) {
            return data;
        } else {
            return rightChild.getMax();
        }
    }

    // in-order tree traversal
    public void traverse() {
        // traverse the left sub-tree
        if(leftChild != null) {
            leftChild.traverse();
        }
        // print the root at the level
        System.out.print(data + " ");

        // traverse the right sub-tree
        if(rightChild != null) {
            rightChild.traverse();
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

    public String toString() {
        return "Data: " + data;
    }
}
