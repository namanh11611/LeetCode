package com.namanh.array

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays
 * Given an integer array nums, return the number of subarrays filled with 0.
 *
 * S1: Count the number of zero subarray end at i
 *
 * Time: O(n)
 * Space: O(1)
 */
object NumberOfZeroFilledSubarrays {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var zeroCount = 0L
        var result = 0L
        for (num in nums) {
            if (num == 0) {
                zeroCount++
                result += zeroCount
            } else if (zeroCount > 0) {
                zeroCount = 0
            }
        }
        return result
    }
}