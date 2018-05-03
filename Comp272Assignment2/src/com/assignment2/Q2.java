//Steven Morrissey - 3300222
//Comp272 - Assignment 2 Exercise 2

package com.assignment2;


public class Q2 {

    /*
    * Recursively traverses the BST, and on every pass it checks if either left or right
    * child violate the BST property
     */
    public boolean satisfiesBST(BTNode current, boolean isBSTSatisfied) {
        if (current == null) {
            return false;
        }
        //checking the BST property is satisfied right away, and if so just return false so we
        //don't always have O(n)
        if (current.left != null && current.left.value > current.value ||
                current.right != null && current.right.value < current.value) {
            return false;
        }

        satisfiesBST(current.left, isBSTSatisfied);
        satisfiesBST(current.right, isBSTSatisfied);

        return isBSTSatisfied;
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        BinaryTree bt = new BinaryTree();
        bt.root = new BTNode(5);
        bt.root.left = new BTNode(10);
        bt.root.right = new BTNode(7);
        bt.root.left.left = new BTNode(2);
        bt.root.left.right = new BTNode(4);
        bt.root.right.left = new BTNode(6);
        bt.root.right.right = new BTNode(8);
        //Manually inserted node with value 10 to the left of the value 5 results in method returning false
        System.out.println(q2.satisfiesBST(bt.root, true));


        BinaryTree bt2 = new BinaryTree(5);
        bt2.add(8);
        bt2.add(3);
        bt2.add(4);
        bt2.add(9);
        //Normally added nodes into a BST returns true
        System.out.println(q2.satisfiesBST(bt2.root, true));

        BinaryTree bt3 = new BinaryTree(5);
        bt3.add(3);
        bt3.add(7);
        bt3.add(2);
        bt3.add(4);
        bt3.add(6);
        bt3.add(8);
        //Normally added nodes into a BST returns true
        System.out.println(q2.satisfiesBST(bt3.root, true));
    }
}
