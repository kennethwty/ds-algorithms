/*
    This fixed-size array can be used to store elements other than String's.
 */
package FixedSize_Stack;

public class FixedSizeStack<Item> {
    private Item[] item; //holding the String input elements
    private int size = 0; //size of array

    /**
     * Fixed_StackOfStrings a constructor that initializes the array with cap of n
     * @param n Number of elements
     */
    public FixedSizeStack(int n) {
        item = (Item[]) new Object[n]; //cast it to Item since array cannot be created with Generics
    }

    /**
     * Method push pushes an element into the array(stack)
     * @param s An element to be pushed
     */
    public void push(Item s) {
        item[size++] = s;
    }

    /**
     * Method pop pops an element from the top of the stack
     * @return p An element to be popped
     */
    public Item pop() {
        Item p = item[--size];
        item[size] = null; //avoid loitering
        return p;
    }

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
}
