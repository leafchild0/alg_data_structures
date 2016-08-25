package com.leafchild.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Service class for useful array methods
 * @author: vmalyshev
 * Created: 8/10/16
 */
public class ArrayUtil {

    public static int[] createAndFillArray(int arraySize) {
        int[] array = new int[arraySize];
        Random r = new Random();
        for (int i = 0; i < arraySize; i++) {
            array[i] = r.nextInt(arraySize);
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void swapValues(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
