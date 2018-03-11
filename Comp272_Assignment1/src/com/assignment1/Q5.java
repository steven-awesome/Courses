//Steven Morrissey - 3300222
//Comp 272 - Assignment 1, Question 5
package com.assignment1;

public class Q5 {
    DLList<Integer> dll = new DLList();

    //reverses the given DLList by creating a temp list and adding the original list Nodes in reverse.
    //made the method static and return the reversed list so it can be used without instantiation.
    public static DLList reverse(DLList list) {
        //creating a new list to add the reversed list to in order to return it
        DLList temp = new DLList();
        //running through list by getting list size
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(list.size() - i - 1));
        }
        return temp;
    }


    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=====");
        list = Q5.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
