package com.leafchild.algorithms.sort;

import com.leafchild.algorithms.ArrayUtil;

/**
 * Selection sort implementation
 * Has main method for tests and some silly metrics
 * @author: vmalyshev
 * Created: 8/10/16
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.createAndFillArray(10);

        System.out.println("Unsorted Array:");
        ArrayUtil.printArray(array);
        long start = System.currentTimeMillis();
        selectionSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Sorted Array:");
        ArrayUtil.printArray(array);

        System.out.println("Consumed " + (end - start) + " milliseconds");
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimum = i;
            for (int j = i; j < array.length; j++) {
                if (array[minimum] > array[j]) {
                    minimum = j;
                }
            }
            ArrayUtil.swapValues(array, i, minimum);
        }
    }
}
