package com.namanh.binary_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/same-tree
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * S1: Use recursion, compare value and check left and right child
 *
 * Time: O(n)
 * Space: O(n)
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true;
        return p?.`val` == q?.`val` && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}