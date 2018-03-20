package com.assignment2;

import java.lang.reflect.Array;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.hash;

public class Q4 {



    public static void main(String[] args) {
        System.out.println(1<<4);
        System.out.println(2<<4);
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(4));
        /*List<Integer> list = asList(1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146);
        Q4 q4 = new Q4();
        HashTable<Integer> ht = new HashTable<>();
        list.forEach(item -> ht.add(item));
        for (Integer temp : ht.table) {
            System.out.println(temp);
        }*/
    }
}
