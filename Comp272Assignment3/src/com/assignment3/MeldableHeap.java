package com.assignment3;

import java.util.Objects;
import java.util.Random;

import static java.lang.Integer.compare;

public class MeldableHeap {
    int n;
    BTNode root;

    /*
    * Using merge to do the removal and restructure.
     */
    BTNode remove(BTNode node) {
        if (node == null) {
            return null;
        }
        BTNode mergedNode;
        mergedNode = merge(node.left, node.right);
        if (mergedNode == null) {
            return null;
        }
        //if parent is not null, need to update parent links
        if (node.parent != null) {
            mergedNode.parent = node.parent;
            if (mergedNode.parent.left != null
                    && mergedNode.parent.left == node) {
                mergedNode.parent.left = mergedNode;
            } else {
                mergedNode.parent.right = mergedNode;
            }
        } else {
            //Must be root node, make sure parent is null
            mergedNode.parent = null;
        }
        n--;
        return mergedNode;
    }

    BTNode merge(BTNode h1, BTNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (compare(h2.value, h1.value) < 0) {
            return merge(h2, h1);
        }
        if (new Random().nextBoolean()) {
            h1.left = merge(h1.left, h2);
            h1.left.parent = h1;
        } else {
            h1.right = merge(h1.right, h2);
            h1.right.parent = h1;
        }
        return h1;
    }

    BTNode add(Integer x) {
        BTNode u = new BTNode();
        u.value = x;
        if (n == 0) {
            root = u;
            n++;
            return root;
        }
        root = merge(u, root);
        root.parent = null;
        n++;
        return u;
    }

    public void traverseHeap(BTNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            traverseHeap(node.left);
        }
        System.out.println(node.value);
        if (node.right != null) {
            traverseHeap(node.right);
        }
    }
}
