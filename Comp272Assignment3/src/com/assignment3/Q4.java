package com.assignment3;

import java.util.*;

import static java.util.Arrays.asList;

public class Q4 {

    /*
    * Wikipedia (n.d.) [Article] Retrieved from:
    * URL: https://en.wikipedia.org/wiki/Merge_sort
    *
    *
    *
    * This is the main method that takes a list and through breaking it down into
    * smaller lists, adds them into another list in sorted order.
     */
    /*public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }

        //Creating 2 arrays to sort into.
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        //Copying first and 2nd halves into our split arrays
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        //Recursively sorting both arrays
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }*/

    public List<Integer> merge_sort(List<Integer> toBeSorted) {
        if (toBeSorted.isEmpty()) {
            return toBeSorted;
        }
        //Creating 2 lists to sort into. Using Array list as we'll be getting and adding.
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        //Iterating through the list to be sorted and adding first half to left, 2nd
        //half to right.
        for (int i = 0; i < toBeSorted.size() - 1; i++) {
            if (i < toBeSorted.size() / 2) {
                left.add(toBeSorted.get(i));
            } else {
                right.add(toBeSorted.get(i));
            }
        }
        ///calling the method recursively to break down and sort the lists
        left = merge_sort(left);
        right = merge_sort(right);
        return merge(left, right);
    }


    /* This is the method where the actual "merging" of the merge sort happens.
     * We take both lists and add them to another list in order.
     */

    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> it = left.iterator();
        Iterator<Integer> it2 = right.iterator();

        //Looping trough both iterators and adding whichever number is lower
        //on each pass
        while (it.hasNext() && it2.hasNext()) {
            int leftNext = it.next();
            int rightNext = it2.next();
            if (leftNext <= rightNext) {
                result.add(leftNext);
            } else {
                result.add(rightNext);
            }
        }
        //There will be some numbers left over in one of the list, so here is
        //where we add them back.
        while (it.hasNext()) {
            result.add(it.next());
        }
        while (it2.hasNext()) {
            result.add(it2.next());
        }
        return result;
    }


    public static void main(String... args) {
        List<Integer> list = asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        Q4 q4 = new Q4();
        List<Integer> sortedList = q4.merge_sort(list);
        sortedList.forEach(num -> System.out.println(num));
    }



}
