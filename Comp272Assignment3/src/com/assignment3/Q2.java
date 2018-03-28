//Steven Morrissey - 3300222
//Comp272 - Assignment 3 Exercise 2
package com.assignment3;

import java.util.List;

import static java.util.Arrays.asList;

public class Q2 {
    /*
    2. (5 + 10 = 15 marks) Illustrate that via AVL single rotation, any binary search tree T1
    can be transformed into another search tree T2 (with the same items) (5 marks).  Give an
    algorithm to perform this transformation using O(N log N) rotation on average (10 marks).
     */

    /*
    * Any 2 binary trees with the same elements can be rotated until they are the same due
    * to the fact that if they maintain the BST properties,
     */

    private void rightRotate(BTNode node) {
        BTNode leftChild = node.left;
        if (node.left != null) {
            node.left = leftChild.right;
        }
        leftChild.right = node;
        if (node.parent != null) {
            if (node.parent.left.equals(node)) {
                node.parent.right = leftChild;
            } else {
                node.parent.left = leftChild;
            }
            node.parent.left = leftChild;
            node.parent = leftChild;
        }

    }

    private void leftRotate(BTNode node) {
        BTNode rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        if (node.parent != null) {
            if (node.parent.left != null && node.parent.left.equals(node)) {
                node.parent.right = rightChild;
            } else {
                node.parent.left = rightChild;
            }
            rightChild.parent = node.parent;
            node.parent = rightChild;
        }
    }
    private void handleRotations(BTNode node) {
        if (node.parent != null) {
            if (node.equals(node.parent.left)) {
                rightRotate(node);
            } else {
                leftRotate(node);
            }
        }
    }

    private BTNode makeNodeNewRoot(BTNode node, BinaryTree tree) {
        if (node.parent == null) {
            return node;
        }
        if (node.parent.equals(tree.root)) {
            handleRotations(node);
            return node;
        } else {
            handleRotations(node.parent);
        }
        return makeNodeNewRoot(node, tree);
    }

    /*public void transformTree(BinaryTree tree1, BTNode root1, BTNode root2) {
        if (!root1.equals(root2)) {
            makeNodeNewRoot(tree1.findEQ(root2.value), root2);
        }
        transformTree(tree1, root1.left, root2.left);
        transformTree(tree1, root1.right, root2.right);
        return;
    }*/

    public void transformTree2(BinaryTree tree1, BinaryTree tree2) {
        if (tree1.root == null || tree2.root == null) {
            return;
        }
        BTNode root = tree2.root;
        BinaryTree subTree1 = new BinaryTree(makeNodeNewRoot(tree1.findEQ(root.value), tree1));
        BinaryTree subTree2 = new BinaryTree(tree2.root.left);
        transformTree2(new BinaryTree(makeNodeNewRoot(tree1.findEQ(root.value), tree1).left),
                new BinaryTree(tree2.root.left));
        transformTree2(new BinaryTree(makeNodeNewRoot(tree1.findEQ(root.value), tree1).right),
                new BinaryTree(tree2.root.right));
    }

    public static void main(String... args) {
        Q2 q2 = new Q2();
        BinaryTree bt1 = new BinaryTree();
        BinaryTree bt2 = new BinaryTree();
        List<Integer> list1 = asList(5,1,3,2,4,7,6,9,8);
        List<Integer> list2 = asList(6,4,5,2,1,3,8,7,9);
        list1.forEach(bt1::add);
        list2.forEach(bt2::add);

        q2.transformTree2(bt1, bt2);

    }

}
