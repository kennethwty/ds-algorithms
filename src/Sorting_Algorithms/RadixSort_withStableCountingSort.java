package Sorting_Algorithms;

import java.util.Arrays;

public class RadixSort_withStableCountingSort {
    public static void main(String[] args) {
        int[] intArray = {2342, 5673, 1025, 3351, 2683, 7324, 1679, 1039, 2416};

        radixsort(intArray, 10, 4);

        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }

    public static void radixsort(int[] arr, int radix, int width) {
        for(int i = 0; i < width; i++) {
            radixSingleSort(arr, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];
        for(int value : input) {
            // count how many values have a certain digit
            countArray[getDigit(position, value, radix)]++;
        }

        // stable count, adjust the countArray
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j-1];
        }

        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    public static int getDigit(int p, int v, int radix) {
        return v / (int) Math.pow(radix, p) % radix;
    }
}
