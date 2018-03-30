//Steven Morrissey - 3300222
//Assignment 3 - Exercise 7
package com.assignment3;

import java.util.Random;

import static java.lang.Integer.compare;

public class Q7 {

    public static void main(String... args) {

        Q7 q7= new Q7();

        MeldableHeap mh1 = new MeldableHeap();
        mh1.add(5);
        mh1.add(50);
        //decided to just give a node to be removed rather than implement a find function...
        BTNode toRemove = mh1.add(25);
        mh1.add(33);
        mh1.add(100);
        mh1.add(12);
        //Traversing to show data before removal
        mh1.traverseHeap(mh1.root);
        System.out.println("=============");
        //Removing
        mh1.remove(toRemove);
        //Displaying data without removed node
        mh1.traverseHeap(mh1.root);


    }

}
