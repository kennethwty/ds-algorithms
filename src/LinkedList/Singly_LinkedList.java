package LinkedList;

public class Singly_LinkedList<Item> {
    private Node head;

    // add new items to the tail of the list
    public void add(Item item) {
        Node newNode = new Node();
        newNode.item = item;

        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // remove a specific item from the list
    public void remove(Item item) {
        if(head.item == item) {
            head = head.next;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            if(temp.next.item == item) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Singly_LinkedList<String> list = new Singly_LinkedList<String>();
        list.add("5");
        list.add("10");
        list.add("2");
        list.add("19");
        list.add("7");
        list.printList();
        list.remove("10");
        System.out.println();
        list.printList();
    }
}
