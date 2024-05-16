package com.namanh.binary_tree

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/evaluate-boolean-binary-tree
 */
object EvaluateBooleanBinaryTree {
    fun evaluateTree(root: TreeNode?): Boolean {
        if (root == null) return false
        if (root.`val` <= 1) return root.`val` == 1
        if (root.`val` == 2) return evaluateTree(root.left) || evaluateTree(root.right)
        return evaluateTree(root.left) && evaluateTree(root.right)
    }
}
