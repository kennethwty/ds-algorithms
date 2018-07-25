package Heap;

// This is a Max Heap where parent nodes are equal to or greater than its children nodes
// This implementation is backed by an array
public class Heap {
    private int[] heap;
    int size;

    public Heap(int heapSize) {
        heap = new int[heapSize];
    }

    // insert a new node to the end, and then heapify the structure above
    public void insert(int input) {
        // first check if the heap is full
        if(isFull()) {
            throw new IndexOutOfBoundsException("The heap capacity is full");
        }
        // insert to the end
        heap[size] = input;
        heapifyAbove(size);
        size++;
    }

    // replace the deleted value with the rightmost node in the last tree level, then heapify
    public void delete(int targetIndex) {

    }

    // index is the current index of the new node
    public void heapifyAbove(int index) {
        // store the new node value to a temp variable
        int temp = heap[index];
        // while it is not the root and while the child value is great than its parent value
        while(index > 0 && temp > heap[getParentIndex(index)]) {
            // copy the parent value first, swap at the very end after it located a spot
            heap[index] = heap[getParentIndex(index)];
            index = getParentIndex(index);
        }
        // once it located the spot, could be the root
        heap[index] = temp;
    }

    public void heapifyBelow(int index) {

    }

    // gets the parent index of a child node
    public int getParentIndex(int childIndex) {
        // find the parent node index using the formula: floor((i-1)/2)
        // however, since it is integer division, there is no need for floor function
        return (childIndex - 1) / 2;
    }

    public int getChildIndex(int parentIndex, boolean left) {
        return 2 * parentIndex + (left ? 1 : 2);
    }

    // checks whether the heap is full
    public boolean isFull() {
        return size == heap.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
