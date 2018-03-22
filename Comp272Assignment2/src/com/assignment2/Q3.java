//Steven Morrissey - 3300222
//Comp272 - Assignment 2 Exercise 3

package com.assignment2;

import java.lang.reflect.Array;

public class Q3 {

    /*
    * Lemma 8.3. Starting with an empty ScapegoatTree any sequence of m add(x) and remove(x) operations
    * causes at most O(mlogm) time to be used by rebuild(u) operations.
    * Proof. To prove this, we will use a credit scheme. We imagine that each node stores a number of credits.
    * Each credit can pay for some constant, c, units of time spent rebuilding.
    * The scheme gives out a total of O(mlogm) credits and every call to rebuild(u) is paid for with credits stored at u.
    */

    /*1, 5, 2, 4, 5
    *           1
    *                 5
    *             2
    *               4
    */

    /*
    * In the above tree, once we get down to 4 of the original series,
    * the tree is then unbalanced. So far, 1 has 3 credits, 5 has 2 credits, 2 has 1 credit, 4 has 0 credits.
    * They are then packed into the array [1, 2, 4, 5] and 4 nodes / 2 = index 2, so index 2 is node 4.
    * The new tree is below after calling rebuild.
     */

    /*
    *               4
    *           2       5
    *       1     3
     */

    /*
    * I believe that both nodes 4 and 2 now have 1 credit each, as node 3 was inserted after the rebuild.
     */


}
