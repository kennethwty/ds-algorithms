package Trees;

import java.util.Arrays;

public class MinHeap_Resizing {
    private int initialCapacity;
    private int heapSize;
    private int[] heap;

    public MinHeap_Resizing() {
        this(10);
    }

    public MinHeap_Resizing(int initialSize) {
        this.initialCapacity = initialSize;
        this.heapSize = 0;
        heap = new int[initialSize];
    }

    public int peek() {
        if (heapSize == 0) {
            throw new IllegalStateException("Empty Heap");
        }
        return heap[0];
    }

    // insert elements
    public void put(int item) {
        // make sure there is enough space for insertion
        resizeTest();
        heap[heapSize] = item;
        heapSize++;
        // restructure the heap to ensure heap property is met
        heapifyAbove();
    }

    public int extractMin() {
        if (heapSize == 0) {
            throw new IllegalStateException("Empty Heap");
        }
        int min = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;
        heapifyBelow();
        return min;
    }

    private void heapifyAbove() {
        int index = heapSize - 1;
        // when the last element has a parent node and the parent node is greater
        while(hasParent(index) && parentValue(index) > heap[index]) {
            swap(getParentIndex(index), index);
            // update the index for the next round
            index = getParentIndex(index);
        }
    }

    private void heapifyBelow() {
        int index = 0;
        // while it has a child
        while(hasLeftChild(index)) {
            int minIndex = getLeftChildIndex(index);
            // if it also has a right child and the right child's value is smaller than the left child
            if(hasRightChild(index) && rightChildValue(index) < leftChildValue(index)) {
                minIndex = getRightChildIndex(index);
            }

            // check whether the parent value is smaller than or equal to its min child's value, if so, do nothing
            if(heap[index] <= heap[minIndex]) {
                break;
            } else {
                // greater, swap with min index
                swap(index, minIndex);
            }
            index = minIndex;
        }
    }

    // methods for getting indices
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // methods for getting the actual value of the nodes
    private int parentValue(int index) {
        return heap[getParentIndex(index)];
    }

    private int leftChildValue(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private int rightChildValue(int index) {
        return heap[getRightChildIndex(index)];
    }

    // methods for testing whether a node exists
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < heapSize;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < heapSize;
    }

    // regular setters and getters
    public int getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    // print the heap for testing
    public void printHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    // if full, resize the heap capacity
    private void resizeTest() {
        if (heapSize == initialCapacity) {
            // heap is full, resize with double the size
            heap = Arrays.copyOf(heap, initialCapacity * 2);
            initialCapacity = initialCapacity * 2;
        }
    }

    // swap two nodes
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public static void main(String[] args) {
        MinHeap_Resizing heap = new MinHeap_Resizing(10);

        heap.put(80);
        heap.put(75);
        heap.put(60);
        heap.put(68);
        heap.put(55);
        heap.put(40);
        heap.put(52);
        heap.put(67);

        heap.printHeap();

        System.out.println();

        //System.out.println();
        System.out.println("Root Node: " + heap.peek());

        System.out.println("Extracted Min Value: " + heap.extractMin());

        heap.printHeap();
    }
}
