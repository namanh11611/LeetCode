package com.namanh.dfs

import com.namanh.common.TreeNode
import kotlin.math.abs

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree
 * You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n
 * coins in total throughout the whole tree. In one move, we may choose two adjacent nodes and move one coin from one
 * node to another. A move may be from parent to child, or from child to parent.
 * Return the minimum number of moves required to make every node have exactly one coin.
 *
 * S1: Each step, we have move all remain coins from current node to its parent or from parent to current node.
 *
 * Time: O(n)
 * Space: O(n)
 */
object DistributeCoinsInBinaryTree {
    fun distributeCoins(root: TreeNode?): Int {
        var move = 0
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0
            val left = dfs(node.left)
            val right = dfs(node.right)
            val coin = node.`val` - 1 + left + right
            move += abs(coin)
            return coin
        }
        dfs(root)
        return move
    }
}
