package com.assignment2;


public class Q2 {

    public boolean satisfiesBST(BTNode current, boolean isBSTSatisfied) {
        if (!isNodeValueNull(current)) {
            if (!isNodeValueNull(current.left) && current.left.value > current.value) {
                isBSTSatisfied = false;
            } else if (!isNodeValueNull(current.right) && current.right.value < current.value) {
                isBSTSatisfied = false;
            } else {
                isBSTSatisfied = true;
            }
        }

        if (current.left != null) {
            satisfiesBST(current.left, isBSTSatisfied);
        }
        if (current.right != null) {
            satisfiesBST(current.right, isBSTSatisfied);
        }
        return isBSTSatisfied;
    }

    private boolean isNodeValueNull(BTNode node) {
        return node == null || node.value == null;
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        BinaryTree bt = new BinaryTree();
        bt.root = new BTNode(5);
        bt.root.left = new BTNode(3);
        bt.root.right = new BTNode(7);
        bt.root.left.left = new BTNode(2);
        bt.root.left.right = new BTNode(4);
        bt.root.right.left = new BTNode(6);
        bt.root.right.right = new BTNode(8);

        System.out.println(q2.satisfiesBST(bt.root, true));

        BinaryTree bt2 = new BinaryTree();
        bt2.insert(bt2.root, new BTNode(5));
        bt2.insert(bt2.root, new BTNode(8));
        bt2.insert(bt2.root, new BTNode(3));
        bt2.insert(bt2.root, new BTNode(4));
        bt2.insert(bt2.root, new BTNode(9));

        System.out.println(q2.satisfiesBST(bt2.root, true));

    }
}
