package com.namanh.binary_search_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree),
 * construct the tree and return its root.
 */
object ConstructBinarySearchTreeFromPreorderTraversal {
    var i = 0

    /**
     * We only traversal each node 1 time
     * Time: O(n)
     * Space: O(h)
     */
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        return bst(preorder, Int.MAX_VALUE)
    }

    private fun bst(preorder: IntArray, maxValue: Int): TreeNode? {
        if (i == preorder.size || preorder[i] > maxValue) return null
        val node = TreeNode(preorder[i++])
        node.left = bst(preorder, node.`val`)
        node.right = bst(preorder, maxValue)
        return node
    }

    /**
     * We can use binary search to improve, reduce time complexity to O(n * log(n))
     * Time: O(n^2)
     * Space: O(h)
     */
    fun bstFromPreorder1(preorder: IntArray): TreeNode? {
        return dfs(preorder, 0, preorder.size - 1)
    }

    private fun dfs(preorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val node = TreeNode(preorder[start])
        var i = start + 1
        while (i <= end && preorder[i] < preorder[start]) {
            i++
        }
        node.left = dfs(preorder, start + 1, i - 1)
        node.right = dfs(preorder, i, end)
        return node
    }
}