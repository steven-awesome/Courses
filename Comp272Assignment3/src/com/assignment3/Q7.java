package com.assignment3;

import java.util.Random;

import static java.lang.Integer.compare;

public class Q7 {

    public static void main(String... args) {

        Q7 q7= new Q7();

        MeldableHeap mh1 = new MeldableHeap();
        mh1.add(5);
        mh1.add(50);
        mh1.add(25);
        mh1.add(33);
        mh1.add(100);
        mh1.add(12);

        mh1.remove(mh1.find(mh1.root, 25));

        System.out.println(mh1.find(mh1.root, 25).value);


    }

}
