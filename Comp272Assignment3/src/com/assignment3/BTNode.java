package com.assignment3;

public class BTNode {
    BTNode left;
    BTNode right;
    BTNode parent;
    Integer value;

    public BTNode(Integer value) {
        this.value = value;
    }

    public BTNode() {
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BTNode) {
            if (this.value == ((BTNode) o).value) {
                return true;
            }
        }
        return false;
    }
}
