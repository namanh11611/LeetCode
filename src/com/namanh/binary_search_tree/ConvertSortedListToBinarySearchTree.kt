package com.namanh.binary_search_tree

import com.namanh.common.TreeNode
import com.namanh.linked_list.ListNode

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced
 * binary search tree.
 */
object ConvertSortedListToBinarySearchTree {
    /**
     * S1: Find size of list
     * S2: Use a global variable to store current node and inorder traversal
     */
    var cur: ListNode? = null

    fun sortedListToBST(head: ListNode?): TreeNode? {
        cur = head
        var node = head
        var size = 0
        while (node != null) {
            node = node.next
            size++
        }
        return inorderTraversal(0, size - 1)
    }

    private fun inorderTraversal(left: Int, right: Int): TreeNode? {
        if (left > right) return null

        val mid = left + (right - left) / 2

        val leftChild = inorderTraversal(left, mid - 1)
        val node = TreeNode(cur?.`val` ?: 0)
        cur = cur?.next
        node.left = leftChild
        node.right = inorderTraversal(mid + 1, right)
        return node
    }

    /**
     * S1: Find size of list
     * S2: Use divide and conquer to create child tree with head and size
     *
     * Time: O(n * log(n))
     * Space: O(log(n))
     */
    fun sortedListToBST1(head: ListNode?): TreeNode? {
        var node = head
        var size = 0
        while (node != null) {
            node = node.next
            size++
        }
        return divideAndConquer(head, size)
    }

    private fun divideAndConquer(node: ListNode?, size: Int): TreeNode? {
        if (size == 0) return null
        var mid = node
        var index = 0
        while (index < size / 2) {
            mid = mid?.next
            index++
        }
        val top = TreeNode(mid?.`val` ?: 0)
        top.left = divideAndConquer(node, index)
        top.right = divideAndConquer(mid?.next, size - index - 1)
        return top
    }
}