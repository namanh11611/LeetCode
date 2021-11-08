package com.namanh.binary_search_tree;

import com.namanh.common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst
 * Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST.
 * If the given node has no in-order successor in the tree, return null.
 * The successor of a node p is the node with the smallest key greater than p.val.
 */
public class InorderSuccessorInBST {
    /**
     * Use BFS properties
     * S1: If p has right child, result is left most at the right subtree
     * S2: If p hasn't right child, result is one of the ancestors of p, which is greater than p and nearest
     * Time: O(n)
     * Space: O(1)
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeNode successor = null;
            while (root != p) {
                if (p.val > root.val) {
                    root = root.right;
                } else {
                    successor = root;
                    root = root.left;
                }
            }
            return successor;
        }
    }

    /**
     * Use BFS properties (Shorter)
     * Time: O(n)
     * Space: O(1)
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    /**
     * Use Inorder Traversal
     * Time: O(n)
     * Space: O(n)
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        boolean isInorderSuccessor = false;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (isInorderSuccessor) return root;
            if (root == p) isInorderSuccessor = true;
            root = root.right;
        }
        return null;
    }
}
