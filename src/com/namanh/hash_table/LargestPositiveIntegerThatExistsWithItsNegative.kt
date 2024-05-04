package com.namanh.hash_table

/**
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
 * Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also
 * exists in the array. Return the positive integer k. If there is no such integer, return -1.
 *
 * S1: Use Set to check if -k exists
 *
 * Time: O(n)
 * Space: O(n)
 */
object LargestPositiveIntegerThatExistsWithItsNegative {
    fun findMaxK(nums: IntArray): Int {
        val set = nums.toSet()
        var max = -1
        for (num in nums) {
            if (num > max && set.contains(-num)) {
                max = num
            }
        }
        return max
    }
}
