package com.assignment1;

import java.util.LinkedList;

public class Q2 {
    SLList<Integer> sll = new SLList<>();
    DLList<Integer> dll = new DLList<>();

    public void swapAdjacentSinglyLinked(int nodeIdx) {
        SLNode<Integer> current = sll.get(nodeIdx);
        SLNode<Integer> next = current.next;
        sll.get(nodeIdx - 1).next = next;
        current.next = next.next;
        next.next = current;

    }

    public void swapAdjacentDoublyLinked(int nodeIdx) {
        DLNode<Integer> current = dll.getNode(nodeIdx);
        current.prev.next = current.next;
        current.next.next.prev = current;
        current.next.prev = current.prev;
        current.prev = current.next;
        current.next = current.prev.next;
        current.prev.next = current;

    }

    public static void main(String[] args) {
        Q2 q = new Q2();
        q.dll.add(1);
        q.dll.add(2);
        q.dll.add(3);
        q.dll.add(4);
        System.out.println(q.dll.get(1) + "" + q.dll.get(2));
        q.swapAdjacentDoublyLinked(1);
        System.out.println(q.dll.get(1) + "" + q.dll.get(2));
        q.sll.push(1);
        q.sll.push(2);
        q.sll.push(3);
        q.sll.push(4);
        System.out.println(q.sll.get(1).x + "" + q.sll.get(2).x);
        q.swapAdjacentDoublyLinked(1);
        System.out.println(q.sll.get(1).x + "" + q.sll.get(2).x);

    }


}
