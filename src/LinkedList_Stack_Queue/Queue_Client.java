package LinkedList_Stack_Queue;

public class Queue_Client {
    public static void main(String[] args) {
        Queue<Integer> num = new Queue<Integer>();
        num.enqueue(7);
        num.enqueue(19);
        num.enqueue(93);
        num.enqueue(1);
        //System.out.println(num.dequeue());

        for(int i : num) {
            System.out.println(num.dequeue());
        }
    }
}
