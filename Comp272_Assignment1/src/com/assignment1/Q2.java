//Steven Morrissey - 3300222
//Comp 272 - Assignment 1, Question 2
package com.assignment1;

public class Q2 {
    SLList<Integer> sll = new SLList<>();
    DLList<Integer> dll = new DLList<>();

    /*
    * Gets the node to be switched and the next node, then adjusts the links so that current and next are swapped
     */
    public void swapAdjacentSinglyLinked(int nodeIdx) {
        SLNode<Integer> current = sll.getNode(nodeIdx);
        SLNode<Integer> next = current.next;
        sll.getNode(nodeIdx - 1).next = next;
        current.next = next.next;
        next.next = current;

    }

    /*
    * Gets the node to be switched, then adjusts all prev and next links of current.prev, current, current.next
    * and current.next.next so that current and current.next are swapped.
     */
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
        q.dll.push(1);
        q.dll.push(2);
        q.dll.push(3);
        q.dll.push(4);
        System.out.println(q.dll.get(1) + "" + q.dll.get(2));
        q.swapAdjacentDoublyLinked(1);
        System.out.println(q.dll.get(1) + "" + q.dll.get(2));
        q.sll.push(1);
        q.sll.push(2);
        q.sll.push(3);
        q.sll.push(4);
        System.out.println(q.sll.getNode(1).x + "" + q.sll.getNode(2).x);
        q.swapAdjacentSinglyLinked(2);
        System.out.println(q.sll.getNode(1).x + "" + q.sll.getNode(2).x);

    }


}
