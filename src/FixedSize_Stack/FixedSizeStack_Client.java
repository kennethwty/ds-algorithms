package FixedSize_Stack;
import java.util.*;

public class FixedSizeStack_Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the max capacity: ");
        int cap = in.nextInt();
        System.out.print("How many elements to enter now? ");
        int num = in.nextInt();

        in.nextLine();
        FixedSizeStack<String> stack = new FixedSizeStack<String>(cap);

        //input Strings
        for(int i=0; i<num; i++) {
            System.out.print("Enter a String element: ");
            stack.push(in.nextLine());
        }

        for(int j=0; j<num; j++) {
            System.out.print(stack.pop() + " ");
        }
        in.close();
    }
}
