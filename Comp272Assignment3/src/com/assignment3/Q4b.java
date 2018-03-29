package com.assignment3;

public class Q4b {


    /*
    * java67 (2014/07) [Article] Retrieved from:
    * URL: http://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html
     */

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
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
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
            }
        }
        return left;
    }

}
