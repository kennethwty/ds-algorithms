package Stack_Queue.LinkedList_Stack_Queue;

import java.util.*; //Iterator

public class Stack<Item> implements Iterable<Item> {
    private Node top; //top of stack
    private int size = 0; //number of elements in the list/stack

    public void push(Item i) {
        Node oldTop = top;
        top = new Node();
        top.item = i;
        top.next = oldTop;
        size++;
    }

    public Item pop() {
        Item oldItem = (Item)top.item;
        top = top.next;
        size--;
        return oldItem;
    }

    public boolean isEmpty() {
        return top == null; //can also check whether size is 0
    }

    public int size() {
        return size;
    }

    //for the use of foreach to go thru the list
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node cur = top;
        public boolean hasNext() { return cur != null; }
        public Item next() {
            Item item = (Item)cur.item;
            cur = cur.next;
            return item;
        }
        public void remove() { } //leave it empty
    }
}
