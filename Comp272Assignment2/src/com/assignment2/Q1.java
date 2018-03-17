//Steven Morrissey - 3300222
//Comp272 - Assignment 2 Exercise 1

package com.assignment2;

import java.util.Stack;

public class Q1 {

   /*
   * preorderNext(x): return the node visited after node x in a pre-order traversal of BT.
   * postorderNext(x): return the node visited after node x in a post-order traversal of BT.
   * inorderNext(x): return the node visited after node x in an in-order traversal of BT.
   */

    public class BinaryTree {
        BTNode root;
        public BinaryTree(){}

        BTNode preOrderNext(BTNode x) {
            if (root == null) {
                return null;
            }
            Stack<BTNode> nodeStack = new Stack<>();
            boolean isNextNode = false;
            nodeStack.push(root);
            while (!nodeStack.isEmpty()) {
                BTNode node = nodeStack.pop();
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

        BTNode postOrderNext(BTNode x) {
            if (root == null) {
                return null;
            }
            Stack<BTNode> nodeStack = new Stack<>();
            boolean isRoot = true;
            boolean isNextNode = false;
            nodeStack.push(root);
            nodeStack.push(root.right);
            while (!nodeStack.isEmpty()) {
                if (nodeStack.peek().left != null) {
                    nodeStack.push(nodeStack.peek().left);
                    continue;
                }

                BTNode node = nodeStack.pop();

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

        BTNode inOrderNext(BTNode x) {
            if (root == null) {
                return null;
            }
            Stack<BTNode> nodeStack = new Stack<>();
            boolean isRoot = true;
            boolean isNextNode = false;
            nodeStack.push(root);
            while (!nodeStack.isEmpty()) {
                BTNode node = nodeStack.pop();
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

    public class BTNode {
        int value;
        BTNode left;
        BTNode right;

        BTNode() {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
