package com.namanh.binary_tree;

/**
 * Link: https://leetcode.com/problems/maximum-depth-of-binary-tree
 * Question: Given the root of a binary tree, return its maximum depth.
 * S1: Get max value of left depth and right depth
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
