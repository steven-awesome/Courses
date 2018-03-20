package com.assignment2;

import java.lang.reflect.Array;

import static java.util.Objects.hash;

public class HashTable<T> {
    T[] table;
    int n, d, q;

    public HashTable() {
        table = (T[]) Array.newInstance(Object.class, 13);
    }


    T find(T x) {
        int i = hash(x);
        while (!table[i].equals(null)) {
            if (table[i] != "del" && x.equals(table[i])) {
                return table[i];
            }
            i = (i == table.length-1) ? 0 : i + 1; // increment i
        }
        return null;
    }

    boolean add(T x) {
        if (find(x) != null) return false;
        if (2*(q+1) > table.length) resize();
        int index = hash(x) % 13;
        while (table[index] != null) {
            index++;
        }
        if (table[index] == null) q++;
        n++;
        table[index] = x;
        return true;
    }

    int hashTableCode(int x) {

        return x % 13;
    }

    void resize() {
        d = 1;
        while ((1<<d) < 3*n) d++;
        T[] told = table;
        table = (T[]) Array.newInstance(Object.class, 1 << d);
        q = n;
        // insert everything from told
        for (int k = 0; k < told.length; k++) {
            if (told[k] != null && told[k] != "del") {
                int i = hash(told[k]);
                while (table[i] != null)
                    i = (i == table.length-1) ? 0 : i + 1;
                table[i] = told[k];
            }
        }
    }
}
