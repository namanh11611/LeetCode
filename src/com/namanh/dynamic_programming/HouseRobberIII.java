package com.namanh.dynamic_programming;

import com.namanh.binary_tree.TreeNode;

/**
 * https://leetcode.com/problems/house-robber-iii
 * Q: Find the max sum with non-adjacent elements in binary tree.
 *
 * S1: Use DFS to visit binary tree
 * S2: To avoid Time limit, return an array have 2 elements
 *      First element: max sum at current node's children
 *      Second element: max sum at current node, we maybe use current node or not
 *          = max (current node + sum of grandchildren, sum of children)
 * S3: Return max (first element, second element) of DFS at root
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] maxSum = dfs(root);
        return Math.max(maxSum[0], maxSum[1]);
    }

    private int[] dfs(TreeNode node) {
        int[] curSum = new int[2];
        if (node == null) return curSum;

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Max sum at current node's children
        curSum[0] = left[1] + right[1];

        // Max sum at current node
        curSum[1] = Math.max(node.val + left[0] + right[0], curSum[0]);

        return curSum;
    }
}
