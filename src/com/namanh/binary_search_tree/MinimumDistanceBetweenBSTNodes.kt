package com.namanh.binary_search_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different
 * nodes in the tree.
 *
 * S1: Use inorder traversal, we can iterate tree in ascending order
 * S2: Use prev variable to store previous value, calculate distance between prev and current node
 *
 * Time: O(n)
 * Space: O(h) with h is height of tree
 */
object MinimumDistanceBetweenBSTNodes {
    private var minDistance = Int.MAX_VALUE
    private var prev: TreeNode? = null

    fun minDiffInBST(root: TreeNode?): Int {
        inorder(root)
        return minDistance
    }

    private fun inorder(node: TreeNode?) {
        if (node == null) return
        inorder(node.left)
        prev?.let {
            minDistance = minOf(minDistance, node.`val` - it.`val`)
        }
        prev = node
        inorder(node.right)
    }
}