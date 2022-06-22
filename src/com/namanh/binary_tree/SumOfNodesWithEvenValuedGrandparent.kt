package com.namanh.binary_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent
 * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no
 * nodes with an even-valued grandparent, return 0. A grandparent of a node is the parent of its parent if it exists.
 *
 * S1: Browser binary tree by BFS, store boolean value if parent is even
 * S2: Add all satisfied node to sum
 *
 * Time: O(n)
 * Space: O(h)
 */
class SumOfNodesWithEvenValuedGrandparent {
    var sum = 0
    fun sumEvenGrandparent(root: TreeNode?): Int {
        bfs(root, false)
        return sum
    }

    fun bfs(node: TreeNode?, isEvenParent: Boolean) {
        if (node == null) return
        if (isEvenParent) {
            sum += node.left?.`val` ?: 0
            sum += node.right?.`val` ?: 0
        }
        bfs(node.left, node.`val` % 2 == 0)
        bfs(node.right, node.`val` % 2 == 0)
    }
}