package Sorting_Algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};

        quicksort(intArray, 0, intArray.length);

        // Print out the result
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }

    // i: start index - starts scanning from left to right
    // j: end index - starts right to left
    // We can also use a shuffle method to shuffle the array into random order prior to sorting
    //
    public static void quicksort(int[] arr, int i, int j) {
        // make sure there is more than one element
        if(j - i < 2)
            return;

        // this is where the pivot element gets inserted to
        int insertIndex = partition(arr, i, j);
        // then recursively sort the left and right sub-arrays
        quicksort(arr, i, insertIndex);
        quicksort(arr, insertIndex + 1, j);
    }

    // This algorithm picks the first element of the sub-array as pivot
    public static int partition(int[] arr, int start, int end) {
        int pivotElement = arr[start];
        // indices for keeping track of the traversal
        int i = start;
        int j = end;

        while(i < j) {
            // i scans from L to R looking for values greater than the pivot
            // j scans from R to L looking for values less than the pivot
            // empty loop simply used to find the values
            while(i < j && arr[--j] > pivotElement);
            if(i < j) {
                arr[i] = arr[j];
            }
            // i's turn, searching for elements greater than the pivot
            while(i < j && arr[++i] < pivotElement);
            if(i < j) {
                arr[j] = arr[i];
            }
        }

        // i and j crossed
        arr[j] = pivotElement;
        return j;
    }
}
