//Steven Morrissey - 3300222
//Comp272 - Assignment 2 Exercise 5

package com.assignment2;

import java.util.Stack;

public class Q5 {

    /*
    *   Exercise 6.7.
    *   Create a subclass of BinaryTree whose nodes have fields for storing
        preorder, post-order, and in-order numbers. Write methods
        preOrderNumber(), inOrderNumber(), and postOrderNumbers()
        that assign these numbers correctly. These methods should each run in
        O(n) time.
     */

    public class BinaryOrderTree extends BinaryTree {
        BTOrderNode root;

        void preOrderNumber(Q1.BTNode x) {
            if (root == null) {
                return null;
            }
            Stack<Q1.BTNode> nodeStack = new Stack<>();
            boolean isNextNode = false;
            nodeStack.push(root);
            while (!nodeStack.isEmpty()) {
                Q1.BTNode node = nodeStack.pop();
                if(isNextNode) {
                    return node;
                }
                if (node == x) {
                    isNextNode = true;
                }
                if (node.right != null) {
                    nodeStack.push(node.right);
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                }
            }
            return null;
        }

        void postOrderNext(Q1.BTNode x) {
            if (root == null) {
                return null;
            }
            Stack<Q1.BTNode> nodeStack = new Stack<>();
            boolean isRoot = true;
            boolean isNextNode = false;
            nodeStack.push(root);
            nodeStack.push(root.right);
            while (!nodeStack.isEmpty()) {
                if (nodeStack.peek().left != null) {
                    nodeStack.push(nodeStack.peek().left);
                    continue;
                }

                Q1.BTNode node = nodeStack.pop();

                if (nodeStack.peek().right != null) {
                    nodeStack.push(nodeStack.peek().right);
                    continue;
                }


                if (isNextNode) {
                    return node;
                }
                if (node == x) {
                    isNextNode = true;
                }
            }
            return null;
        }

        void inOrderNext(Q1.BTNode x) {
            if (root == null) {
                return null;
            }
            Stack<Q1.BTNode> nodeStack = new Stack<>();
            boolean isRoot = true;
            boolean isNextNode = false;
            nodeStack.push(root);
            while (!nodeStack.isEmpty()) {
                Q1.BTNode node = nodeStack.pop();
                if(isNextNode) {
                    return node;
                }
                if (node == x) {
                    isNextNode = true;
                }
                if (node.right != null) {
                    nodeStack.push(node.right);
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                }
            }
            return null;
        }
    }

    public class BTOrderNode extends BTNode {

        int inOrderNumber;
        int preOrderNumber;
        int postOrderNumber;

        public BTOrderNode(Integer value) {
            super(value);
        }
    }
}
