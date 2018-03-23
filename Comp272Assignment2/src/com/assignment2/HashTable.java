package com.assignment2;

import java.lang.reflect.Array;

import static java.util.Objects.hash;

/*
* This is the data structure for Q4.
* This class has its own hashing function of K mod 13, otherwise its a standard
* HashTable implementation from the book.
 */
public class HashTable<T> {
    T[] table;
    int n, d, q;
    private Class<T> tClass;

    //Using a technique to instantiate the underlying array with the class type
    public HashTable(Class<T> clazz) {
        table = (T[]) Array.newInstance(clazz, 13);
    }

    /*
    * So the reason why I call the Java has function is because since I made the table
    * generic, it was easier to get the int value from the hash, and then perform the
    * mod 13 calculation on it. The Java hash runs in O(n). I found choosing mod 13 as
    * the hash function strange because the table would resize at some point and then
    * you have to handle many more collisions if you always calc mod 13 for every entry.
     */
    int hashTableCode(T x) {

        return hash(x) % 13;
    }


    T find(T x) {
        int i = hashTableCode(x);
        while (table[i] != null) {
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
        int index = hashTableCode(x);
        while (table[index] != null) {
            index++;
        }
        if (table[index] == null) q++;
        n++;
        table[index] = x;
        return true;
    }

    T remove(T x) {
        int i = hashTableCode(x);
        while (table[i] != null) {
            T y = table[i];
            if (!y.equals("del") && x.equals(y)) {
                table[i] = (T) "del";
                n--;
                if (8*n < table.length) resize(); // min 12.5% occupancy
                return y;
            }
            i = (i == table.length-1) ? 0 : i + 1;  // increment i
        }
        return null;
    }

    void resize() {
        d = 1;
        while ((1<<d) < 3*n) d++;
        T[] told = table;
        table = (T[]) Array.newInstance(Integer.class, 1 << d);
        q = n;
        // insert everything from told
        for (int k = 0; k < told.length; k++) {
            if (told[k] != null && told[k] != "del") {
                int i = hashTableCode(told[k]);
                while (table[i] != null)
                    i = (i == table.length-1) ? 0 : i + 1;
                table[i] = told[k];
            }
        }
    }
}
