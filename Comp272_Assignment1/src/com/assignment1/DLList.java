package com.assignment1;

//Using the books implementation of a DLList for the exercises that need a DLList
public class DLList <T>{
    private int n;
    DLNode dummy;
    DLList() {
        dummy = new DLNode();
        dummy.next = dummy;
        dummy.prev = dummy;
        n = 0;
    }

    DLNode getNode(int i) {
        DLNode p = null;
        if (i < n / 2) {
            p = dummy.next;
            for (int j = 0; j < i; j++)
                p = p.next;
        } else {
            p = dummy;
            for (int j = n; j > i; j--)
                p = p.prev;
        }
        return (p);
    }

    T get(int i) {
        return (T) getNode(i).data;
    }
    T set(int i, T x) {
        DLNode<T> u = getNode(i);
        T y = (T) u.data;
        u.data = x;
        return y;
    }

    void add(T a) {
        DLNode node = new DLNode();
        node.data = a;
        node.next = dummy;
        node.prev = dummy.prev;
        dummy.prev.next = node;
        dummy.prev = node;
        n++;
    }

    void push(T x) {
        DLNode node = new DLNode();
        node.data = x;
        node.prev = dummy;
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;
        n++;
    }

    int size() {
        return n;
    }

}
