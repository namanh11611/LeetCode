package com.namanh.two_pointers

/**
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds
 * You are given an integer array nums and two integers minK and maxK.
 * A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
 * - The minimum value in the subarray is equal to minK.
 * - The maximum value in the subarray is equal to maxK.
 * Return the number of fixed-bound subarrays.
 *
 * S1: Traversal the array, store left pointer as the first index of number in the range [minK, maxK]
 * S2: If right not in the range [minK, maxK], reset left pointer
 * S3: If right in the range [minK, maxK], find the maximum number of satisfied case
 *
 * Time: O(n)
 * Space: O(1)
 */
object CountSubarraysWithFixedBounds {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var minIndex = -1
        var maxIndex = -1
        var result = 0L
        var left = 0
        for (right in nums.indices) {
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1
                minIndex = -1
                maxIndex = -1
            } else {
                if (nums[right] == minK) minIndex = right
                if (nums[right] == maxK) maxIndex = right
                if (minIndex > -1 && maxIndex > -1) {
                    result += minOf(minIndex, maxIndex) - left + 1
                }
            }
        }
        return result
    }
}