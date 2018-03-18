package com.assignment2;

public class RBTree {
    RBTNode root;
    final byte red = 0;
    final byte black = 0;

    void pushBlack(RBTNode u) {
        u.colour--;
        u.left.colour++;
        u.right.colour++;
    }
    void pullBlack(RBTNode u) {
        u.colour++;
        u.left.colour--;
        u.right.colour--;
    }

    void flipLeft(RBTNode u) {
        /*swapColors(u, u.right);
        rotateLeft(u);*/
    }

    void flipRight(RBTNode u) {
        /*swapColors(u, u.left);
        rotateRight(u);*/
    }

    /*boolean add(Integer x) {
        RBTNode u = newNode(x);
        u.colour = red;
        boolean added = add(u);
        if (added)
            addFixup(u);
        return added;
    }*/

    void addFixup(RBTNode u) {
        while (u.colour == red) {
            if (u == root) { // u is the root - done
                u.colour = black;
                return;
            }
            RBTNode w = u.parent;
            if (w.left.colour == black) { // ensure left-leaning
                flipLeft(w);
                u = w;
                w = u.parent;
            }
            if (w.colour == black)
                return; // no red-red edge = done
            RBTNode g = w.parent; // grandparent of u
            if (g.right.colour == black) {
                flipRight(g);
                return;
            } else {
                pushBlack(g);
                u = g;
            }
        }
    }

    /*boolean remove(Integer x) {
        RBTNode u = findLast(x);
        if (u == null || compare(u.value, x) != 0)
            return false;
        RBTNode w = u.right;
        if (w == null) {
            w = u;
            u = w.left;
        } else {
            while (w.left != null)
                w = w.left;
            u.value = w.value;
            u = w.right;
        }
        //splice(w);
        u.colour += w.colour;
        u.parent = w.parent;
        removeFixup(u);
        return true;
    }*/

    void removeFixup(RBTNode u) {
        while (u.colour > black) {
            if (u == root) {
                u.colour = black;
            } else if (u.parent.left.colour == red) {
                u = removeFixupCase1(u);
            } else if (u == u.parent.left) {
                u = removeFixupCase2(u);
            } else {
                u = removeFixupCase3(u);
            }
        }
        if (u != root) { // restore left-leaning property if needed
            RBTNode w = u.parent;
            if (w.right.colour == red && w.left.colour == black) {
                flipLeft(w);
            }
        }
    }

    RBTNode removeFixupCase1(RBTNode u) {
        flipRight(u.parent);
        return u;
    }

    RBTNode removeFixupCase2(RBTNode u) {
        RBTNode w = u.parent;
        RBTNode v = w.right;
        pullBlack(w); // w.left
        flipLeft(w); // w is now red
        RBTNode q = w.right;
        if (q.colour == red) { // q-w is red-red
            //rotateLeft(w);
            flipRight(v);
            pushBlack(q);
            if (v.right.colour == red)
                flipLeft(v);
            return q;
        } else {
            return v;
        }
    }

    RBTNode removeFixupCase3(RBTNode u) {
        RBTNode w = u.parent;
        RBTNode v = w.left;
        pullBlack(w);
        flipRight(w); // w is now red
        RBTNode q = w.left;
        if (q.colour == red) { // q-w is red-red
            //rotateRight(w);
            flipLeft(v);
            pushBlack(q);
            return q;
        } else {
            if (v.left.colour == red) {
                pushBlack(v); // both v's children are red
                return v;
            } else { // ensure left-leaning
                flipLeft(v);
                return w;
            }
        }
    }

    void rotateLeft(RBTNode u) {
        RBTNode w = u.right;
        w.parent = u.parent;
        if (w.parent != null) {
            if (w.parent.left == u) {
                w.parent.left = w;
            } else {
                w.parent.right = w;
            }
        }
        u.right = w.left;
        if (u.right != null) {
            u.right.parent = u;
        }
        u.parent = w;
        w.left = u;
        if (u == root) { root = w; root.parent = null; }
    }
    void rotateRight(RBTNode u) {
        RBTNode w = u.left;
        w.parent = u.parent;
        if (w.parent != null) {
            if (w.parent.left == u) {
                w.parent.left = w;
            } else {
                w.parent.right = w;
            }
        }
        u.left = w.right;
        if (u.left != null) {
            u.left.parent = u;
        }
        u.parent = w;
        w.right = u;
        if (u == root) { root = w; root.parent = null; }
    }
}
