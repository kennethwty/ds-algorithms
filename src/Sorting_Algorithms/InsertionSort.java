package Sorting_Algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};

        // j is the index of the first element of the unsorted portion of the array
        for(int j = 1 ; j < intArray.length; j++) {
            // save the element for inserting it later
            int temp = intArray[j];
            int i;
            for(i = j; i > 0 && temp < intArray[i-1]; i--) {
                intArray[i] = intArray[i-1];
            }
            // insert because it hits an element that is smaller than it
            intArray[i] = temp;
        }

        // Print out the result
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }
}
