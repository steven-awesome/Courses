package com.assignment2;

import java.lang.reflect.Array;

public class ScapegoatTree extends BinaryTree {

    int q = n = 0;
    boolean addST(Integer x) {
        // first do basic insertion keeping track of depth
        BTNode u = insert(root, new BTNode(x));
        int d = depth(u);
        if (d > q / 1.5) {
            // depth exceeded, find scapegoat
            BTNode w = u.parent;
            while (3*size(w) <= 2*size(w.parent))
                w = w.parent;
            rebuild(w.parent);
        }
        return d >= 0;
    }

    void remove(Integer x) {
        super.remove(new BTNode(x));
        if (2*n < q) {
            rebuild(root);
            q = n;
        }
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

    public static void main(String[] args) {
        ScapegoatTree st = new ScapegoatTree();
        st.add(1);
        st.add(5);
        st.add(2);
        st.add(4);
        st.add(3);
        st.rebuild(st.findEQ(5));
        st.bfTraverse();
        System.out.println(st);
    }
}
