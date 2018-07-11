package Sorting_Algorithms;

import java.util.Arrays;

public class MergeSort_Descending {
    public static void main(String[] args) {
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};

        mergesort_descend(intArray, 0, intArray.length);

        // print out the result
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }

    public static void mergesort_descend(int[] input, int start, int end) {
        // if there is only one element, it is sorted
        if(end - start < 2)
            return;

        int mid = (start + end) / 2;
        mergesort_descend(input, start, mid);
        mergesort_descend(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        // if the last element on the left sub-array is larger than the 1st element of the right sub-array
        // then it is sorted
        if(arr[mid - 1] >= arr[mid])
            return;

        int i = start; // first element on the left sub-array
        int j = mid; // first element on the right sub-array
        int index = 0;
        int[] aux = new int[end - start];
        while(i < mid && j < end) {
            aux[index++] = arr[i] >= arr[j] ? arr[i++] : arr[j++];
        }

        System.arraycopy(arr, i, arr, start + index, mid - i);
        System.arraycopy(aux, 0, arr, start, index);
    }
}
