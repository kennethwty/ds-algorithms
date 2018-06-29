package ArrayResizing_Stack;


//Test the Array Resizing Stack
public class ArrayResizingStack_Test {
    public static void main(String[] args) {
        ArrayResizingStack<Integer> stack = new ArrayResizingStack<Integer>();

        //Check the stack before pushing items
        System.out.println("Array size BEFORE pushing: " + stack.getArraySize());
        stack.push(5);
        stack.push(12);
        stack.push(3);
        stack.push(120);
        stack.push(98);
        //Check the stack size after pushing items into the stack
        System.out.println("Array size (expanded) AFTER pushing: " + stack.getArraySize());

        for(Integer i : stack)
            System.out.println(i);
    }
}
