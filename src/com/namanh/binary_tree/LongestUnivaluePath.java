package com.namanh.binary_tree;

/**
 * Link: https://leetcode.com/problems/longest-univalue-path
 * Question: Given the root of a binary tree, return the length of the longest path, where each node in the path has
 * the same value.
 *           5                    1                   5
 *         /  \                 /  \                /   \
 *        4    5    => 2       4    5   => 2       5     5   => 4
 *      /  \    \            /  \    \           /  \  /  \
 *    1     1    5         4     4    5         5   5 5    5
 * S1: DFS, find left and right length of uni value
 * S2.1: If current node equals left child, get left depth and increase 1, or 0 otherwise
 * S2.2: If current node equals right child, get right depth and increase 1, or 0 otherwise
 * S3: Set current depth is sum of left and right dept, if greater max -> set max
 * S4: Return max(left, right depth) for current node
 */
public class LongestUnivaluePath {
    int maxLength;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftDepth = 0;
        int rightDepth = 0;
        if (node.left != null && node.val == node.left.val) {
            leftDepth += left + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            rightDepth += right + 1;
        }
        maxLength = Math.max(maxLength, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }
}
