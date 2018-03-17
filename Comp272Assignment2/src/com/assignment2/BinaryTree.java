package com.assignment2;

public class BinaryTree {

    BTNode root;

    int size(BTNode u) {
        if (u == null) {
            return 0;
        }
        return 1 + size(u.left) + size(u.right);
    }

    void traverse(BTNode u) {
        if (u == null) {
            return;
        }
        traverse(u.left);
        traverse(u.right);
    }

    void traverse2() {
        BTNode u = root, prev = null, next;
        while (u != null) {
            if (prev == u.parent) {
                if (u.left != null) next = u.left;
                else if (u.right != null) next = u.right;
                else next = u.parent;
            } else if (prev == u.left) {
                if (u.right != null) next = u.right;
                else next = u.parent;
            } else {
                next = u.parent;
            }
            prev = u;
            u = next;
        }
    }

    public BTNode insert(BTNode root, BTNode node) {
        if (root == null) {
            root = node;
        } else if (Integer.compare(node.value, root.value) > 0) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
        return root;
    }



}
