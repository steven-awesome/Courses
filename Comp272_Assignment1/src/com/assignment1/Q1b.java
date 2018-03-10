package com.assignment1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
* I don't fully understand this questions as Queues can be of many different types, LIFO, FIFO etc...
* Even if I use the books SLList implementation with uses Queue interface methods, Push and Pop can handle the Stack
* methods in just one single LinkedList. For this exercise I simply set list 2 (which technically implements Queue)
* to equal list 1 then use list 1 for Pushing and list 2 for Popping.
 */
public class Q1b <T> {
    SLList<T> list1 = new SLList<>();
    SLList<T> list2 = list1;

    public Q1b() {
    }

    public void push(T x) {
        list1.push(x);
    }

    public T pop() {
        return list2.pop();
    }

    public static void main(String[] args) {
        Q1b<Integer> q1b = new Q1b<>();
        q1b.push(2);
        q1b.push(5);
        q1b.push(3);
        //popping all 3 elements to show they come o
        System.out.println(q1b.pop());
        System.out.println(q1b.pop());
        System.out.println(q1b.pop());
    }
}
