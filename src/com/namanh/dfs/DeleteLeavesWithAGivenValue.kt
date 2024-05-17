package com.namanh.dfs

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 *
 * S1: Use DFS to remove leaf node with given value
 *
 * Time: O(n)
 * Space: O(n)
 */
object DeleteLeavesWithAGivenValue {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        if (root == null) return null
        root.left = removeLeafNodes(root.left, target)
        root.right = removeLeafNodes(root.right, target)
        if (root.left == null && root.right == null && root.`val` == target) return null
        return root
    }
}
