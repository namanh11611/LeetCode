package com.namanh.bfs

import com.namanh.common.TreeNode
import java.util.LinkedList

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to
 * right, then right to left for the next level and alternate between).
 *
 * S1: Use Deque to store data for each level
 *
 * Time: O(n)
 * Space: O(n)
 */
object BinaryTreeZigzagLevelOrderTraversal {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var isReverse = false
        while (queue.isNotEmpty()) {
            val size = queue.size
            val childList = LinkedList<Int>()
            for (i in 1..size) {
                val node = queue.poll()
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
                if (isReverse) {
                    childList.addFirst(node.`val`)
                } else {
                    childList.addLast(node.`val`)
                }
            }
            result.add(childList)
            isReverse = !isReverse
        }
        return result
    }
}