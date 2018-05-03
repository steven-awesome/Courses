package com.assignment3;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Q4b {


    /*
    * java67 (2014/07) [Article] Retrieved from:
    * URL: http://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html
     */

    public static void quickSort(int[] arr, int low, int high) {

        //returned left pointer position so that each recursion sorts a different part
        //(subset) of the array
        int index = partition(arr, low, high);

        // recursively sort low half
        if (low < index - 1) {
            quickSort(arr, low, index - 1);
        }

        // recursively sort high half
        if (high > index)
            quickSort(arr, index, high);
    }

    public static int partition(int[] arr, int left, int right) {

        // Using the median of three with int optimization to choose pivot
        int middle = left + (right - left) / 2;
        int pivot = arr[middle];
        //Exchanging values around pivot while left pointer < right pointer
        while (left <= right) {
            while (arr[left] < pivot) {
                // moving left pointer to a number greater than pivot
                left++;
            }
            while (arr[right] > pivot) {
                //moving right pointer to find a number less than pivot
                right--;
            }
            if (left <= right) {
                //using tmp to swap left and right values
                int tmp = arr[left];
                //assigning right value to left
                arr[left] = arr[right];
                //assigning saved left temp value to right
                arr[right] = tmp;
                //moving left pointer up, right pointer down
                left++;
                right--;
            }
        }
        //left pointer position is returned as index
        return left;
    }

    public static void main(String... args) {
        int[] list = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};

        Q4b q4 = new Q4b();
        q4.quickSort(list, 0, list.length - 1);
        Arrays.stream(list).forEach(num -> System.out.println(num));
    }

}
