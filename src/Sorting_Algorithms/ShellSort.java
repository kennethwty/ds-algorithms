package Sorting_Algorithms;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] intArray = {6, 9, -1, 10, 10, 19, 2, 1, 17};

        // This Shell Sort implementation doesn't follow Dr. Knuth's idea of finding a gap,
        // rather, the gap is half of the size of the length of the array each round
        // until it gets to 0 where it then uses insertion sort

        for(int gap = intArray.length / 2; gap > 0; gap/=2) {
            for(int i = gap; i < intArray.length; i++) {
                int temp = intArray[i];
                int j = i;
                while(j >= gap && intArray[j-gap] > temp) {
                     intArray[j] = intArray[j-gap];
                     j-=gap;
                }
                intArray[j] = temp;
            }
        }

        // Print out the result
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }
}
