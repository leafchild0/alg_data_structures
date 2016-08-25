package com.leafchild.algorithms.sort;

import com.leafchild.algorithms.ArrayUtil;

/**
 * Implementation of Merge Sort algorithm
 * @author: vmalyshev
 * Created: 8/17/16
 *
 * 1) Divide array in smaller arrays contains 1 elem:
 *  Calculate midpoint and and two arrays (left and right)
 *  Populate left and right arrays
 *  Run sort again with left and right arrays again
 *
 * 2) As soon as data gets divided, do a merge
 *  While there are element in the left or right sub arrays
 *  Check if left or right arrays has elems
 *  Check which element with specified indexes is smaller and put it as a result
 *  Increment appropriate counters
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = ArrayUtil.createAndFillArray(1000);

        System.out.println("Unsorted Array:");
        ArrayUtil.printArray(array);
        long start = System.currentTimeMillis();
        array = mergeSort(array);
        long end = System.currentTimeMillis();
        System.out.println("Sorted Array:");
        ArrayUtil.printArray(array);

        System.out.println("Consumed " + (end - start) + " miliseconds");
    }

    private static int[] mergeSort(int[] array) {
        int mid = array.length / 2;

        if (array.length == 1) {
            return array;
        }
        int[] left = new int[mid];
        int[] right;

        //Populate the arrays
        if (array.length % 2 == 0) {
            //it's even
            right = new int[mid];
        }
        else {
            right = new int[mid + 1];
        }
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        //Divide them
        left = mergeSort(left);
        right = mergeSort(right);

        //Merge the results back
        return merge(left, right);

    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int lIndex = 0, rIndex = 0, resIndex = 0;

        while (left.length > lIndex || right.length > rIndex) {
            //for both arrays all together
            if (lIndex < left.length && rIndex < right.length) {
                if (left[lIndex] <= right[rIndex]) {
                    result[resIndex] = left[lIndex];
                    lIndex += 1;
                }
                else {
                    result[resIndex] = right[rIndex];
                    rIndex += 1;
                }
                resIndex += 1;
            }
            //for remain values in left sub array
            else if (lIndex < left.length) {
                result[resIndex] = left[lIndex];
                lIndex += 1;
                resIndex += 1;
            }
            //for remain values in right sub array
            else if (rIndex < right.length) {
                result[resIndex] = right[rIndex];
                rIndex += 1;
                resIndex += 1;
            }
        }

        return result;
    }

}
