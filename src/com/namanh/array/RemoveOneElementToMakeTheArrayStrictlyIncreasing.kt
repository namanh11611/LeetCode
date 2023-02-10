package com.namanh.array

/**
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing
 * Given a 0-indexed integer array nums, return true if it can be made strictly increasing after removing exactly one
 * element, or false otherwise. If the array is already strictly increasing, return true.
 *
 * S1: Use a flag to check we already remove 1 time
 * S2: When meet nums[i] >= nums[i+1], we can remove in cases:
 *     - i = 0: remove first element
 *     - i = n-2: remove last element
 *     - nums[i - 1] < nums[i + 1]: remove nums[i]
 *     - nums[i] < nums[i + 2]: remove nums[i+1]
 *
 * Time: O(n)
 * Space: O(1)
 */
object RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    fun canBeIncreasing(nums: IntArray): Boolean {
        val n = nums.size
        var isRemoveOneElement = false
        for (i in 0..n - 2) {
            if (nums[i] >= nums[i + 1]) {
                if (isRemoveOneElement) return false
                isRemoveOneElement = true
                if (i == 0 || i == n - 2
                    || nums[i - 1] < nums[i + 1]
                    || nums[i] < nums[i + 2]
                ) {
                    continue
                } else {
                    return false
                }
            }
        }
        return true
    }
}