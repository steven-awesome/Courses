//Steven Morrissey - 3300222
//Comp 272 - Assignment 1, Question 1a
package com.assignment1;

/*
* add(x) inserts a new element at the end of the data structure; different implementations can also insert according to
* priority, subsequently rearrange according to priority, and/or also delete the smallest value to make space for the
* new higher priority element.
* deleteMin() deletes the lowest priority element.
* size() counts the number of elements currently in the data structure.
*/

/*
* I wasn't sure of the format for doing this question, so I used a SLList implementation based on the book,
* having only a Head Node and the methods treating it as a SLList while implementing the priority queue
* specific requirements.
*/
public class Q1a {
    SLList<Integer> list = new SLList<>();

    /*
    * This method runs at O(n) time, as the only real operations taking time here is the linear iteration through
    * the nodes until it finds the lowest value and the rest is all O(1)
     */
    public void add(Integer data) {
        SLNode<Integer> node = new SLNode<>();
        node.x = data;
        if (list.head == null) {
            list.head = node;
            return;
        }
        //creating a temp node so it can just iterate over itself
        SLNode<Integer> currentNode = list.head;
        while (currentNode.next != null) {
            if (node.x.intValue() <= currentNode.next.x.intValue()) {
                currentNode = currentNode.next;
            } else {
                break;
            }
        }
        node.next = currentNode.next;
        currentNode.next = node;
        list.n++;
    }

    /*
    * This method is also O(n) running time as it's doing another iteration through the nodes, with no other
    * operations taking more than O(1) time.
     */
    public void deleteMin() {
        SLNode<Integer> temp = list.head;
        if (temp == null) {
            //we could do error handling here, but for exercise purpose it just returns
            return;
        }
        if (temp.next == null) {
            temp = null;
            return;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        list.n--;
    }

    /*
    * This method is just O(1) time as it is just a direct accessor
     */
    public int size() {
        return list.n;
    }

    /*
    * This method is here for re-usability
     */
    public void iterateThroughList(SLList list) {
        SLNode<Integer> temp = list.head;
        while(temp.next != null) {
            //setting to temp.next right away to avoid getting NullPointer on head.x
            temp = temp.next;
            //Printing out to show that starting fom the head, the elements have been added
            //from highest to lowest value
            System.out.println(temp.x);
        }
        System.out.println("=====");
    }

    public static void main(String[] args) {
        //Adding a bunch of data nodes to my list unordered
        Q1a q1a = new Q1a();
        q1a.add(1);
        q1a.add(5);
        q1a.add(2);
        q1a.add(3);
        q1a.add(6);
        q1a.add(4);
        //Iterating through showing they are in order starting at the Head from largest value to smallest
        System.out.println("Printed list after adding all values to queue");
        q1a.iterateThroughList(q1a.list);

        q1a.deleteMin();
        //Iterating through to show the smallest value item is deleted after calling deleteMin()
        System.out.println("Printed list after deleteMin()");
        q1a.iterateThroughList(q1a.list);

    }
}