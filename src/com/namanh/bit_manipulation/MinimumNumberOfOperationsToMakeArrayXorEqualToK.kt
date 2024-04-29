package com.namanh.bit_manipulation

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k
 * You are given a 0-indexed integer array nums and a positive integer k. Return the minimum number of operations
 * required (flip bit) to make the bitwise XOR of all elements of the final array equal to k.
 *
 * S1: XOR all nums element and k
 * S2: Count number of 1 bit
 *
 * Time: O(n)
 * Space: O(1)
 */
object MinimumNumberOfOperationsToMakeArrayXorEqualToK {
    fun minOperations(nums: IntArray, k: Int): Int {
        var xorResult = k
        for (num in nums) {
            xorResult = xorResult xor num
        }
        return xorResult.countOneBits()
    }
}
