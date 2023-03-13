package com.namanh.binary_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/symmetric-tree
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * S1: Use recursion to compare 2 node left and right
 *
 * Time: O(n)
 * Space: O(n)
 */
object SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isMirror(root?.left, root?.right)
    }

    private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null || right == null) return left == right
        if (left.`val` != right.`val`) return false
        return isMirror(left.left, right.right) &&
                isMirror(left.right, right.left)
    }
}