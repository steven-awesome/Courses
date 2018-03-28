package com.assignment3;

import java.util.*;

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

    /*
    * This is the method where the actual "merging" of the merge sort happens.
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





}
