package com.namanh.binary_search_tree;

import com.namanh.common.TreeNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node
 * reference (possibly updated) of the BST.
 *
 * S1: If current value not equals key, call recursive function to left/right children
 * S2: If current node only have 1 child, return child
 * S3: Find the smallest child in right subtree
 * S4: Move current root.left to smallestNode.left
 * S5: Return currentNode.right
 *
 * Time: O(h), h is height of BST
 * Space: O(h)
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;

            TreeNode smallestNode = root.right;
            while (smallestNode.left != null) {
                smallestNode = smallestNode.left;
            }
            smallestNode.left = root.left;
            return root.right;
        }
        return root;
    }
}
