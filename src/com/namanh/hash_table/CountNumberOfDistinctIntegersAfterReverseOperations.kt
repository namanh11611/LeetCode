package com.namanh.hash_table

/**
 * https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations
 * You are given an array nums consisting of positive integers. You have to take each integer in the array, reverse its
 * digits, and add it to the end of the array. Return the number of distinct integers in the final array.
 *
 * S1: Use set
 *
 * Time: O(n * m) m is length of number
 * Space: O(n)
 */
object CountNumberOfDistinctIntegersAfterReverseOperations {
    fun countDistinctIntegers(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (n in nums) {
            set.add(n)
            var old = n
            var new = 0
            while (old > 0) {
                new = 10 * new + old % 10
                old /= 10
            }
            set.add(new)
        }
        return set.size
    }
}