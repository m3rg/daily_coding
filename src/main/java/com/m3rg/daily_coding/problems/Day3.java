/**
 * Medium
 * 
 * This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
 */
package com.m3rg.daily_coding.problems;

import java.util.StringTokenizer;

import com.m3rg.daily_coding.utils.tree.Node;

public class Day3 {

    public static void main(String[] args) {
        Node node = new Node("0");
        node.left = new Node("1");
        node.right = new Node("2");
        node.left.left = new Node("3");
        node.left.right = new Node("4");
        node.right.left = new Node("5");
        node.right.right = new Node("6");
        node.left.left.left = new Node("7");
        node.left.left.right = new Node("8");
        Day3 obj = new Day3();
        String s = obj.serialize(node);
        System.out.println(s);
        Node n = obj.deserialize(s);
        System.out.println(obj.serialize(n));

    }

    public String serialize(Node node) {
        StringBuilder sb = new StringBuilder();
        serialize(node, sb);
        return sb.toString();
    }

    private void serialize(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append(("#-"));
            return;
        }
        sb.append(node.val);
        sb.append("-");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    public Node deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        StringTokenizer st = new StringTokenizer(s, "-");
        return deserialize(st);
    }

    private Node deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }
        String val = st.nextToken();
        if (val.equals("#")) {
            return null;
        }
        Node node = new Node(val);
        node.left = deserialize(st);
        node.right = deserialize(st);
        return node;
    }
}
