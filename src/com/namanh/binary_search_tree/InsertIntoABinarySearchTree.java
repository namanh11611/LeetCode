package com.namanh.binary_search_tree;

import com.namanh.common.TreeNode;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node
 * of the BST after the insertion.
 *
 * S1: If val less than current node value, add to left right, otherwise, add to right child
 * S2: If node is null, create new node
 *
 * Time: Average O(log(n)), worst O(n)
 * Space: O(n)
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
