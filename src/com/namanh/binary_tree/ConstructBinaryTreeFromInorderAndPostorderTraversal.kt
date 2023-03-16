package com.namanh.binary_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder
 * is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * inorder: b a c    x    n m p
 *          left  parent  right
 * postorder: b c a  n p m    x
 *            left   right  parent
 *
 * S1: Create a hashmap to store index of inorder
 * S2: Parent node is the last element in postorder, use divide and conquer to create left and right child
 *
 * Time: O(n)
 * Space: O(n)
 */
object ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private val iMap = mutableMapOf<Int, Int>()
    private var inorder = IntArray(0)
    private var postorder = IntArray(0)

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        for (i in inorder.indices) {
            iMap[inorder[i]] = i
        }
        this.inorder = inorder
        this.postorder = postorder
        val n = inorder.size
        return build(0, n - 1, 0, n - 1)
    }

    private fun build(iStart: Int, iEnd: Int, pStart: Int, pEnd: Int): TreeNode? {
        if (iStart > iEnd || pStart > pEnd) return null
        val value = postorder[pEnd]
        val node = TreeNode(value)
        val iIndex = iMap[value] ?: iStart
        val leftSize = iIndex - iStart
        node.left = build(iStart, iIndex - 1, pStart, pStart + leftSize - 1)
        node.right = build(iIndex + 1, iEnd, pStart + leftSize, pEnd - 1)
        return node
    }
}