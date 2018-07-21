package Searching;

import java.util.Arrays;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = {1235, 1345, 64254, -33, 4374, 246, -9675, 256, 46, 27, -246, 357};
        int search = -246;

        int result = interativeBinearySearch(intArray, search);

        System.out.println("The sorted array is: " + Arrays.toString(intArray));
        System.out.println("Searching for " + search);
        if(result != -1)
            System.out.print("Target value found at index " + result);
        else
            System.out.print("Target not found");
    }

    public static int interativeBinearySearch(int[] input, int target) {
        int start = 0;
        int end = input.length;

        // Dual-Pivot Quicksort: O(nlogn)
        Arrays.sort(input);

        while(start < end) {
            int mid = (start + end) / 2;
            if(input[mid] == target) { // found it, return the index
                return mid;
            } else if(input[mid] < target) { // check the right sub-array
                start = mid + 1;
            } else { // check the left sub-array
                end = mid;
            }
        }

        return -1;
    }
}
