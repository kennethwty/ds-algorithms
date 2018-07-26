package Heap;

import java.util.Arrays;

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
    public int delete(int targetIndex) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("The heap is empty");
        }
        int parentIndex = getParentIndex(targetIndex);
        int deletedValue = heap[targetIndex];
        // replace with the rightmost element
        heap[targetIndex] = heap[size - 1];
        // if it is the root node that we are deleting or its parent node is greater, then heapify below
        if(targetIndex == 0 || heap[targetIndex] < heap[parentIndex]) {
            heapifyBelow(targetIndex, size - 1);
        } else {
            // heapify above
            heapifyAbove(targetIndex);
        }
        heap[size - 1] = 0;
        size--;
        return deletedValue;
    }

    // index is the current index of the new node
    private void heapifyAbove(int index) {
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

    // lastHeapIndex = size - 1; will be used in Heapsort
    private void heapifyBelow(int parentIndex, int lastHeapIndex) {
        int swapWithChild;

        while(parentIndex <= lastHeapIndex) {
            int leftChild = getChildIndex(parentIndex, true);
            int rightChild = getChildIndex(parentIndex, false);
            if(leftChild <= lastHeapIndex) {
                // no right child, just left child
                if(rightChild > lastHeapIndex) {
                    swapWithChild = leftChild;
                } else {
                    // find the largest element to swap
                    swapWithChild = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                // swap with the largest of the two children nodes
                if(heap[parentIndex] < heap[swapWithChild]) {
                    int temp = heap[parentIndex];
                    heap[parentIndex] = heap[swapWithChild];
                    heap[swapWithChild] = temp;
                } else {
                    break;
                }
                parentIndex = swapWithChild;
            } else {
                break;
            }
        }
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

    public void printHeap() {
        System.out.print(Arrays.toString(heap));
//        for (int i = 0; i < size; i++) {
//            System.out.print(heap[i]);
//            System.out.print("   ");
//        }
//        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        System.out.println();

        heap.delete(1);
        heap.printHeap();
    }
}
