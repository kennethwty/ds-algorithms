package Sorting_Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] intArray = {60, 99, -14, 10, 13, 29, 23, 12, 17};

        bucketSort(intArray);

        // Print out the result
        System.out.print("Sorted Array: ");
        System.out.print(Arrays.toString(intArray));
    }

    public static void bucketSort(int[] arr) {
        // create an array of 10 lists as buckets
        // 10 buckets because the tenth digit can only be from 0-9
        List<Integer>[] buckets = new List[10];

        // create a linked list for each bucket
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<Integer>();
        }

        // scattering phase
        // for each int in the array, hash it
        for(int i = 0; i < arr.length; i++) {
            buckets[hash(arr[i])].add(arr[i]);
        }

        // sorting phase
        // for each bucket, sort using Collections.sort(), which is a merge sort from the JDK
        for(List bucket : buckets) {
            Collections.sort(bucket);
        }

        // gathering phase
        int temp = 0;
        for(int i = 0; i < buckets.length; i++) {
            for(int num : buckets[i]) {
                arr[temp++] = num;
            }
        }
    }

    private static int hash(int num) {
        return Math.abs(num / 10);
    }
}
