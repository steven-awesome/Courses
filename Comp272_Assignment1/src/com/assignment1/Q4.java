//Steven Morrissey
//Comp 272 - Assignment 1, Question 4
package com.assignment1;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Q4<T> {

    //Using Javas ArrayList as the underlying data structure as its an available structure with add and remove
    //operations that run at constant time.
    private ArrayList<T> queue;

    public Q4() {
        queue = new ArrayList<>();
    }

    public void add(T elm) {
        //ArrayList implementation of add() is constant
        queue.add(elm);
    }

    public void remove() {
        Random rand = new Random();
        //Using the ArrayList implementation of remove, the index is determined by a
        //random number who's max is the size of the container. This is done in constant time as remove is constant
        //for array implementations, and Random.nextInt is constant due to just performing calculations.
        queue.remove(rand.nextInt(queue.size() - 1));
    }

    public static void main(String[] args) {

    }

}
