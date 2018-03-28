//Steven Morrissey - 3300222
//Comp272 - Assignment 2 Exercise 1

package com.assignment2;

import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;

public class Q1 {

   /*
   * preorderNext(x): return the node visited after node x in a pre-order traversal of BT.
   * postorderNext(x): return the node visited after node x in a post-order traversal of BT.
   * inorderNext(x): return the node visited after node x in an in-order traversal of BT.
   */



    public static void main(String... args) {
        BinaryTree bt = new BinaryTree();
        List<Integer> list = asList(5, 3, 4, 2, 1, 10, 9, 11, 7, 8);
        //Using forEach and lambda to make adding clean and one line
        list.forEach(item -> bt.add(item));

        /*
        * The prints done below show the worst case running times for the algorithms I've built.
        * Worst case is O(n) for every one as they have to traverse each node to reach the last node
        * that happens to be the one we're looking for.
         */

        //worst case for the series of numbers for inOrder is 10, as 11 will be the last node visited
        System.out.println(bt.inOrderNext(new BTNode(10)).get().value);
        //worst case for the series of numbers for preOrder is 8, as 11 will be the last node visited
        System.out.println(bt.preOrderNext(new BTNode(8)).get().value);
        //worst case for the series of numbers for inOrder is 10, as 5 will be the last node visited
        System.out.println(bt.postOrderNext(new BTNode(10)).get().value);

    }
}
