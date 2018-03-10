package com.assignment1;

public class Q5 {
    DLList<Integer> dll = new DLList();

    public DLList reverse(DLList list) {
        //creating a new list to add the reversed list to in order to return it
        DLList temp = new DLList();
        //running through list by getting list size
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(list.size() - i - 1));
        }
        return temp;
    }


    public static void main(String[] args) {
        Q5 rdll = new Q5();
        DLList<Integer> list = new DLList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=====");
        list = rdll.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
