//Steven Morrissey - 3300222
//Comp272 - Assignment 2 Exercise 4

package com.assignment2;

import java.util.List;
import static java.util.Arrays.asList;

public class Q4 {



    public static void main(String[] args) {
        List<Integer> list = asList(1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146);
        Q4 q4 = new Q4();
        HashTable<Integer> ht = new HashTable<>(Integer.class);
        list.forEach(item -> ht.add(item));
        for (Integer temp : ht.table) {
            System.out.println(temp);
        }
    }
}
