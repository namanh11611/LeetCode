package com.namanh.binary_search_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
 * changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * S1: Inorder traversal tree from right to left
 * S2: Create a variable to store suffix sum
 * S3: Each step, update suffix sum, assign for node value
 *
 * Time: O(n)
 * Space: O(h)
 */
object BinarySearchTreeToGreaterSumTree {
    private var sum = 0

    fun bstToGst(root: TreeNode?): TreeNode? {
        inorderTraversal(root)
        return root
    }

    private fun inorderTraversal(node: TreeNode?) {
        if (node == null) return
        inorderTraversal(node.right)
        sum += node.`val`
        node.`val` = sum
        inorderTraversal(node.left)
    }
}