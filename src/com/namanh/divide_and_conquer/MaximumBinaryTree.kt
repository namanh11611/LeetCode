package com.namanh.divide_and_conquer

import com.namanh.common.TreeNode

/**
 * https://leetcode.com/problems/maximum-binary-tree
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums
 * using the following algorithm:
 * - Create a root node whose value is the maximum value in nums.
 * - Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * - Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 *
 * S1: Use recursive solution
 * S2: Find maximum value and it's index in sub array
 * S3: Create new node and return, continue with sub left and right array
 *
 * Time: O(n^2)
 * Space: O(n)
 */
class MaximumBinaryTree {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return createChildTree(nums, 0, nums.size - 1)
    }

    private fun createChildTree(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        if (start == end) return TreeNode(nums[start])

        var maxVal = nums[start]
        var maxIndex = start
        for (i in (start + 1)..end) {
            if (nums[i] > maxVal) {
                maxVal = nums[i]
                maxIndex = i
            }
        }
        val node = TreeNode(maxVal)
        node.left = createChildTree(nums, start, maxIndex - 1)
        node.right = createChildTree(nums, maxIndex + 1, end)
        return node
    }
}