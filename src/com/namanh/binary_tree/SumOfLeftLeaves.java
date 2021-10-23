package com.namanh.binary_tree;

/**
 * Link: https://leetcode.com/problems/sum-of-left-leaves
 * Question: Given the root of a binary tree, return the sum of all left leaves.
 * S1: Add param true if visit left node, false if visit right node
 * S2: Add value into sum if node is leaf
 */
public class SumOfLeftLeaves {
    int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root.left, true);
        dfs(root.right, false);
        return sum;
    }

    private void dfs(TreeNode node, boolean isLeftLeaf) {
        if (node == null) return;
        if (isLeftLeaf && node.left == null && node.right == null) sum += node.val;
        dfs(node.left, true);
        dfs(node.right, false);
    }
}
