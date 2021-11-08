package com.namanh.binary_search_tree;

import com.namanh.common.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
