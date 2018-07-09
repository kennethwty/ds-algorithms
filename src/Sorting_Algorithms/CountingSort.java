package Sorting_Algorithms;

import java.util.Arrays;

public class CountingSort {
    /*
        The Counting Sort algorithm is one that makes assumptions about the data and doesn't make comparisons.

        It only works with non-negative discrete number within a specific and reasonable range.

        It first goes through the input array to count the occurrences of each number to a separate array.

        Then, based on the counting array, the data get populated back to the input array and is sorted.

        For example:
                     input: 3 5 2 6 (range from 2 to 6)
               index array: 2 3 4 5 6
            counting array: 1 1 0 1 1 (create an array with range 2 to 6)

                    output: 2 3 5 6

        Analysis:
            Not in-place
            O(n) counting due to assumptions on data that we are sorting
            Unstable but can be made stable with Linked List
            If the array has 20 elements ranging from 1 - 1000, the counting array will have to have a size of 1000
     */
    public static void main(String[] args) {
        int[] intArray = {2, 5, 10, 3, 2, 7, 1, 11, 24};

        int minIndex = findMin(intArray);
        int maxIndex = findMax(intArray);

        countingSort(intArray, intArray[minIndex], intArray[maxIndex]);

        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }

    public static void countingSort(int[] arr, int min, int max) {
        int[] count = new int[max-min+1];

        // counting phase
        for(int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        System.out.println("Number of slots in count: " + count.length);
        System.out.println(Arrays.toString(count));

        // write back to input array
        int temp = 0;
        for(int i = min; i < max; i++) {
            while(count[i - min] > 0) { // there is an element in the slot
                arr[temp++] = i;
                // decrement the count by 1
                count[i - min]--;
            }
        }
    }

    public static int findMin(int[] input) {
        int minIndex = 0;
        int minValue = input[0];

        for(int i = 1; i < input.length; i++) {
            if(input[i] < minValue) {
                minIndex = i;
                minValue = input[i];
            }
        }
        return minIndex;
    }

    public static int findMax(int[] input) {
        int maxIndex = 0;
        int maxValue = input[0];

        for(int i = 1; i < input.length; i++) {
            if(input[i] > maxValue) {
                maxIndex = i;
                maxValue = input[i];
            }
        }
        return maxIndex;
    }
}
