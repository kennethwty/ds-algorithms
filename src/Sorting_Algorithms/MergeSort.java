package Sorting_Algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};

        mergesort(intArray, 0, intArray.length);

        // Print out the result
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }

    /**
     * @param arr input array
     * @param start starting index
     * @param end ending index + 1
     */
    public static void mergesort(int[] arr, int start, int end) {
        // if the array has only 1 element, return
        if(end - start < 2)
            return;

        // otherwise, get the mid index
        int mid = (start + end) / 2;

        // sort the first half (left sub-array)
        mergesort(arr, start, mid);
        // sort the second half (right sub-array)
        mergesort(arr, mid, end);
        // merge the two sort sub-arrays
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        // if the last element on the left sub-array is smaller than the 1st element of the right sub-array
        // then it is sorted
        if(arr[mid - 1] <= arr[mid])
            return;

        int i = start; // first element of the left sub-array
        int j = mid; // first element of the right sub-array
        int index = 0; // to keep track of the index on the temp array
        int[] temp = new int[end - start];

        while(i < mid && j < end) {
            // comparing the two sub-arrays to find the smaller element and it gets copied to the temp array
            temp[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        // if there are leftovers in the right sub-array, do nothing
        // if there are leftovers in the left sub-array, copy them to the temp array
        System.arraycopy(arr, i, arr, start + index, mid - i);
        System.arraycopy(temp, 0, arr, start, index);
    }
}
