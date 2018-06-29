package Sorting_Algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]) {
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};
        int endingIndex = intArray.length - 1;

        //endingIndex is the index of the last unsorted element
        for (int last = endingIndex; last > 0; last--) {
            for (int i = 0; i < last; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
//        for(int i = 0; i < intArray.length; i++) {
//            System.out.print(intArray[i] + " ");
//        }
    }

    /**
     * This method swaps two integers in an array
     * arr an integer array
     * i the value on the left of the bubble
     * j the value on the right of the bubble
     */
    public static void swap(int[] arr, int i, int j) {
        //if they the same index, no need to swap
        if (i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
