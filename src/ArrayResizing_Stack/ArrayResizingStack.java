package ArrayResizing_Stack;
import java.util.Iterator; //for the use foreach statements to loop thru the collection

public class ArrayResizingStack<Item> implements Iterable<Item> {
    private int size = 0; //number of elements, while arr.length is the length of array with cap size
    private Item[] arr = (Item[]) new Object[1];

    /**
     * Method isEmpty returns true if the stack has 0 elements, false otherwise
     * @return True or False
     */
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * Method size returns the number of elements currently in the stack
     * @return size Number of elements in the stack
     */
    public int size() {
        return size;
    }

    /**
     * Method push pushes an element into the array(stack)
     * @param item An element to be pushed
     */
    public void push(Item item) {
        //Resize only when there is no more room for a new item to be pushed
        //Call Resize with double the capacity
        if(size==arr.length)
            resize(2*arr.length);
        arr[size] = item;
        size++;
    }

    /**
     * Method pop pops an element from the top of the stack
     * @return p An element to be popped
     */
    public Item pop() {
        Item item = arr[--size];
        arr[size] = null; //Avoid loitering
        if(size>0 && size == (arr.length/4))
            resize(arr.length/2);

        return item;
    }

    public void resize(int cap) {
        Item[] biggerArray = (Item[]) new Object[cap]; //new array with double the size

        for(int i=0; i<arr.length; i++)
            biggerArray[i] = arr[i]; //copy the elements from the old array to the new one

        arr = biggerArray; //make the old array reference the new array
    }

    //For testing purposes, return the size of the array
    public int getArraySize() {
        return arr.length;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    //Inner class for Iterator
    public class StackIterator implements Iterator<Item> {
        private int i = size;

        public boolean hasNext() { return i>0; }
        public Item next() { return arr[--i]; }
        public void remove() { /* Nothing, avoided */ }
    }
}