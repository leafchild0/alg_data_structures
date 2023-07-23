package com.leafchild.algorithms.sort;

import com.leafchild.algorithms.ArrayUtil;

/**
 * Quick sort implementation
 * Uses recursion to sort left and right sub arrays
 * @author: vmalyshev
 * Created: 8/18/16
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.createAndFillArray(100);

        System.out.println("Unsorted Array:");
        ArrayUtil.printArray(array);
        long start = System.currentTimeMillis();
        quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Sorted Array:");
        ArrayUtil.printArray(array);

        System.out.println("Consumed " + (end - start) + " milliseconds");
    }

    public static void quickSort(int[] array) {
        internalSort(array, 0, array.length - 1);
    }

    private static void internalSort(int[] data, int left, int right) {
        int pivot = data[left + (right - left) / 2];
        int i = left, j = right;

        while(i <= j) {
            while (data[i] < pivot) i += 1;
            while (data[j] > pivot) j -= 1;

            if(i <= j) {
                ArrayUtil.swapValues(data, i, j);
                i += 1;
                j -= 1;
            }
        }

        if(left < j) internalSort(data, left, j);
        if(i < right) internalSort(data, i, right);

    }

}
