package com.assignment2;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import static java.lang.Integer.compare;

/*
* This is the class for Q5. Some methods I just overloaded as they were already typed
* and was easier to do this way. The most important methods are the ordering methods anyway :).
* The implementation is based on the structure from the book with some modifications
 */
public class BinaryOrderTree extends BinaryTree {
    BTOrderNode BTOroot;

    class BTOrderNode extends BTNode {

        BTOrderNode left;
        BTOrderNode right;
        BTOrderNode parent;
        Integer value;

        int inOrderNumber;
        int preOrderNumber;
        int postOrderNumber;

        public BTOrderNode(Integer value) {
            this.value = value;
            this.inOrderNumber = 0;
            this.preOrderNumber = 0;
            this.postOrderNumber = 0;
        }

    }

    /*
    * Method is iterative as the word "recursive" was removed from the original exercise in our assignment
    * This method uses a stack to load up the nodes in pre-order, then pop them to add the order number.
     */
    void preOrderNumber() {
        if (BTOroot == null) {
            return;
        }
        Stack<BTOrderNode> nodes = new Stack<>();
        int index = 0;
        //Push root right away...
        nodes.push(BTOroot);
        BTOrderNode temp = BTOroot;
        while (!nodes.isEmpty()) {
            BTOrderNode node = nodes.pop();
            //assigning order number and incrementing index.
            node.preOrderNumber = ++index;
            if (node.right != null) {
                nodes.push(node.right);
            }
            if (node.left != null) {
                nodes.push(node.left);
            }
        }
    }

    /*
    * Method is iterative as the word "recursive" was removed from the original exercise in our assignment
    * This method uses a stack to load up the nodes in post-order, then pop them to add the order number.
    * Being post order,
     */
    void postOrderNumber() {
        if (BTOroot == null) {
            return;
        }

        int index = 1;

        Stack<BTOrderNode> stack = new Stack<>();
        BTOrderNode temp = BTOroot;
        stack.push(BTOroot);

        while (temp.left != null) {
            stack.push(temp.left);
            temp = temp.left;
        }
        temp = BTOroot;
        while (!stack.isEmpty()) {
            BTOrderNode current = stack.peek();

            //check if there are left children and if there are, check if they have already been assigned
            //a order #
            if (current.left != null && current.left.postOrderNumber == 0) {
                BTOrderNode tempLeft = current;
                while (tempLeft.left != null) {
                    stack.push(tempLeft.left);
                    tempLeft = tempLeft.left;
                }
                //once we are done adding all left children, we want to move to the next iteration
                //right away so we can peek it and start on that left subtree
                continue;
            }

            //checking for right child, and if it has already been assigned an order #
            if (current.right != null && current.right.postOrderNumber == 0) {
                stack.push(current.right);
            } else {
                //finally, if this node has no children, or all children have already been assigned
                //an order #, assign this node an order # and increment order index.
                stack.pop().postOrderNumber = index++;
            }
        }
    }

    /*
    * Method is iterative as the word "recursive" was removed from the original exercise in our assignment
    * This method uses a stack to load up the nodes in pre-order, then pop them to add the order number.
     */
    void inOrderNumber() {
        if (BTOroot == null) {
            return;
        }
        Stack<BTOrderNode> nodes = new Stack<>();
        //Starting order number at 1
        int index = 1;
        BTOrderNode node = BTOroot;
        nodes.push(BTOroot);
        //push all left nodes until null, as we start at the leftmost node in the tree
        while (node.left != null) {
            nodes.push(node.left);
            node = node.left;
        }
        while (!nodes.isEmpty()) {
            node = nodes.pop();
            //Attach order # and immediately increment the order index by 1 for the next node.
            node.inOrderNumber = index++;
            if (node.right != null) {
                //we get a right node and then traverse to its leftmost child
                BTOrderNode temp = node.right;
                while (temp != null) {
                    nodes.push(temp);
                    temp = temp.left;
                }
            }
        }
    }

    /*
    * method just to print all 3 order numbers of each node
     */
    void inOrderPrint(BTOrderNode node) {
        if (node.left != null) {
            inOrderPrint(node.left);
        }
        System.out.println("Node value: " + node.value + " In order num: " + node.inOrderNumber);
        System.out.println("Node value: " + node.value + " Pre order num: " + node.preOrderNumber);
        System.out.println("Node value: " + node.value + " Post order num: " + node.postOrderNumber);
        if (node.right != null) {
            inOrderPrint(node.right);
        }
    }

    boolean addAll(List<Integer> list) {
        for (Integer value : list) {
            add(value);
        }
        return true;
    }

    BTOrderNode add(Integer x) {
        BTOrderNode p = findLast(x);
        return addChild(p, new BTOrderNode(x)).get();
    }

    BTOrderNode findLast(Integer x) {
        BTOrderNode w = BTOroot, prev = null;
        while (w != null) {
            prev = w;
            int comp = compare(x, w.value);
            if (comp < 0) {
                w = w.left;
            } else if (comp > 0) {
                w = w.right;
            } else {
                return w;
            }
        }
        return prev;
    }

    Optional<BTOrderNode> addChild(BTOrderNode p, BTOrderNode u) {
        if (p == null) {
            BTOroot = u;              // inserting into empty tree
        } else {
            int comp = compare(u.value, p.value);
            if (comp < 0) {
                p.left = u;
            } else if (comp > 0) {
                p.right = u;
            } else {
                return Optional.of(new BTOrderNode(null));   // u.x is already in the tree
            }
            u.parent = p;
        }
        n++;
        return Optional.of(u);
    }
}

