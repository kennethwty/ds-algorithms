package LinkedList;

public class Doubly_LinkedList<Item> {
    private DoublyNode head;
    private DoublyNode tail;

    // add new items to the tail of the list
    public void addLast(Item item) {
        DoublyNode newNode = new DoublyNode();
        newNode.item = item;
        // no element
        if(tail == null) {
            head = newNode;
        } else {
            // there is at least one element in the list, add to tail
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    //add new items to the head of the list
    public void addFirst(Item item) {
        DoublyNode newNode = new DoublyNode();
        newNode.item = item;
        // make the new node points to the current head
        newNode.next = head;
        // if there is a head
        if(head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
    }

    // remove an item from the tail
    public void removeLast() {
        // no element
        if(tail == null) {
            return;
        } else if(tail.prev == null) { // only one element
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    // remove an item from the head
    public void removeFirst() {
        // no element
        if(head == null) {
            return;
        } else if(head.next == null) { // only one element
            head = null;
            tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }

    }

    public void printList() {
        DoublyNode temp = head;
        while(temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Doubly_LinkedList<String> list = new Doubly_LinkedList<>();
        list.addFirst("side");
        list.addFirst("side");
        list.addFirst("other");
        list.addFirst("the");
        list.addFirst("from");
        list.addFirst("Hello");
        list.addFirst("Hello");
        list.printList();
        list.removeLast();
        System.out.println();
        list.printList();
        list.removeFirst();
        System.out.println();
        list.printList();
    }
}
