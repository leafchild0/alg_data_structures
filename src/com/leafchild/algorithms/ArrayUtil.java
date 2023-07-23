package com.leafchild.algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Service class for useful array methods
 * @author: vmalyshev
 * Created: 8/10/16
 */
public class ArrayUtil {

    public static int[] createAndFillArray(int arraySize) {
        return new Random()
            .ints(arraySize, 0, arraySize * 10)
            .distinct()
            .toArray();
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
