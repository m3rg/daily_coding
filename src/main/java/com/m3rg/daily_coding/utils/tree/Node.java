package com.m3rg.daily_coding.utils.tree;

public class Node {

    public String val;
    public Node left;
    public Node right;

    public Node(String val) {
        this.val = val;
    }

    public Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
