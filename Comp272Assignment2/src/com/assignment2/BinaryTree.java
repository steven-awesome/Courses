package com.assignment2;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.compare;

public class BinaryTree {

    BTNode root;
    int n;

    boolean add(Integer x) {
        BTNode p = findLast(x);
        return addChild(p, new BTNode(x));
    }

    BTNode findLast(Integer x) {
        BTNode w = root, prev = null;
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

    boolean addChild(BTNode p, BTNode u) {
        if (p == null) {
            root = u;              // inserting into empty tree
        } else {
            int comp = compare(u.value, p.value);
            if (comp < 0) {
                p.left = u;
            } else if (comp > 0) {
                p.right = u;
            } else {
                return false;   // u.x is already in the tree
            }
            u.parent = p;
        }
        n++;
        return true;
    }

    int depth(BTNode u) {
        int d = 0;
        while (u != root) {
            u = u.parent;
            d++;
        }
        return d;
    }

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

    void bfTraverse() {
        Queue<BTNode> q = new LinkedList<BTNode>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            BTNode u = q.remove();
            if (u.left != null) q.add(u.left);
            if (u.right != null) q.add(u.right);
        }
    }

    Integer findEQ(Integer x) {
        BTNode u = root;
        while (u != null) {
            int comp = compare(x, u.value);
            if (comp < 0)
                u = u.left;
            else if (comp > 0)
                u = u.right;
            else
                return u.value;
        }
        return null;
    }

    public BTNode insert(BTNode root, BTNode node) {
        if (root == null) {
            root = node;
        } else if (compare(node.value, root.value) > 0) {
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

    public void rebuild() {

    }







    public void insert2(BTNode root, BTNode u) {
        if (root == null) {
            root = u;
        }
        if (u.value > root.value) {
            if (root.right != null) {
                root.right = u;
            } else {
                insert2(root.right, u);
            }
        } else {
            if (root.left != null) {
                root.left = u;
            } else {
                insert2(root.left, u);
            }
        }
    }

    void remove(BTNode u) {
        if (u.left == null || u.right == null) {
            splice(u);
        } else {
            BTNode w = u.right;
            while (w.left != null)
                w = w.left;
            u.value = w.value;
            splice(w);
        }
    }

    void splice(BTNode u) {
        BTNode s, p;
        if (u.left != null) {
            s = u.left;
        } else {
            s = u.right;
        }
        if (u == root) {
            root = s;
            p = null;
        } else {
            p = u.parent;
            if (p.left == u) {
                p.left = s;
            } else {
                p.right = s;
            }
        }
        if (s != null) {
            s.parent = p;
        }
        n--;
    }



}
