package com.namanh.binary_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree
 * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of
 * the values in its subtree. A subtree of root is a tree consisting of root and all of its descendants.
 *
 * S1: Calculate sum of child and count the number child node
 * S2: Calculate average and count if it is satisfied
 *
 * Time: O(n)
 * Space: O(h)
 */
class CountNodesEqualToAverageOfSubtree {
    var count = 0
    fun averageOfSubtree(root: TreeNode?): Int {
        bfs(root)
        return count
    }

    fun bfs(node: TreeNode?): IntArray {
        val pair = IntArray(2)
        if (node == null) return pair
        val leftPair = bfs(node.left)
        val rightPair = bfs(node.right)
        pair[0] = leftPair[0] + rightPair[0] + node.`val`
        pair[1] = leftPair[1] + rightPair[1] + 1
        if (pair[0] / pair[1] == node.`val`) count++
        return pair
    }
}