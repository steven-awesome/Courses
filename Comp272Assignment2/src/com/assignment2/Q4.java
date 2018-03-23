//Steven Morrissey - 3300222
//Comp272 - Assignment 2 Exercise 4

package com.assignment2;

import java.util.List;
import static java.util.Arrays.asList;

public class Q4 {

    /*
    * The data structure and the hash K mod 13 method are implemented in the
    * Hashable class
     */
    public static void main(String[] args) {
        //static import of asList to make the data entry clean
        List<Integer> list = asList(1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146);
        //I pass in the class type so I could instantiate the underlying array easier.
        HashTable<Integer> ht = new HashTable<>(Integer.class);
        //Using forEach and lambda to make adding clean and one line
        list.forEach(item -> ht.add(item));
        for (Integer temp : ht.table) {
            System.out.println(temp);
        }
    }
}
