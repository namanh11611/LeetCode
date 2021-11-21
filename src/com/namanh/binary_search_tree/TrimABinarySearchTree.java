package com.namanh.binary_search_tree;

import com.namanh.common.TreeNode;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that
 * all its elements lies in [low, high]
 *
 * S1: Use recursion approach
 * S2: If value < low, return node.right instead of current node
 * S3: If value > high, return node.left instead of current node
 * S4: If node null, return null
 * S5: Otherwise, trim both node.left and node.right
 *
 * Time: O(n)
 * Space: O(n)
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
