package com.namanh.binary_tree;

/**
 * Link: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree
 * Question: Return the longest ZigZag path contained in a binary tree.
 * S1: DFS left and right child node to get path length
 * S2: Add params isLeftNode, get left or right path length
 * S3: Set max length if satisfy
 */
public class LongestZigZagPath {
    int maxLength;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, true);
        dfs(root.right, false);
        return maxLength;
    }

    private int dfs(TreeNode node, boolean isLeftNode) {
        if (node == null) return 0;
        int leftPath = dfs(node.left, true);
        int rightPath = dfs(node.right, false);
        int curLength;
        if (isLeftNode) {
            curLength = ++rightPath;
        } else {
            curLength = ++leftPath;
        }
        if (curLength > maxLength) maxLength = curLength;
        return curLength;
    }
}
