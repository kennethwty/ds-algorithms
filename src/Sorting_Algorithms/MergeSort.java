package Sorting_Algorithms;

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};

        mergesort(intArray, 0, intArray.length);
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

    }
}
