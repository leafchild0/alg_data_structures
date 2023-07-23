package com.leafchild.algorithms.sort;

import com.leafchild.algorithms.ArrayUtil;

/**
 * Bubble sort implementation
 * Has main method for tests
 * @author: vmalyshev
 * Date : 8/10/16
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.createAndFillArray(30);

        System.out.println("Unsorted Array:");
        ArrayUtil.printArray(array);
        long start = System.currentTimeMillis();
        bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Sorted Array:");
        ArrayUtil.printArray(array);

        System.out.println("Consumed " + (end - start) + " milliseconds");

    }

    private static void bubbleSort(int[] array) {

        for (int i = array.length -1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1]) {
                    ArrayUtil.swapValues(array, j, j+1);
                }
            }
        }

    }



}
