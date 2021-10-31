package com.namanh.binary_tree;

import com.namanh.common.TreeNode;

/**
 * Link: https://leetcode.com/problems/minimum-depth-of-binary-tree
 * Question: Given a binary tree, find its minimum depth.
 * S1: Get min value of left depth and right depth
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return 1;
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
