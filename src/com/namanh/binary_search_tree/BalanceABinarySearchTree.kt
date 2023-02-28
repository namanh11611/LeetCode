package com.namanh.binary_search_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is
 * more than one answer, return any of them.
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 */
object BalanceABinarySearchTree {
    fun balanceBST(root: TreeNode?): TreeNode? {
        val list = mutableListOf<Int>()
        inorderTraversal(list, root)
        return createTree(list, 0, list.size - 1)
    }

    private fun inorderTraversal(list: MutableList<Int>, node: TreeNode?) {
        if (node == null) return
        inorderTraversal(list, node.left)
        list.add(node.`val`)
        inorderTraversal(list, node.right)
    }

    private fun createTree(list: MutableList<Int>, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val mid = start + (end - start) / 2
        val node = TreeNode(list[mid])
        node.left = createTree(list, start, mid - 1)
        node.right = createTree(list, mid + 1, end)
        return node
    }
}