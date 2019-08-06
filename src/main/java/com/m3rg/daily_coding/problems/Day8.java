/**
 * EASY
 * Tree
 * This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
 * 
 * https://www.youtube.com/watch?v=7HgsS8bRvjo
 */
package com.m3rg.daily_coding.problems;

import com.m3rg.daily_coding.utils.tree.Node;

public class Day8 {
    
    public static void main(String[] args) {
        Node root = new Node("1");
        root.left = new Node("1");
        root.right = new Node("1");
        root.right.left = new Node("1");
        root.right.right = new Node("0");
        root.right.left.left = new Node("1");
        root.right.left.right = new Node("1");
        Day8 obj = new Day8();
        int result = obj.countUnivalTree(root);
        System.out.println(result);
    }

    public int countUnivalTree(Node node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        if(node.left == null || node.right == null) {
            return 0;
        }
        int result = 0;
        if(node.left.val.equals(node.val) && node.right.val.equals(node.val)) {
            result = 1;
        }
        result += countUnivalTree(node.left);
        result += countUnivalTree(node.right);
        return result;
    }
}
