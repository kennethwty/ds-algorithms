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

    /**
     * This method adds a new node before a specified item
     * @param beforeThis the new node will be placed before this node
     * @param newItem the new node
     */
    public void addBefore(Item beforeThis, Item newItem) {
        DoublyNode newNode = new DoublyNode();
        newNode.item = newItem;
        DoublyNode temp = head;
        if(head == null) {
            return;
        }
        if(head.item.equals(beforeThis)) {
            addFirst(newItem);
            return;
        }

        while(temp.next != null && !temp.next.item.equals(beforeThis)) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
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
        // print the list
        list.printList();
        // remove the extra "side" at the end
        list.removeLast();
        System.out.println();
        list.printList();
        // remove the extra "Hello" at the front
        list.removeFirst();
        System.out.println();
        list.printList();
        // add a phrase before hello
        list.addBefore("Hello", "Let's Get it!");
        System.out.println();
        list.printList();
        // add "other other" before "side"
        list.addBefore("side", "other other");
        System.out.println();
        list.printList();
        // add "or Hi!" before "from"
        list.addBefore("from", "or Hi");
        System.out.println();
        list.printList();
    }
}
