package com.assignment1;

//Using the books implementation of a SLList to be used in the exercises that need a SLList
public class SLList <T> {


    SLNode head;
    SLNode tail;
    int n;

    public SLList() {
        head = new SLNode();
        tail = new SLNode();
    }

    T push(T x) {
        SLNode u = new SLNode();
        u.x = x;
        if (n == 0) {
            head = u;
            tail = u;
            head.next = tail;
        } else {
            u.next = head;
            head = u;
        }
        n++;
        return x;
    }

    T pop() {
        if (n == 0) return null;
        T x = (T) head.x;
        head = head.next;
        if (--n == 0) tail = null;
        return x;
    }

    SLNode<T> getNode(int nodeIdx) {
        SLNode<T> temp = head;
        if (nodeIdx > n) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < nodeIdx; i++) {
            temp = temp.next;
        }
        return temp;
    }

}


