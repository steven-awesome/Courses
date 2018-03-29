package com.assignment3;

import java.util.Objects;
import java.util.Random;

import static java.lang.Integer.compare;

public class MeldableHeap {
    int n;
    BTNode root;

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
        // now we know h1.x <= h2.x
        if (new Random().nextBoolean()) {
            h1.left = merge(h1.left, h2);
            h1.left.parent = h1;
        } else {
            h1.right = merge(h1.right, h2);
            h1.right.parent = h1;
        }
        return h1;
    }

    boolean add(Integer x) {
        BTNode u = new BTNode();
        u.value = x;
        if (n == 0) {
            root = u;
            n++;
            return true;
        }
        root = merge(u, root);
        root.parent = null;
        n++;
        return true;
    }

    BTNode find(BTNode root, Integer x) {
        if (root.value.equals(x)) {
            return root;
        } else {
            if (root.left != null) {
                return find(root.left, x);
            }
            if (root.right != null) {
                return find(root.right, x);
            }
            return root;
        }

    }

    BTNode remove(BTNode node) {
        BTNode mergedNode;
        if (node.left == null && node.right == null) {
            mergedNode = null;
        }
        mergedNode = merge(node.left, node.right);
        if (node.parent != null) {
            mergedNode.parent = node.parent;
            if (mergedNode.parent.left != null
                    && mergedNode.parent.left == node) {
                mergedNode.parent.left = mergedNode;
            } else {
                mergedNode.parent.right = mergedNode;
            }
        } else {
            mergedNode.parent = null;
        }
        return mergedNode;
    }
}
