package com.assignment2;

import java.lang.reflect.Array;

public class ScapegoatTree extends BinaryTree {

    boolean add(Integer x) {
        // first do basic insertion keeping track of depth
        BTNode u = newNode(x);
        int d = addWithDepth(u);
        if (d > log32(q)) {
            // depth exceeded, find scapegoat
            BTNode w = u.parent;
            while (3*size(w) <= 2*size(w.parent))
                w = w.parent;
            rebuild(w.parent);
        }
        return d >= 0;
    }

    boolean remove(Integer x) {
        if (super.remove(x)) {
            if (2*n < q) {
                rebuild(r);
                q = n;
            }
            return true;
        }
        return false;
    }

    void rebuild(BTNode u) {
        int ns = size(u);
        BTNode p = u.parent;
        BTNode[] a = (BTNode[]) Array.newInstance(BTNode.class, ns);
        packIntoArray(u, a, 0);
        if (p == null) {
            root = buildBalanced(a, 0, ns);
            root.parent = null;
        } else if (p.right == u) {
            p.right = buildBalanced(a, 0, ns);
            p.right.parent = p;
        } else {
            p.left = buildBalanced(a, 0, ns);
            p.left.parent = p;
        }
    }
    int packIntoArray(BTNode u, BTNode[] a, int i) {
        if (u == null) {
            return i;
        }
        i = packIntoArray(u.left, a, i);
        a[i++] = u;
        return packIntoArray(u.right, a, i);
    }
    BTNode buildBalanced(BTNode[] a, int i, int ns) {
        if (ns == 0)
            return null;
        int m = ns / 2;
        a[i + m].left = buildBalanced(a, i, m);
        if (a[i + m].left != null)
            a[i + m].left.parent = a[i + m];
        a[i + m].right = buildBalanced(a, i + m + 1, ns - m - 1);
        if (a[i + m].right != null)
            a[i + m].right.parent = a[i + m];
        return a[i + m];
    }
}
