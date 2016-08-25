package com.leafchild.algorithms.search;

import com.leafchild.algorithms.ArrayUtil;

import java.util.Arrays;

/**
 * Implementation of binary search
 * Has main method for tests
 * @author: vmalyshev
 * Created: 8/10/16
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = ArrayUtil.createAndFillArray(10);
        int value = 7;

        Arrays.sort(array);
        ArrayUtil.printArray(array);

        int position = binarySearch(array, value);
        if(position > 0) System.out.println("Found value " + value + " at: " + position +  " position");
        else System.out.println("Value " + value + " was not found in the array");
    }

    private static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        int position = -1;
        int middle;

        while(low <= high) {
            middle = (low + high)/2;

            if(array[middle] < value) low = middle + 1;
            else if(array[middle] > value) high = middle - 1;
            else {
                position = middle;
                break;
            }
        }
        return position;
    }

}
