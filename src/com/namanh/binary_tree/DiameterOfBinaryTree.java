package com.namanh.binary_tree;

/**
 * Link: https://leetcode.com/problems/diameter-of-binary-tree
 * Question: Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * S1: Find max depth of each node
 * S2: Compare maxDiameter with leftDepth + rightDepth
 */
public class DiameterOfBinaryTree {
    int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
