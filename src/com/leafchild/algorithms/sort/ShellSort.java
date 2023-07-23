package com.leafchild.algorithms.sort;

import com.leafchild.algorithms.ArrayUtil;

/**
 * Shell sort implementation
 * Gap of the sort is widely spread h = h*3 + 1
 * Has main method for tests and some silly metrics
 * @author: vmalyshev
 * Created: 8/17/16
 */
public class ShellSort {

    public static void shellSort(int[] array) {
        int inner, outer, temp;
        int h = 1;
        int size = array.length;

        while (h <= size / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < size; outer++) {
                temp = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.createAndFillArray(100);

        System.out.println("Unsorted Array:");
        ArrayUtil.printArray(array);
        long start = System.currentTimeMillis();
        shellSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Sorted Array:");
        ArrayUtil.printArray(array);

        System.out.println("Consumed " + (end - start) + " milliseconds");

    }

}
