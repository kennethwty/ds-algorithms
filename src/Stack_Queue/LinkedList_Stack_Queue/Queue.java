package Stack_Queue.LinkedList_Stack_Queue;

import java.util.*;
public class Queue<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size = 0;

    public void enqueue(Item i) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = i;
        tail.next = null;

        //check if there is any element in the queue
        if(isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
        size++;
    }

    public Item dequeue() {
        Item item = (Item)head.item;
        head = head.next;
        size--;
        if(isEmpty()) {
            tail = null;
        }
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    //For the use of foreach statements by client
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node cur = head;
        public boolean hasNext() { return cur != null; }
        public Item next() {
            Item item = (Item)cur.item;
            cur = cur.next;
            return item;
        }
        public void remove() { }
    }
}
