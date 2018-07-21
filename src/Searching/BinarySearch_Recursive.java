package Searching;

import java.util.Arrays;

public class BinarySearch_Recursive {
    public static void main(String[] args) {
        int[] intArray = {1235, 1345, 64254, -33, 4374, 246, -9675, 256, 46, 27, -246, 357};
        int search = 64254;
        // Dual-Pivot Quicksort: O(nlogn)
        Arrays.sort(intArray);

        int result = recursiveBinearySearch(intArray, 0, intArray.length, search);

        System.out.println("The sorted array is: " + Arrays.toString(intArray));
        System.out.println("Searching for " + search);
        if(result != -1)
            System.out.print("Target value found at index " + result);
        else
            System.out.print("Target not found");
    }

    public static int recursiveBinearySearch(int[] input, int start, int end, int target) {
        // base case
        if(start >= end)
            return -1;

        int mid = (start + end) / 2;

        if(input[mid] == target) {
            return mid;
        } else if(input[mid] < target) { // search the right sub-array
            return recursiveBinearySearch(input, mid + 1, end, target);
        } else { // search the left sub-array
            return recursiveBinearySearch(input, start, mid, target);
        }
    }
}
