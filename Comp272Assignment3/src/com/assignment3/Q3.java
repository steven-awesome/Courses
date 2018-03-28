//Steven Morrissey - 3300222
//Comp272 - Assignment 3 Exercise 3
package com.assignment3;

import java.util.Iterator;
import java.util.LinkedHashSet;

import static java.util.Arrays.asList;

public class Q3 {
    /*
    * For this question I chose to use the data structure LinkedHashSet, as I read about it
    * in the Java docs and it seemed to fit nicely. The underlying data structure is HashMap
    * with a Linked List running through it to keep insertion order, which I believe is important
    * to this question.
    *
    * The insertions into the LinkedHashSets are individually constant, so for the lists together its O(n).
    * The iterators are using the LinkedList part of the data structure, so they are O(n) as well.
    *
     */

    /*Creating 3 sets of data and adding them to the LinkedHashSets. Some have duplicate
    * entries which shows upon execution that they are ignored when inserting
    */
    LinkedHashSet<Integer> set1 = new LinkedHashSet<>(asList(1, 2, 3, 3, 4, 5, 7, 6));
    LinkedHashSet<Integer> set2 = new LinkedHashSet<>(asList(1, 2, 3, 3, 4, 5, 7, 6));
    //Same elements as above, but not the same insertion order
    LinkedHashSet<Integer> set3 = new LinkedHashSet<>(asList(1, 2, 3, 3, 5, 4, 7, 6));

    /*
    * using this method for abstracting the iterations from my main method
     */
    boolean checkEqualityOfSet(LinkedHashSet set1, LinkedHashSet set2) {
        Iterator<Integer> it1 = set1.iterator();
        Iterator<Integer> it2 = set2.iterator();
        //this variable will remain true if the 2 sets are equal.
        boolean isIdentical = true;
        while (it1.hasNext() && it2.hasNext()) {
            //looping through both at the same time and comparing the elements for order and equality
            if (!it1.next().equals(it2.next())) {
                isIdentical = false;
                //if one is found to not be equal, no need to keep going
                break;
            }

        }
        return isIdentical;
    }

    public static void main(String... args) {
        Q3 q3 = new Q3();


        System.out.println("Are set 1 and 2 the same?: " + q3.checkEqualityOfSet(q3.set1, q3.set2));
        System.out.println("Are set 1 and 4 the same?: " + q3.checkEqualityOfSet(q3.set1, q3.set3));
    }

}
