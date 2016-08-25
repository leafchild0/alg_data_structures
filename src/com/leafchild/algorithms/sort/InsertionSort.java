package com.leafchild.algorithms.sort;

import com.leafchild.algorithms.ArrayUtil;

/**
 * Insertion sort implementation
 * Has main method for tests and some silly metrics
 * @author: vmalyshev
 * Created: 8/10/16
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.createAndFillArray(10);

        System.out.println("Unsorted Array:");
        ArrayUtil.printArray(array);
        long start = System.currentTimeMillis();
        insertionSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Sorted Array:");
        ArrayUtil.printArray(array);

        System.out.println("Consumed " + (end - start) + " miliseconds");
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = i;
            int insert = array[i];
            while(temp != 0 && array[temp - 1] > insert) {
                array[temp] = array[temp - 1];
                temp -= 1;
            }
            array[temp] = insert;
        }
    }

}
