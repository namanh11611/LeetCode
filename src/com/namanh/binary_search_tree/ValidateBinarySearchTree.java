package com.namanh.binary_search_tree;

import com.namanh.common.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * S1: Set range [min, max] for each node to check
 * S2: Left child: [min of parent, parent value - 1]
 * S3: Right child: [parent value + 1, max of parent]
 * S4: Handle edge cases, return when node value is min or max integer
 *
 * Time: O(n)
 * Space: O(n)
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validateNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateNode(TreeNode node, int minVal, int maxVal) {
        if (node == null) return true;
        if ((node.val == Integer.MIN_VALUE && node.left != null)
                || (node.val == Integer.MAX_VALUE && node.right != null)) return false;
        return node.val >= minVal && node.val <= maxVal
                && validateNode(node.left, minVal, node.val - 1)
                && validateNode(node.right, node.val + 1, maxVal);
    }
}
