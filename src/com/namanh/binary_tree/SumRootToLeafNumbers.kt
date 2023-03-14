package com.namanh.binary_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 * You are given the root of a binary tree containing digits from 0 to 9 only. Each root-to-leaf path in the tree
 * represents a number. For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123. Return the total sum
 * of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * S1: Use dfs, assign sum for child node
 *
 * Time: O(n)
 * Space: O(h)
 */
object SumRootToLeafNumbers {
    var sum = 0

    fun sumNumbers(root: TreeNode?): Int {
        calculateSum(root)
        return sum
    }

    private fun calculateSum(node: TreeNode?) {
        if (node == null) return
        if (node.left == null && node.right == null) {
            sum += node.`val`
        }
        node.left?.let {
            it.`val` += 10 * node.`val`
            calculateSum(it)
        }
        node.right?.let {
            it.`val` += 10 * node.`val`
            calculateSum(it)
        }
    }
}