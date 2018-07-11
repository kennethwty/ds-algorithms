package Sorting_Algorithms;

import java.util.Arrays;

public class InsertionSort_Recursive {
    public static void main(String[] args) {
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};

        insertionSort(intArray, intArray.length);

        // Print out the result
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }

    public static void insertionSort(int[] arr, int numItem) {
        // if there is only one element, it is sorted
        if(numItem < 2)
            return;

        // sort the first n - 1 items
        insertionSort(arr, numItem - 1);

        // save the element for inserting it later
        int temp = arr[numItem - 1];
        int i;
        for(i = numItem - 1; i > 0 && temp < arr[i-1]; i--) {
            arr[i] = arr[i-1];
        }
        // insert because it hits an element that is smaller than it
        arr[i] = temp;
    }
}
