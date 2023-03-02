package com.namanh.binary_search_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees
 * Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in
 * ascending order.
 *
 * S1: Inorder traversal 2 tree
 * S2: Merge 2 tree
 *
 * Time: O(m + n)
 * Space: O(m + n)
 */
object AllElementsInTwoBinarySearchTrees {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        inorderTraversal(root1, list1)
        inorderTraversal(root2, list2)
        val m = list1.size
        val n = list2.size
        var i = 0
        var j = 0
        val result = mutableListOf<Int>()
        while (i < m && j < n) {
            while (i < m && list1[i] <= list2[j]) {
                result.add(list1[i++])
            }
            if (i == m) break
            while (j < n && list2[j] <= list1[i]) {
                result.add(list2[j++])
            }
        }
        while (i < m) {
            result.add(list1[i++])
        }
        while (j < n) {
            result.add(list2[j++])
        }
        return result
    }

    private fun inorderTraversal(node: TreeNode?, list: MutableList<Int>) {
        if (node == null) return
        inorderTraversal(node.left, list)
        list.add(node.`val`)
        inorderTraversal(node.right, list)
    }
}