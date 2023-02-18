package com.namanh.binary_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/invert-binary-tree
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Time: O(n)
 * Space: O(n)
 */
object InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val tmp = root.right
        root.right = invertTree(root.left)
        root.left = invertTree(tmp)
        return root
    }
}