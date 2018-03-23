//Steven Morrissey - 3300222
//Comp272 - Assignment 2 Exercise 5

package com.assignment2;
import static java.util.Arrays.asList;

public class Q5 {

    public static void main(String[] args) {
        BinaryOrderTree bot = new BinaryOrderTree();
        //Adding a slightly balanced tree I picked at random
        bot.addAll(asList(6, 4, 5, 3, 8, 7, 9, 10));

        //Calling all order numbering methods then will print them all out with their orders.
        bot.preOrderNumber();
        bot.inOrderNumber();
        bot.postOrderNumber();
        bot.inOrderPrint(bot.BTOroot);
    }
}



