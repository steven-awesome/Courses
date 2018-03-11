//Steven Morrissey - 3300222
//Comp 272 - Assignment 1, Question 4
package com.assignment1;

import java.util.HashMap;
import java.util.Random;

public class Q4<T> {

    //Using Javas HasMap as the underlying data structure as its an available structure with add and remove
    //operations that run at constant time (under well balanced conditions).
    public HashMap<Integer, T> map;

    public Q4() {
        map = new HashMap();
    }

    public void add(T elm) {
        //HashMap implementation of add() in well balanced scenario is constant
        map.put(map.size(), elm);
    }

    public void remove() {
        Random rand = new Random();
        //Using the HasMap implementation of remove, the index is determined by a
        //random number who's max is the size of the container. This is done in constant time as remove is constant
        //for well balanced HasMap implementations, and Random.nextInt is constant due to just performing calculations.
        map.remove(rand.nextInt(map.size()));
    }

    public static void main(String[] args) throws InterruptedException {

        Q4<Integer> q4 = new Q4<>();
        q4.add(1);
        q4.add(2);
        q4.add(3);
        q4.add(4);
        q4.add(5);
        System.out.println("Elements as added:");
        System.out.println(q4.map.toString());
        q4.remove();
        System.out.println("Elements with one removed at random:");
        System.out.println(q4.map.toString());

    }

}
