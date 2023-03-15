package com.namanh.binary_tree

import com.namanh.common.TreeNode
import java.util.LinkedList

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree
 * Given the root of a binary tree, determine if it is a complete binary tree.
 * In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last
 * level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
object CheckCompletenessOfABinaryTree {
    /**
     * S1: Return false if finding out a non-null node after a null node
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun isCompleteTree(root: TreeNode?): Boolean {
        if (root == null) return true
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var haveNullNode = false
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node != null) {
                if (haveNullNode) return false
                queue.offer(node.left)
                queue.offer(node.right)
            } else {
                haveNullNode = true
            }
        }
        return true
    }

    /**
     * S1: Each level, compare expected size with current size
     * S2: Return false if finding out a non-null node after a null node
     *
     * Time: O(n)
     * Space: O(n)
     */
    fun isCompleteTree1(root: TreeNode?): Boolean {
        if (root == null) return true
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        var expectNumber = 1
        while (queue.isNotEmpty()) {
            val size = queue.size
            var endOfRow = false
            for (i in 1..size) {
                val node = queue.poll()
                if (node.left != null) {
                    if (endOfRow) return false
                    queue.offer(node.left)
                } else if (!endOfRow) {
                    endOfRow = true
                }
                if (node.right != null) {
                    if (endOfRow) return false
                    queue.offer(node.right)
                } else if (!endOfRow) {
                    endOfRow = true
                }
            }
            if (queue.isNotEmpty() && size != expectNumber) {
                return false
            }
            expectNumber = expectNumber shl 1
        }
        return false
    }
}