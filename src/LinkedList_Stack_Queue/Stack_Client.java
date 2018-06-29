package LinkedList_Stack_Queue;

public class Stack_Client {
    public static void main(String[] args) {
        Stack<Integer> num = new Stack<Integer>();
        num.push(7);
        num.push(19);
        num.push(93);
        int popped = num.pop();
        num.push(1);

        System.out.println("The popped element here is: " + popped);
        for(int i : num) {
            System.out.println(num.pop());
        }
    }
}
