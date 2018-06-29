package Sorting_Algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String args[]) {
        // This selection sort code finds the largest element of the array and puts it towards the end
        // instead of finding the smallest element and put it to the front as usually taught.
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};
        int arrLength = intArray.length;
        int largest = 0; //index of the largest element in the current round of traversing

        for(int lastUnsortedIndex = arrLength - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for(int i = 1; i <= lastUnsortedIndex; i++) {
                if(intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, largest, lastUnsortedIndex);
            largest = 0;
        }

        // Print out the result
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }

    /**
     * This method swaps two integers at indices i and j in an array
     */
    public static void swap(int[] arr, int i, int j) {
        //if same index, no need to swap of course
        if(i == j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
