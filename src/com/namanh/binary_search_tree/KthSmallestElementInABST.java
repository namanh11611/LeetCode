package com.namanh.binary_search_tree;

import com.namanh.common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values
 * of the nodes in the tree.
 *
 * S1: Use stack to inorder traversal BST
 * S2: Return k-th element when pop from stack
 *
 * Time: O(n)
 * Space: O(n)
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodeStack = new Stack<>();
        while (true) {
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }
            root = nodeStack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
